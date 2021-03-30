package com.cg.healthcare;

<<<<<<< HEAD

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
>>>>>>> ee0d5daa19ea77f32ee55de882d6c97e3c296f1a
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
