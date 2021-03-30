package com.cg.healthcare;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
