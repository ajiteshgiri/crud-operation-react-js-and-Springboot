package com.rest.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Student;
import com.rest.service.IStudentService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class HomeController {
	
	@Autowired
	IStudentService service;
	@PostMapping("/api/save")
	public ResponseEntity<String> save(@RequestBody Student entity) {
		service.save(entity);
		String message = "employee created"+entity.getName();
	return new ResponseEntity<>(message, HttpStatus.OK);
		
	}

	@GetMapping("/api/all")
	public ResponseEntity<List<Student>> getAllStudent(){
	
		List<Student> std = service.getAllStudent();
		if(std.isEmpty()) {
			return new ResponseEntity<>(std,HttpStatus.NO_CONTENT);	
		}else {
		return new ResponseEntity<>(std,HttpStatus.OK);
		}	
	}
	@GetMapping("/api/edit/{id}")
	public ResponseEntity<Optional<Student>> getById(@PathVariable ("id") int id){
		
		Optional<Student> stdId= service.getStudentById(id);
		if(stdId.isPresent()) {
			return new ResponseEntity<>(stdId,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(stdId,HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/api/update")
	public ResponseEntity<String> update(@RequestBody Student s){
		
		 service.update(s);
		 String message = "employee updated "+s.getName();
		 return new ResponseEntity <>(message, HttpStatus.OK);
		
	}
	@GetMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable ("id") int id){
		service.removeById(id);
		String message = "Delete user successful";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
