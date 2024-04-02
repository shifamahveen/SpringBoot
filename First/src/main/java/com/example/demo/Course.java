package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("c1")
public class Course {
	@Value("${c1.cid}")
	private int cid;
	@Value("${c1.cname}")
	private String cname;
	
	public int getCid() {
		return cid;
	}

	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void read() {
		System.out.println("Learning spring");
	}
}
