package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrigController {

	@RequestMapping("index")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping("calculate")
	public String result(HttpServletRequest req) {
		HttpSession session = req.getSession();
		int a = Integer.parseInt(req.getParameter("angle"));
		String func = req.getParameter("func");
		double result=0;
		
		switch(func) {
			case "sin":
				result = Math.toRadians(Math.sin(a));
				break;
			case "cos":
				result = Math.toRadians(Math.cos(a));
				break;
			case "tan":
				result = Math.toRadians(Math.tan(a));
				break;
			case "cot":
				result = Math.toRadians(1/Math.tan(a));
				break;
			case "sec":
				result = Math.toRadians(1/Math.cos(a));
				break;
			case "cosec":
				result = Math.toRadians(1/Math.sin(a));
				break;
			default: break;
		}
		
		session.setAttribute("angle", a);
		session.setAttribute("func", func);
		session.setAttribute("result", result);
		
		return "result.jsp";
	}
}
