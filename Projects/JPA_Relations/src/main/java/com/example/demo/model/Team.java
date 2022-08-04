package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	Integer id;
	String name;

	//@ManyToOne
	//Organization org;
	
	//@ManyToMany(mappedBy = "teamSet")
	//Set<Project> projectSet = new HashSet<>();
}
