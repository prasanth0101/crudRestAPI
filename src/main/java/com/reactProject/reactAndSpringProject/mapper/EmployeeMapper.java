package com.reactProject.reactAndSpringProject.mapper;

import com.reactProject.reactAndSpringProject.dto.EmployeeDto;
import com.reactProject.reactAndSpringProject.entity.Employee;

public class EmployeeMapper {
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(employeeDto.getId(), employeeDto.getFirstName(), employeeDto.getLastName(),
				employeeDto.getEmail());
	}

	public static EmployeeDto mapTOEmployeeDto(Employee employee) {
		return new EmployeeDto(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}

}
