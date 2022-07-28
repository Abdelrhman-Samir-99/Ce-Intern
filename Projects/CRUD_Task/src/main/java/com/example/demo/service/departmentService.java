package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.departmentRepository;


@Service
public class departmentService {
	private departmentRepository depRepository;
	
	@Autowired
	public departmentService(departmentRepository depRepository) {
		this.depRepository = depRepository;
	}
	
	public List <Department> getAllDepartments() {
		return depRepository.findAll();
	}
	
	public Optional<Department> getDepartmentById(Long department_id) {
		return depRepository.findById(department_id);
	}
	
	public Department addDepartment(Department newDepartment) {
		// depRepository.addNewDepartment(newDepartment.getId(), 
		//								newDepartment.getName(), 
		//								newDepartment.getSpecialization());
		depRepository.save(newDepartment);
		return newDepartment;
	}
	
	public Optional<Department> findDepartmentById(Long dpeartmentId) {
		
		return depRepository.findById(dpeartmentId);
	}
	
	public boolean removeDepartment(Long id) {
		depRepository.deleteById(id);
		return true;
	}
}