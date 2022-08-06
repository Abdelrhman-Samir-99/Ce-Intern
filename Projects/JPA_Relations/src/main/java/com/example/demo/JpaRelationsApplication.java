package com.example.demo;

import com.example.demo.model.Organization;
import com.example.demo.model.Organization_Contact;
import com.example.demo.repository.IOrganizationRepository;
import com.example.demo.repository.IOrganization_ContactRepository;
import com.example.demo.service.OrganizationService;
import com.example.demo.service.Organization_ContatctService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JpaRelationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationsApplication.class, args);
	}
}
