package com.example.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JdbcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(JdbcApplication.class, args);
		Student s1 = app.getBean(Student.class);
		s1.setRno(1);
		s1.setName("Pavan");
		s1.setBatch("Spring");
		
		StudentRepo repo = app.getBean(StudentRepo.class);
		repo.save(s1);
		
		System.out.println(repo.display());
		
	}

}
