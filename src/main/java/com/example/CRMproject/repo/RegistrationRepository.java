package com.example.CRMproject.repo;

import com.example.CRMproject.entity.Course;
import com.example.CRMproject.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
}
