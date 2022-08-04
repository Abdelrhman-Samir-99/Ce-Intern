package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Organization_Contact {
	@Id
	Integer id;
	String description;
	String address;
	String phone;
	@OneToOne(mappedBy = "orgContact")
	private Organization organization;
}
