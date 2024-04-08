package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@RequestMapping("demo")
	public String home(HttpServletRequest req) {
		return "index.jsp";
	}
	
	@RequestMapping("profile")
	public String profile(HttpServletRequest req) {
		// get current session
		HttpSession session = req.getSession();
		// get passed data value from parameter
		String username = req.getParameter("name");
		String batch = req.getParameter("batch");
		// set the values for the current session
		session.setAttribute("fullname", username);
		session.setAttribute("batch", batch);
		
		return "profile.jsp";
	}
}
