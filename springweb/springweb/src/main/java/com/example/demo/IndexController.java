package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping("calculate")
	public String calculate(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int a = Integer.parseInt(req.getParameter("a"));
		int b = Integer.parseInt(req.getParameter("b"));
		String opr = req.getParameter("opr");
		int result=0;
		
		switch(opr) {
			case "add":
				result = a+b;
				break;
			case "subtract":
				result= a-b;
				break;
			case "multiply":
				result= a*b;
				break;
			case "divide":
				result= a/b;
				break;
			default: break;
		}
		
		session.setAttribute("result", result);
		
		return "profile.jsp";
	}
}
