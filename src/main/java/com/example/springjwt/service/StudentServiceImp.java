package com.example.springjwt.service;

import com.example.springjwt.entity.Student;
import com.example.springjwt.repository.StudentServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImp implements StudentService {

    private final StudentServiceRepo studentServiceRepo;

    public StudentServiceImp(StudentServiceRepo studentServiceRepo) {
        this.studentServiceRepo = studentServiceRepo;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentServiceRepo.findAll();
    }

    @Override
    public Student updateAllStudent(Student profile) {
        Student student = new Student();
        student.setId(profile.getId());
        return studentServiceRepo.save(student);
    }
}

