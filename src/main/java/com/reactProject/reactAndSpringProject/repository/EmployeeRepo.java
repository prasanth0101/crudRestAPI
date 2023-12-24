package com.reactProject.reactAndSpringProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reactProject.reactAndSpringProject.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	
}
