/**
 * 
 */
package com.mongo.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.example.model.Student;
import com.mongo.example.repo.StudentRepository;

/**
 * @author Junaid.Khan
 *
 */

@RestController
@RequestMapping("/student")
public class MyController {
	
	@Autowired
	private StudentRepository  repo;
	
	@PostMapping("/save")
	public ResponseEntity<?> addStudent(@RequestBody Student student){
		
		if(student != null) {
			Student response = this.repo.save(student);
			ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Student>> getStudents(){	
		return ResponseEntity.ok(this.repo.findAll());
	}
	
}
