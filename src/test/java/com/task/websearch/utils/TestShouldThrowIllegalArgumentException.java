package com.task.websearch.utils;

import com.task.websearch.dto.InitialDataModel;

public class TestShouldThrowIllegalArgumentException {

    public static InitialDataModel getTestInitialDataModelForExc() {
        return new InitialDataModel("dfd", -1, "fgdfgdg", 2);
    }
}
