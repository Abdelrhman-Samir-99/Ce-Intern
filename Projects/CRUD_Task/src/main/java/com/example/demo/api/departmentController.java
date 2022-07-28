package com.example.demo.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.departmentRepository;
import com.example.demo.service.departmentService;

import java.util.*;

@RestController
@RequestMapping(path = "cegedim/department")
public class departmentController {
	private final departmentService depService;
	
	@Autowired
	public departmentController(departmentService depService) {
		this.depService = depService;
	}
	
	@GetMapping
	public List <Department> getAllDepartments() {
		return depService.getAllDepartments();
	}
	
	@PostMapping
	public Department addDepartment(@RequestBody Department newDepartment) {
		return depService.addDepartment(newDepartment);
	}
	
	@GetMapping(path = "/{departmentId}")
	public Optional<Department> getDepartmentById(@PathVariable Long departmentId) {
		return depService.findDepartmentById(departmentId);
	}
	
	@DeleteMapping(path = "/{departmentId}")
	public boolean removeDepartment(@PathVariable Long departmentId) {
		return depService.removeDepartment(departmentId);
	}
}