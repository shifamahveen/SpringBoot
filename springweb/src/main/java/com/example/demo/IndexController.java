package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("demo")
	public String home() {
		
		System.out.println("hi ");
		return "index.jsp";
	}
}
