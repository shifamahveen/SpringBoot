package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrigController {
	
	@Autowired
	private JdbcTemplate template;

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
		
		String sql = "insert into trig (func, angle, result) values (?,?,?)";
		template.update(sql, func, a, result);
		
		session.setAttribute("angle", a);
		session.setAttribute("func", func);
		session.setAttribute("result", result);
		
		return "result.jsp";
	}
	
	@RequestMapping("records")
	public String getRecords(Model model) {
		List<Trig> trigRecords = template.query(
				"select * from trig",
				(rs, rowNum) -> new Trig(
					rowNum, rs.getString("func"),
					rs.getInt("angle"),
					rs.getDouble("result")
				)
			);
		
		model.addAttribute("records",trigRecords);
		
		return "records.jsp";
	}
	
	@RequestMapping("delete")
	public String deleteRecord(int id) {
		String sql = "delete from trig where id = ?";
		int status = template.update(sql,id);
		
		if(status > 0) {
			return "redirect:/records";
		} else {
			return "error.jsp";
		}
	}
}
