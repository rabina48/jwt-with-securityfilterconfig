package com.example.springjwt.controller;

import com.example.springjwt.constant.ApiUrl;
import com.example.springjwt.entity.Student;
import com.example.springjwt.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class StudentCallController {

    private final StudentService studentService;

    public StudentCallController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(ApiUrl.STUDENT)
    public List<Student> getAllAppointment() {
        return studentService.getAllStudent();
    }

    @PostMapping("update")
    public Student updateAppointment( @RequestBody Student profile) {
        return studentService.updateAllStudent( profile);
    }
}
