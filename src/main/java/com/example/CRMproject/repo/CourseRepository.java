package com.example.CRMproject.repo;

import com.example.CRMproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course getCourseByCourseName(String courseName);
}
