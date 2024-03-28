package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(FirstApplication.class, args);
		
		// spring bean
		Student s1 = app.getBean(Student.class);
		Student s2 = app.getBean(Student.class);

	}

}
