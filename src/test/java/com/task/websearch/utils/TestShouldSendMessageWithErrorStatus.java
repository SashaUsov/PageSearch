package com.task.websearch.utils;

import com.task.websearch.dto.InitialDataModel;

public class TestShouldSendMessageWithErrorStatus {

    public static InitialDataModel getTestInitialDataModel() {
        return new InitialDataModel("dfd", 2, "fgdfgdg", 2);
    }

    public static String getFirstMessage() {
        return "{\"id\":1,\"url\":\"dfd\",\"status\":\"Upload\",\"processed\":false}";
    }

    public static String getSecondMessage() {
        return "{\"id\":1,\"url\":\"dfd\",\"status\":\"Error\",\"processed\":false}";
    }
}
