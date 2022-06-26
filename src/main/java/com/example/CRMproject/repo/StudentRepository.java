package com.example.CRMproject.repo;

import com.example.CRMproject.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public Student getStudentByUsername(String username);
}
