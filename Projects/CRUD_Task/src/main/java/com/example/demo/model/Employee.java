package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
    @SequenceGenerator(
            name = "Employee_Generator",
            sequenceName = "Employee_Generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Employee_Generator"
    )
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	/*
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	*/
	
	public Employee(long id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public Employee() {}
}
