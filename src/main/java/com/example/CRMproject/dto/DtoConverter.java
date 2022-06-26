package com.example.CRMproject.dto;

import com.example.CRMproject.entity.Registration;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DtoConverter {

    private final ModelMapper modelMapper;

    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public RegistrationDto convert(Registration registration){
        CourseDto courseDto = modelMapper.map(registration.getCourse(), CourseDto.class);
        StudentDto studentDto = modelMapper.map(registration.getStudent(), StudentDto.class);
        LocalDateTime localDateTime = registration.getEnrollmentDate();

        RegistrationDto registrationDto = new RegistrationDto(studentDto, courseDto, localDateTime);

        return registrationDto;
    }

}
