package com.example.ogrencisistemi.service;

import java.util.List;

import com.example.ogrencisistemi.model.Student;

public interface StudentService {
	Student saveStudent(Student student);
	List<Student> getAllList();
	Student updateStudent(Long id, Student student);
	Boolean deleteStudent(Long id);
}

