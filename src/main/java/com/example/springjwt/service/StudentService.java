package com.example.springjwt.service;


import com.example.springjwt.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface StudentService {

     List<Student> getAllStudent();
     Student updateAllStudent( Student profile);


}
