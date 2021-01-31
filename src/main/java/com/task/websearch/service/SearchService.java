package com.task.websearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.dto.PageStatusModel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Comparator;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

import static com.task.websearch.dto.Status.*;

@Service
@Slf4j
public class SearchService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    private int urlMax;

    private String searchText;

    private final AtomicInteger urlCount = new AtomicInteger(0);

    private final AtomicInteger doneCount = new AtomicInteger(0);

    private Queue<PageStatusModel> pageQueue;

    private WebSocketSession session;

    public void processData(InitialDataModel data, WebSocketSession session) {
        urlMax = data.getMaxUrlNum();
        searchText = data.getSearchText();
        pageQueue = new PriorityBlockingQueue<>(urlMax, Comparator.comparingInt(PageStatusModel::getId));
        this.session = session;
        doRecord(data.getUrl());

        ExecutorService service = Executors.newFixedThreadPool(data.getMaxThreadNum());

        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        service.execute(startProcess(service));
        completableFuture.complete(null);
        completableFuture.whenComplete((x, g) -> log.info("-------Finish"));
    }

    @SneakyThrows
    private Runnable startProcess(ExecutorService service) {
        return () -> {
            while (doneCount.get() < urlMax) {
                var model = pageQueue.poll();
                if (model != null) {
                    CompletableFuture<Void> completableFuture = new CompletableFuture<>();
                    service.execute(() -> {
                        downloadPage(model);
                        completableFuture.complete(null);
                    });
                    completableFuture.whenComplete((x, g) -> doneCount.incrementAndGet());
                }
            }
            service.shutdown();
            urlCount.set(0);
            doneCount.set(0);
            closeSession();
        };
    }

    private void closeSession() {
        while (session.isOpen()) {
            try {
                session.close();
            } catch (IOException e) {
                log.error("Failed to close session");
            }
        }
    }

    private void doRecord(String url) {
        if (urlMax != urlCount.get()) {
            var id = urlCount.incrementAndGet();
            var pageStatusModel = new PageStatusModel(id, url, STATUS_UPLOAD, false);
            pageQueue.add(pageStatusModel);
            log.info(pageStatusModel.toString());
            sendResult(pageStatusModel);
        }
    }

    private void downloadPage(PageStatusModel model) {
        if (model != null && !model.isProcessed()) {
            try {
                var pageContent = Jsoup.connect(model.getUrl()).get();
                var body = pageContent.body();
                if (urlMax != urlCount.get()) {
                    addLinksToQueue(body);
                }
                searchForTextMatches(model, body);
            } catch (IOException | IllegalArgumentException e) {
                updateDataInUi(model, STATUS_ERROR);
            }
        }
    }

    private void searchForTextMatches(PageStatusModel pageStatusModel, org.jsoup.nodes.Element body) {
        var text = body.text();
        if (!text.isEmpty() && text.contains(searchText)) {
            updateDataInUi(pageStatusModel, STATUS_FOUND);
        } else {
            updateDataInUi(pageStatusModel, STATUS_NOT_FOUND);
        }
    }

    private void addLinksToQueue(org.jsoup.nodes.Element body) {
        var links = body.select("a");
        if (!links.isEmpty()) {
            links.stream().map(element -> element.attr("href")).filter(u -> u.startsWith("http"))
                    .forEach(this::doRecord);
        }
    }

    private void updateDataInUi(PageStatusModel pageStatusModel, String statusFound) {
        pageStatusModel.setStatus(statusFound);
        pageStatusModel.setProcessed(true);

        log.info(pageStatusModel.toString());
        sendResult(pageStatusModel);
    }

    private void sendResult(PageStatusModel model) {
        String result;
        try {
            result = objectMapper.writeValueAsString(model);
            session.sendMessage(new TextMessage(result));
        } catch (IOException e) {
            log.error("Failed to send data");
        }
    }
}
