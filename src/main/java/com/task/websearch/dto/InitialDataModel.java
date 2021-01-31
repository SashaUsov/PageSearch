package com.task.websearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InitialDataModel {

    @NotEmpty
    private String url;

    @Positive
    @NotNull
    private int maxThreadNum;

    @NotEmpty
    private String searchText;

    @Positive
    @NotNull
    private int maxUrlNum;
}
