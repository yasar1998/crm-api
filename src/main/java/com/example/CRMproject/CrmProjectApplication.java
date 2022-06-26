package com.example.CRMproject;

import com.example.CRMproject.entity.Course;
import com.example.CRMproject.entity.Student;
import com.example.CRMproject.repo.CourseRepository;
import com.example.CRMproject.repo.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrmProjectApplication implements CommandLineRunner {

	private final StudentRepository studentRepository;

	private final CourseRepository courseRepository;

	public CrmProjectApplication(StudentRepository studentRepository, CourseRepository courseRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrmProjectApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		studentRepository.save(new Student("yasar", "Yashar", "Mustafayev"));
		courseRepository.save(new Course("Physics"));
		courseRepository.save(new Course("Math"));
	}
}
