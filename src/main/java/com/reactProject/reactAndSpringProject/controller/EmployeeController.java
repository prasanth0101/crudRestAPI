package com.reactProject.reactAndSpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reactProject.reactAndSpringProject.dto.EmployeeDto;
import com.reactProject.reactAndSpringProject.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	// TO CREATE NEW EMPLOYEE
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto employee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	// TO GET ONE EMPLOYEE BY ID
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		EmployeeDto findById = employeeService.findById(employeeId);
		return ResponseEntity.ok(findById);
	}

	// TO UPDATE EXISTING EMPLOYEE
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto> updataEmployeeById(@PathVariable("id") Long employeeId,
			@RequestBody EmployeeDto employeeDto) {
		EmployeeDto updatedEmployee = employeeService.updateEmployeeById(employeeId, employeeDto);
		return ResponseEntity.ok(updatedEmployee);
	}
	// TO GET ALL EMPLOYEE
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> allEmployee = employeeService.getAllEmployee();
		return ResponseEntity.ok(allEmployee);
		
	}

	// TO DELETE EXISTING EMPLOYEE
	@DeleteMapping("{id}")
	public String deleteByid(@PathVariable("id") Long employeeId) {
		String message = employeeService.deleteByid(employeeId);
		return message;
		
		
		
	}
	

}
