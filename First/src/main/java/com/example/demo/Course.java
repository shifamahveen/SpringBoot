package com.example.demo;

import org.springframework.stereotype.Component;

@Component("c1")
public class Course {
	private int cid;
	private String cname;
	
	public void read() {
		System.out.println("Learning spring");
	}
}
