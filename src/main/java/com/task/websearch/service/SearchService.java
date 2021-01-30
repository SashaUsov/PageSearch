package com.task.websearch.service;

import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.dto.PageStatusModel;
import org.jsoup.Jsoup;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static com.task.websearch.dto.Status.*;

@Service
public class SearchService {

    private int threadMax;

    private int urlMax;

    private String searchText;

    private final AtomicInteger urlCount = new AtomicInteger(0);

    private final Map<String, PageStatusModel> pages = new HashMap<>();

    private final Deque<String> pageQueue = new ArrayDeque<>();

    public void processData(InitialDataModel data) {

        threadMax = data.getMaxThreadNum();
        urlMax = data.getMaxUrlNum();
        searchText = data.getSearchText();

        doRecord(data.getUrl());
        while (!pageQueue.isEmpty()) {
            startProcess();
        }
        pages.clear();
        urlCount.set(0);
    }

    public void doRecord(String url) {
        if (urlMax != urlCount.get()) {
            pageQueue.addLast(url);
            var id = urlCount.incrementAndGet();
            var pageStatusModel = new PageStatusModel(id, url, STATUS_UPLOAD, false);
            pages.put(url, pageStatusModel);
            System.out.println(pageStatusModel);
            //send pageStatusModel to Kafka
        }
    }

    public void startProcess() {
        var url = pageQueue.poll();
        if (url != null) {
            var pageStatusModel = pages.get(url);
            if (pageStatusModel != null && !pageStatusModel.isProcessed()) {
                downloadPage(url, pageStatusModel);
            }
        }
    }

    private void downloadPage(String url, PageStatusModel pageStatusModel) {
        try {
            var pageContent = Jsoup.connect(url).get();
            var body = pageContent.body();
            if (urlMax != urlCount.get()) {
                addLinksToQueue(body);
            }
            searchForTextMatches(url, pageStatusModel, body);
        } catch (IOException e) {
            updateDataInUi(url, pageStatusModel, STATUS_ERROR);
        }
    }

    private void searchForTextMatches(String url, PageStatusModel pageStatusModel, org.jsoup.nodes.Element body) {
        var text = body.text();
        if (!text.isEmpty() && text.contains(searchText)) {
            updateDataInUi(url, pageStatusModel, STATUS_FOUND);
        } else {
            updateDataInUi(url, pageStatusModel, STATUS_NOT_FOUND);
        }
//            System.out.println(text.contains(data.getSearchText()));
    }

    private void addLinksToQueue(org.jsoup.nodes.Element body) {
        var links = body.select("a");
        if (!links.isEmpty()) {
            links.stream().map(element -> element.attr("href")).filter(u -> u.startsWith("http"))
                    .forEach(this::doRecord);
//            links.forEach(System.out::println);
        }
    }

    private void updateDataInUi(String url, PageStatusModel pageStatusModel, String statusFound) {
        pageStatusModel.setStatus(statusFound);
        pageStatusModel.setProcessed(true);
        pages.put(url, pageStatusModel);
        System.out.println(pageStatusModel);
        //send pageStatusModel to Kafka
    }
}
