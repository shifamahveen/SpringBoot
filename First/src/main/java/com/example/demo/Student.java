package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String name; 
	private String batch;
	
	// loose coupling
	// obj of Course
	@Autowired
	@Qualifier("c1")
	private Course c1;
	
	// constructor
	public Student() {
		super();
		System.out.println("Student object created");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public Course getC1() {
		return c1;
	}
	public void setC1(Course c1) {
		this.c1 = c1;
	}
	public void show() {
		c1.read();
		System.out.println("Student details are: ");
		System.out.println("ID: "+id);
		System.out.println("Name: "+name);
		System.out.println("Batch: "+batch);
		System.out.println("Course details: "+c1.toString());

	}
	
	
}
