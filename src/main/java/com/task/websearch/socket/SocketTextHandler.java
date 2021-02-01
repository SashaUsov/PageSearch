package com.task.websearch.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.dto.PageStatusModel;
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
        var dataModel = toModel(session, message);
        if (dataModel != null) {
            try {
                searchService.processData(dataModel, session);
            } catch (IllegalArgumentException e) {
                notValidDataMessage(session);
            }
        }
    }

    private InitialDataModel toModel(WebSocketSession session, TextMessage message) throws IOException {
        var payload = message.getPayload();
        InitialDataModel dataModel = null;
        try {
            var model = objectMapper.readValue(payload, InitialDataModel.class);
            if (validateRequest(model)) dataModel = model;
            else notValidDataMessage(session);
        } catch (IOException e) {
            notValidDataMessage(session);
        }
        return dataModel;
    }

    private void notValidDataMessage(WebSocketSession session) throws IOException {
        var model = new PageStatusModel("Not valid input");
        var error = objectMapper.writeValueAsString(model);
        session.sendMessage(new TextMessage(error));
    }

    private boolean validateRequest(InitialDataModel dataModel) {
        return dataModel != null && dataModel.getMaxThreadNum() > 0 && dataModel.getMaxUrlNum() > 0
                && (dataModel.getSearchText() != null && !dataModel.getSearchText().isEmpty())
                && (dataModel.getUrl() != null && !dataModel.getUrl().isEmpty() && dataModel.getUrl().startsWith("http"));
    }
}