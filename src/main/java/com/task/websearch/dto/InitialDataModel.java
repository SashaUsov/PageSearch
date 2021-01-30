package com.task.websearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InitialDataModel {

    private String url;

    private int maxThreadNum;

    private String searchText;

    private int maxUrlNum;
}
