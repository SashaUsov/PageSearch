package com.task.websearch.service;

import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.dto.PageStatusModel;
import org.jsoup.Jsoup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

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
@Scope("prototype")
public class SearchService {

    private int urlMax;

    private String searchText;

    private final AtomicInteger urlCount = new AtomicInteger(0);

    private final AtomicInteger doneCount = new AtomicInteger(0);

    private Queue<PageStatusModel> pageQueue;

    public void processData(InitialDataModel data) {
        urlMax = data.getMaxUrlNum();
        searchText = data.getSearchText();
        pageQueue = new PriorityBlockingQueue<>(urlMax, Comparator.comparingInt(PageStatusModel::getId));
        doRecord(data.getUrl());

        ExecutorService service = Executors.newFixedThreadPool(data.getMaxThreadNum());

        CompletableFuture<Void> completableFuture = new CompletableFuture<>();

        service.execute(startProcess(service));
        completableFuture.complete(null);
        completableFuture.whenComplete((x, g) -> System.out.println("-------Finish"));
    }

    private Runnable startProcess(ExecutorService service) {
        return () -> {
            while (doneCount.get() <= urlMax) {
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
        };
    }

    public void doRecord(String url) {
        if (urlMax != urlCount.get()) {
            var id = urlCount.incrementAndGet();
            var pageStatusModel = new PageStatusModel(id, url, STATUS_UPLOAD, false);
            pageQueue.add(pageStatusModel);
            System.out.println(pageStatusModel);
            //send pageStatusModel to Kafka
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
            } catch (IOException e) {
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

        System.out.println(pageStatusModel + "  " + Thread.currentThread().getName());
        //send pageStatusModel to Kafka
    }
}
