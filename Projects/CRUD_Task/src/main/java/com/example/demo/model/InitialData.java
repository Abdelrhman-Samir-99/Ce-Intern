package com.example.demo.model;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.departmentRepository;
import com.example.demo.repository.employeeRepository;

@Configuration
public class InitialData {
	
	@Bean
	CommandLineRunner commandLineRunner(employeeRepository empRepository, departmentRepository depRepository) {
		return args -> {
			Department d1 = new Department(1L, "Computer Science", "Software Testing");
			Department d2 = new Department(2L, "Computer Sciencew", "Software Testingasdasd");
			Department d3 = new Department(3L, "Computer Scienceq", "Software Testingqwe");
			
			Employee emp1 = new Employee(1L, "Ahmed", "Mohamed", "ahmmmmmameas");
			Employee emp2 = new Employee(2L, "Ahmed", "Mohamed", "ahmmmmmameas");
			Employee emp3 = new Employee(3L, "Ahmed", "Mohamed", "ahmmmmmameas");
			
			empRepository.saveAll(List.of(emp1, emp2, emp3));
			depRepository.saveAll(List.of(d1, d2, d3));
		};
	}
}
