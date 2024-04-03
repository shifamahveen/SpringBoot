package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(FirstApplication.class, args);
		
		// spring bean
		Dept dept = app.getBean(Dept.class);
		
		dept.setDeptno(10);
		dept.setDname("Research");
		
		Emp emp = new Emp(dept);
		emp.setId(1);
		emp.setName("Karthik");
		
		emp.show();
	}

}
