package com.task.websearch.controller;

import com.task.websearch.dto.InitialDataModel;
import com.task.websearch.service.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("data")
public class DataReceptionController {

    private final SearchService searchService;

    public DataReceptionController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void processData(@RequestBody InitialDataModel data) {
        searchService.processData(data);
    }
}
