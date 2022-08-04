package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	Integer id;
	String name;
	
	//@ManyToOne
	//Organization org;
	
	//@ManyToMany
	//Set<Team> teamSet = new HashSet<>();
}
