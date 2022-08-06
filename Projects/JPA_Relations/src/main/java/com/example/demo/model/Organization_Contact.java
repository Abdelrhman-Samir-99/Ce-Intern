package com.example.demo.model;

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
public class Organization_Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String description;
	String address;
	String phone;

	@OneToOne(mappedBy = "orgContact", fetch = FetchType.EAGER)
	private Organization organization;
}
