package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Department {
	@Id
    @SequenceGenerator(
            name = "Department_Generator",
            sequenceName = "Department_Generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Department_Generator"
    )
	private Long id;
	private String name;
	private String specialization;
	
	/*
	@OneToMany(mappedBy = "department")
	private List<Employee> employees = new ArrayList();
	*/
	
	
	public Department() {}
	public Department(Long id, String name, String specialization) {
		this.id = id;
		this.name = name;
		this.specialization = specialization;
	}
	
	/*
	public void addEmployee(Employee newEmployee) {
		employees.add(newEmployee);
	}
	*/
}
