package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class TrigApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrigApplication.class, args);
	}
	
	 @Bean
	    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
	        return new HiddenHttpMethodFilter();
	    }

}
