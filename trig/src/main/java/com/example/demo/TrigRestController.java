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

@RestController
@RequestMapping("/trig")
public class TrigRestController {
	
	@Autowired
	private JdbcTemplate template;
	
	// create
	@PostMapping
	public String result(@RequestBody Trig trig) {
		int a = trig.getAngle();
		String func = trig.getFunc();
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
		
		return "Record created successfully";
	}
	
	//	 retrieve data
	@GetMapping
	public List<Trig> getRecords() {
		return template.query(
				"select * from trig",
				(rs, rowNum) -> new Trig(
					rs.getInt("id"),
					rs.getString("func"),
					rs.getInt("angle"),
					rs.getDouble("result")
				)
			);
	}
	
	// get record based on id
	@SuppressWarnings("deprecation")
	@GetMapping("{id}")
	public Trig getRecord(@PathVariable int id) {
		return template.queryForObject("select * from trig where id = ?", 
				new Object[]{id},
				(rs, rowNum) -> new Trig(
						rs.getInt("id"),
						rs.getString("func"),
						rs.getInt("angle"),
						rs.getDouble("result")
				)
		);
	}
	
	//	delete data
	@DeleteMapping("{id}")
	public String deleteRecord(@PathVariable int id) {
		String sql = "delete from trig where id = ?";
		int status = template.update(sql,id);
		
		if(status > 0) {
			return "record deleted ";
		} else {
			return "delete failed";
		}
	}

	//	edit data
	@PutMapping("{id}")
	public String updateRecord(@PathVariable int id, @RequestBody Trig trig) {	
		String sql = "update trig set angle=?, func=?, result=? where id=?";
		template.update(sql, trig.getAngle(), trig.getFunc(), trig.getResult(), trig.getId());
		
		return "record updated";
		
	}
}
