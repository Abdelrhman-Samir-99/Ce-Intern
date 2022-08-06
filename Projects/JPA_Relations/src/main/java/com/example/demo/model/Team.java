package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	@ManyToMany(mappedBy = "teams", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	Set<Project> projects = new HashSet<>();

	public void addProject(Project project) {
		projects.add(project);
	}
}
