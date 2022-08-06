package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name = "orgContact_Id", referencedColumnName = "id")
	private Organization_Contact orgContact;

	@OneToMany(targetEntity = Team.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_id", referencedColumnName = "id")
	Set<Team> teams = new HashSet<>();

	@OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_id", referencedColumnName = "id")
	Set<Project> projects = new HashSet<>();

	public void addTeam(Team team) {
		teams.add(team);
	}
	public void addProject(Project project) {
		projects.add(project);
	}
}