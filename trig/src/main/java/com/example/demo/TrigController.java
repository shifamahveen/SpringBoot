package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TrigController {
	
	@Autowired
	private JdbcTemplate template;

	@GetMapping("index")
	public String home(HttpServletRequest req) {
		if(isLoggedIn(req)) {
			return "index.jsp";
		}
		else {
			return "login.jsp";
		}
	}
	
	@PostMapping("calculate")
	public String result(HttpServletRequest req) {
		if(isLoggedIn(req)) {
			return "index.jsp";
		}
		else {
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
	}
	
	@GetMapping("records")
	public String getRecords(Model model, HttpServletRequest req) {
		if(isLoggedIn(req)) {
			List<Trig> trigRecords = template.query(
					"select * from trig",
					(rs, rowNum) -> new Trig(
						rs.getInt("id"),
						rs.getString("func"),
						rs.getInt("angle"),
						rs.getDouble("result")
					)
				);
			
			model.addAttribute("records",trigRecords);
			
			return "records.jsp";
		}
		else {
			return "login.jsp";
		}
	}

	@GetMapping("edit")
	public String edit(int id, Model model) {
		@SuppressWarnings("deprecation")
		Trig record = template.queryForObject("select * from trig where id = ?", 
				new Object[]{id},
				(rs, rowNum) -> new Trig(
						rs.getInt("id"),
						rs.getString("func"),
						rs.getInt("angle"),
						rs.getDouble("result")
				)
		);
		
		model.addAttribute("obj",record);
		
		return "edit.jsp";
	}
	
	@PostMapping("/update")
    public String updateRecord(@ModelAttribute Trig trig) {
        String sql = "update trig set angle=?, func=?, result=? where id=?";
        template.update(sql, trig.getAngle(), trig.getFunc(), trig.getResult(), trig.getId());
        
        return "redirect:/records";
    }
	
	@PostMapping("/delete/{id}")
	public String deleteRecord(@PathVariable int id) {
		String sql = "delete from trig where id = ?";
		int status = template.update(sql,id);
		
		if(status > 0) {
			return "redirect:/records";
		} else {
			return "error.jsp";
		}
	}
	
	@GetMapping("sort")
	public String sort(Model model, HttpServletRequest req) {
		String orderFunc = req.getParameter("sortby");
		String sql;
		if(orderFunc.equals("asc")) {
			sql = "select * from trig order by angle";
		}
		else {
			sql = "select * from trig order by angle desc";
		}
		List<Trig> trigRecords = template.query(
				sql,
				(rs, rowNum) -> new Trig(
					rs.getInt("id"),
					rs.getString("func"),
					rs.getInt("angle"),
					rs.getDouble("result")
				)
			);
		
		model.addAttribute("records",trigRecords);
		
		return "records.jsp";
	}
	
	@GetMapping("search")
	public String search(Model model, HttpServletRequest req) {
		String value = req.getParameter("searchValue");
//		String sql = "select * from trig where func like ?";
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Trig> trigRecords = (List<Trig>) template.query("select * from trig where func like ?", 
				new String[] { "%" + value + "%" },
				(rs, rowNum) -> new Trig(
						rs.getInt("id"),
						rs.getString("func"),
						rs.getInt("angle"),
						rs.getDouble("result")
				)
		);
		
		model.addAttribute("records",trigRecords);
		
		return "records.jsp";
	}

	@GetMapping("register")
	public String registerForm() {
		return "register.jsp";
	}
	
	@PostMapping("register")
	public String register(@ModelAttribute User user) {
//		check if user is already registered
		String sql = "select count(*) from users where email = ?";
		int count = template.queryForObject(sql, Integer.class, user.getEmail());
		
		if(count>0) {
			return "User already registered";
		}
		else {
			String insertQuery = "insert into users (email, password, name) values (?,?,?)";
			template.update(insertQuery, user.getEmail(), user.getPassword(), user.getName());
			
			return "redirect:/records";

		}
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "login.jsp";
	}
	
	@PostMapping("login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, HttpServletRequest req) {
//			check if user is registered or not
		if(isValidUser(email,password)) {
			req.getSession().setAttribute("email", email);
			return "redirect:/records";
		}
		else {
			return "redirect:/register";
		}		
	}
	
	public boolean isValidUser(String email, String password) {
//		check for presence of user in db
		String sql = "select count(*) from users where email = ? and password=?";
		int count = template.queryForObject(sql, Integer.class, email, password);
		
		return count>0;
	}
	
	public boolean isLoggedIn(HttpServletRequest req) {
//		String email = req.getParameter("email");
		String status = (String) req.getSession().getAttribute("email");
		
		return status != null;
	}
	
	@RequestMapping("logout")
	public String logout(HttpServletRequest req) {
//		check if session is active, if inactive pass "false" so it wont create a new session
		HttpSession session = req.getSession(false);
		
//		deactivate session if active already
		if(session != null) {
			session.invalidate();
		}
		return "login.jsp";
	}
	
	
}
