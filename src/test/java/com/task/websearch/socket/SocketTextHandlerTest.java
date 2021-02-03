package com.task.websearch.socket;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

import static com.task.websearch.utils.SocketTextHandlerTestHelper.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class SocketTextHandlerTest {

    @InjectMocks
    SocketTextHandler socketTextHandler;

    @Mock
    SearchService searchService;

    @Mock
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldThrowJsonParseExceptionAndSendErrorMessage() {
        var session = mock(WebSocketSession.class);

        try {
            when(objectMapper.readValue(getPayloadWithWrongData(), InitialDataModel.class))
                    .thenThrow(JsonParseException.class);
            when(objectMapper.writeValueAsString(getErrorPageStatusModel()))
                    .thenReturn(getErrorMessageString());
            doNothing().when(session).sendMessage(new TextMessage(getErrorMessageString()));

            socketTextHandler.handleTextMessage(session, getTextMessageWithWrongData());

            verify(objectMapper, times(1))
                    .readValue(getPayloadWithWrongData(), InitialDataModel.class);
            verify(objectMapper, times(1))
                    .writeValueAsString(getErrorPageStatusModel());
            verify(session, times(1))
                    .sendMessage(new TextMessage(getErrorMessageString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldFailValidationAndSendErrorMessage() {
        var session = mock(WebSocketSession.class);
        try {
            when(objectMapper.readValue(getPayloadWithWrongData(), InitialDataModel.class))
                    .thenReturn(getInitialDataModelWithWrongData());
            when(objectMapper.writeValueAsString(getErrorPageStatusModel()))
                    .thenReturn(getErrorMessageString());
            doNothing().when(session).sendMessage(new TextMessage(getErrorMessageString()));

            socketTextHandler.handleTextMessage(session, getTextMessageWithWrongData());

            verify(objectMapper, times(1))
                    .readValue(getPayloadWithWrongData(), InitialDataModel.class);
            verify(objectMapper, times(1))
                    .writeValueAsString(getErrorPageStatusModel());
            verify(session, times(1))
                    .sendMessage(new TextMessage(getErrorMessageString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionAndSendErrorMessage() {
        var session = mock(WebSocketSession.class);

        try {
            when(objectMapper.readValue(getPayloadWithCorrectData(), InitialDataModel.class))
                    .thenReturn(getInitialDataModelWithCorrectData());
            when(objectMapper.writeValueAsString(getErrorPageStatusModel()))
                    .thenReturn(getErrorMessageString());
            doThrow(new IllegalArgumentException())
                    .when(searchService)
                    .processData(getInitialDataModelWithCorrectData(), session);
            doNothing().when(session).sendMessage(new TextMessage(getErrorMessageString()));

            socketTextHandler.handleTextMessage(session, getTextMessageWithCorrectData());

            verify(objectMapper, times(1))
                    .readValue(getPayloadWithCorrectData(), InitialDataModel.class);
            verify(objectMapper, times(1))
                    .writeValueAsString(getErrorPageStatusModel());
            verify(searchService, times(1))
                    .processData(getInitialDataModelWithCorrectData(), session);
            verify(session, times(1))
                    .sendMessage(new TextMessage(getErrorMessageString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}