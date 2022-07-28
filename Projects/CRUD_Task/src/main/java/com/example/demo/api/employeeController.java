package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.example.demo.service.departmentService;
import com.example.demo.service.employeeService;


@RestController
@RequestMapping(path = "cegedim/employee")
public class employeeController {
	
	private final employeeService empService;
	
	@Autowired
	public employeeController(employeeService empService) {
		this.empService = empService;
	}
	

	@GetMapping
	public List <Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}
	
	@GetMapping(path = "/{employeeId}")
	public Optional<Employee> getDepartmentById(@PathVariable Long employeeId) {
		return empService.findEmployeeById(employeeId);
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		return empService.addEmployee(newEmployee);
	}
	
	@DeleteMapping(path = "{employeeId}")
	public boolean removeEmployee(@PathVariable("employeeId") Long id) {
		empService.removeEmployee(id);
		return true;
	}
}