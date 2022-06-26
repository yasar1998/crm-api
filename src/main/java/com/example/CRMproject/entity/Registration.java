package com.example.CRMproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    private LocalDateTime enrollmentDate;


    public Registration(Student student, Course course, LocalDateTime enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }
}
