package com.example.springjwt.repository;

import com.example.springjwt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentServiceRepo extends JpaRepository<Student, Integer> {

    Optional<Student> findByEmail(String email);
}
