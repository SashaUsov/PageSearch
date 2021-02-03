package com.task.websearch.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InitialDataModel {

    private String url;

    private int maxThreadNum;

    private String searchText;

    private int maxUrlNum;
}
