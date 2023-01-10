package com.example.ogrencisistemi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ogrencisistemi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	Optional<Student> findById(Long id);

	void deleteById(Long id);
 

	
}
