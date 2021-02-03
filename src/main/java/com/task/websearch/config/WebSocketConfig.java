package com.task.websearch.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.task.websearch.service.SearchService;
import com.task.websearch.socket.SocketTextHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
	private final SearchService searchService;

	private final ObjectMapper objectMapper;

	public WebSocketConfig(SearchService searchService, ObjectMapper objectMapper) {
		this.searchService = searchService;
		this.objectMapper = objectMapper;
	}

	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(new SocketTextHandler(searchService, objectMapper), "/data");
	}

}