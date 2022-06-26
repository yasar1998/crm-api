package com.example.CRMproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;
    private String courseName;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Registration> registrations;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
