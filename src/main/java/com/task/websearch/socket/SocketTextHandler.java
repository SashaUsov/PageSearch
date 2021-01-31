package com.task.websearch.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.service.SearchService;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

    private final SearchService searchService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public SocketTextHandler(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws IOException {
        var payload = message.getPayload();
        var dataModel = objectMapper.readValue(payload, InitialDataModel.class);
        searchService.processData(dataModel, session);
    }
}