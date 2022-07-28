package com.example.demo.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

import antlr.collections.List;

@Repository
public interface departmentRepository extends JpaRepository<Department, Long>{
	@Query(value = "Insert INTO department (id, name, specialization) VALUES (:id, :name, :specialization)",
			nativeQuery = true)
	Optional<Department> addNewDepartment(Long id, String name, String specialization);	
}
