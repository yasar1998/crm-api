package com.example.CRMproject.service;

import com.example.CRMproject.dto.DtoConverter;
import com.example.CRMproject.dto.RegistrationDto;
import com.example.CRMproject.entity.Course;
import com.example.CRMproject.entity.Registration;
import com.example.CRMproject.entity.Student;
import com.example.CRMproject.repo.CourseRepository;
import com.example.CRMproject.repo.RegistrationRepository;
import com.example.CRMproject.repo.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RegistrationService {

    private final DtoConverter dtoConverter;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;
    private final ModelMapper modelMapper;

    public RegistrationService(DtoConverter dtoConverter, StudentRepository studentRepository,
                               CourseRepository courseRepository,
                               RegistrationRepository registrationRepository,
                               ModelMapper modelMapper) {
        this.dtoConverter = dtoConverter;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.registrationRepository = registrationRepository;
        this.modelMapper = modelMapper;
    }

    public RegistrationDto register(String courseName, Student student){
        Course course = courseRepository.getCourseByCourseName(courseName);

        LocalDateTime localDateTime = LocalDateTime.now();
        log.info(course.toString());
        log.info(student.toString());
        Registration registration = new Registration(student, course, localDateTime);
        registrationRepository.save(registration);

        return dtoConverter.convert(registration);
    }

    public Set<RegistrationDto> getRegistrations(){
        return registrationRepository.findAll().stream().map(dtoConverter::convert)
                .collect(Collectors.toSet());
    }
}
