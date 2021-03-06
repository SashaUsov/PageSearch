package com.task.websearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageStatusModel {

    public PageStatusModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private int id;

    private String url;

    private String status;

    private boolean processed;

    private String errorMessage = "";
}
