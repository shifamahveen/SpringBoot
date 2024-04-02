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
		
		s1.setId(1);
		s1.setName("Tarun");
		s1.setBatch("BH07");
	
		Course course1 = app.getBean(Course.class);
		s1.setC1(course1);
		
		s1.show();
	}

}
