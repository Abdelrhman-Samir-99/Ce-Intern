package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class Organization {
	@Id
	Integer id;
	String name;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orgContact_Id", referencedColumnName = "id")
	private Organization_Contact orgContact;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "org")
	//Set<Project> projectSet = new HashSet<>();
	

	//@JsonIgnore
	//@OneToMany(mappedBy = "org")
	//Set<Team> teamSet = new HashSet<>();
}