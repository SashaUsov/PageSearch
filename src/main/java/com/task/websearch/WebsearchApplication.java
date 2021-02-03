package com.task.websearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class WebsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsearchApplication.class, args);
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
}
