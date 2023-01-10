package com.example.ogrencisistemi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ogrencisistemi.model.Student;
import com.example.ogrencisistemi.repository.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllList() {
		return studentRepository.findAll();
	}
	
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Optional<Student> resultStudent= studentRepository.findById(id);
		if(resultStudent.isPresent()) {
			resultStudent.get().setName(student.getName());
			resultStudent.get().setAddress(student.getAddress());
			return studentRepository.save(resultStudent.get());
		}
		
		return null; 
	}

	@Override
	public Boolean deleteStudent(Long id) {
		Optional<Student> resultStudent= studentRepository.findById(id);
		if(resultStudent.isPresent()) {
			studentRepository.deleteById(id);
			return true;
		
		}
		return false;
	}



}
