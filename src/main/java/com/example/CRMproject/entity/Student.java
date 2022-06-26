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
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long studentId;

    private String username;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Registration> registrations;

    public Student(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
