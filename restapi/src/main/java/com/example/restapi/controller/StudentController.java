package com.example.restapi.controller;

import org.springframework.web.bind.annotation.*;
import com.example.restapi.model.Student;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	Student student;
	
	@PostMapping
	public String create(@RequestBody Student student) {
		this.student = student;
		return "Object created succesfully";
	}
	
	@GetMapping("{id}")
	public Student read(String id) {
		return student;
	}
	
	@PutMapping
	public String update(@RequestBody Student student) {
		this.student = student;
		return "Object updated succesfully";
	}
	
	@DeleteMapping("{id}")
	public String delete() {
		this.student = null;
		return "Object deleted succesfully";
	}
}
