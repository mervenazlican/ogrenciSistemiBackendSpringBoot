package com.example.ogrencisistemi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ogrencisistemi.model.Student;
import com.example.ogrencisistemi.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("http://localhost:3000")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAll")
	public List<Student> getAllDataList(){
		return studentService.getAllList();
	}
	
	@PostMapping("/add")
	public String add(@RequestBody Student student) {
		studentService.saveStudent(student);
		return "new student is added";
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
		Student resultStudent = studentService.updateStudent(id,student);
		return ResponseEntity.ok(resultStudent);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Boolean> deleteStudent(@PathVariable("id") Long id) {
		Boolean statusBoolean = studentService.deleteStudent(id);
		return ResponseEntity.ok(statusBoolean);
	}
	
}
