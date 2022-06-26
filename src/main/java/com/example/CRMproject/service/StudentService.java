package com.example.CRMproject.service;

import com.example.CRMproject.dto.RegistrationDto;
import com.example.CRMproject.dto.StudentDto;
import com.example.CRMproject.entity.Student;
import com.example.CRMproject.repo.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public StudentDto addStudent(Student student){
        studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

}
