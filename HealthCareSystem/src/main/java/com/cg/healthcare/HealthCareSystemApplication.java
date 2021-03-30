package com.cg.healthcare;



<<<<<<< HEAD

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


>>>>>>> bb4f7211baa6e1cb338b0c1307159c1a92b9b58d
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
