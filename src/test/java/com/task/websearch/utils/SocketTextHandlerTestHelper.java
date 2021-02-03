package com.task.websearch.utils;

import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.dto.PageStatusModel;
import org.springframework.web.socket.TextMessage;

public class SocketTextHandlerTestHelper {

    public static String getPayloadWithWrongData() {
        return "{\"maxThreadNum\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"searchText\":\"Upload\",\"maxUrlNum\":0}";
    }

    public static String getPayloadWithCorrectData() {
        return "{\"maxThreadNum\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"searchText\":\"Upload\",\"maxUrlNum\":2}";
    }

    public static TextMessage getTextMessageWithWrongData() {
        return new TextMessage("{\"maxThreadNum\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"searchText\":\"Upload\",\"maxUrlNum\":0}");
    }

    public static TextMessage getTextMessageWithCorrectData() {
        return new TextMessage("{\"maxThreadNum\":1,\"url\":\"https://ua.woodoos.com/woodoos-ua/ukrazom/\",\"searchText\":\"Upload\",\"maxUrlNum\":2}");
    }

    public static String getErrorMessageString() {
        return "{\"errorMessage\":\"Not valid input\"}";
    }

    public static PageStatusModel getErrorPageStatusModel() {
        return new PageStatusModel("Not valid input");
    }

    public static InitialDataModel getInitialDataModelWithWrongData() {
        return new InitialDataModel( "https://ua.woodoos.com/woodoos-ua/ukrazom/", 1, "Upload", 0);
    }

    public static InitialDataModel getInitialDataModelWithCorrectData() {
        return new InitialDataModel( "https://ua.woodoos.com/woodoos-ua/ukrazom/", 1, "Upload", 2);
    }
}
