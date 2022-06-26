package com.example.CRMproject.controller;

import com.example.CRMproject.dto.StudentDto;
import com.example.CRMproject.entity.Student;
import com.example.CRMproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentDto> addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }


}
