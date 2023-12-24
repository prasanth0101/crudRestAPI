package com.reactProject.reactAndSpringProject.service;

import java.util.List;

import com.reactProject.reactAndSpringProject.dto.EmployeeDto;

public interface EmployeeService {
	public EmployeeDto createEmployee(EmployeeDto employeeDto);
	public EmployeeDto findById(Long employeeId);
	public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);
	public List<EmployeeDto> getAllEmployee();
	public String deleteByid(Long employeeId);
}
