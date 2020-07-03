package org.test;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TesttemplateApplication {
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		RestTemplate restTemplat = new RestTemplate();
	//	restTemplat.setInterceptors( Collections.singletonList(new requestinterceptor()) );
	   return builder.build();
	}
	 
	public static void main(String[] args) {
		SpringApplication.run(TesttemplateApplication.class, args);
	}

}
