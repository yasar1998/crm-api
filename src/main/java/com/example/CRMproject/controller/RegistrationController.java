package com.example.CRMproject.controller;

import com.example.CRMproject.dto.RegistrationDto;
import com.example.CRMproject.entity.Registration;
import com.example.CRMproject.entity.Student;
import com.example.CRMproject.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService registrationService;


    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register/{courseName}")
    public ResponseEntity<RegistrationDto> register(@PathVariable("courseName") String courseName, @RequestBody Student student){
        return new ResponseEntity<>(registrationService.register(courseName, student), HttpStatus.CREATED);
    }

    @GetMapping("/registrations")
    public ResponseEntity<Set<RegistrationDto>> getRegistrations(){
        return new ResponseEntity<>(registrationService.getRegistrations(), HttpStatus.OK);
    }
}
