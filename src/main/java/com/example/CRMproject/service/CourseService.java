package com.example.CRMproject.service;

import com.example.CRMproject.dto.CourseDto;
import com.example.CRMproject.dto.StudentDto;
import com.example.CRMproject.entity.Course;
import com.example.CRMproject.repo.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;


    public CourseService(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    public CourseDto addCourse(Course course){
        courseRepository.save(course);
        return modelMapper.map(course, CourseDto.class);
    }

    public Set<CourseDto> getCourses() {
        return courseRepository.findAll().stream().map(course -> modelMapper.map(course, CourseDto.class))
                .collect(Collectors.toSet());
    }
}
