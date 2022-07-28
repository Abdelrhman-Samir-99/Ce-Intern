package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.departmentRepository;
import com.example.demo.repository.employeeRepository;


@Service
public class employeeService {
	
	private employeeRepository empRepository;
	
	@Autowired
	public employeeService(employeeRepository empRepository) {
		this.empRepository = empRepository;
	}
	
	public List <Employee> getAllEmployees() {
		return empRepository.findAll();
	}
	
	public Optional<Employee> getEmployeeById(Long employee_id) {
		return empRepository.findById(employee_id);
	}
	
	public Employee addEmployee(Employee newEmployee) {
		empRepository.save(newEmployee);
		return newEmployee;
	}
	
	public Optional<Employee> findEmployeeById(Long employeeId) {
		return empRepository.findById(employeeId);
	}
	
	public boolean removeEmployee(Long id) {
		empRepository.deleteById(id);
		return true;
	}
}