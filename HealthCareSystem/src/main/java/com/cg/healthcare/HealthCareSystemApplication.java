package com.cg.healthcare;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HealthCareSystemApplication {
	/*
	 * @Autowired private ObjectMapper objectMapper;
	 */
	public static void main(String[] args) {
		SpringApplication.run(HealthCareSystemApplication.class, args);
	}
	/*
	 * @PostConstruct public void setUp() { objectMapper.registerModule(new
	 * JavaTimeModule()); }
	 */

}
