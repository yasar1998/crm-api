package com.example.CRMproject.controller;

import com.example.CRMproject.dto.CourseDto;
import com.example.CRMproject.dto.StudentDto;
import com.example.CRMproject.entity.Course;
import com.example.CRMproject.entity.Student;
import com.example.CRMproject.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/addCourse")
    public ResponseEntity<CourseDto> addCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.CREATED);
    }

    @GetMapping("/getCourses")
    public ResponseEntity<Set<CourseDto>> getAllCourses(){
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.CREATED);
    }
}
