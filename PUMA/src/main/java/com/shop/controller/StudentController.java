/**
 * 
 */
package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.model.Student;
import com.shop.repo.StudentRepo;

/**
 * 
 */
@RestController
public class StudentController {

	@Autowired
	StudentRepo repo;
	
	@PostMapping("/saveData")
	public String saveData(@RequestBody  Student s) {
		repo.save(s);
		return "Data Saved Successfully.....!!!!";
	}
	@GetMapping("/getAllData")
	public List<Student> getAllData() {
		return (List<Student>) repo.findAll();
	}
}
