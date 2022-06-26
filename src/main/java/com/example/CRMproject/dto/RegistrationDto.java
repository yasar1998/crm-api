package com.example.CRMproject.dto;

import com.example.CRMproject.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {

    StudentDto studentDto;

    CourseDto courseDto;

    LocalDateTime localDateTime;

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "studentDto=" + studentDto +
                ", courseDto=" + courseDto +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
