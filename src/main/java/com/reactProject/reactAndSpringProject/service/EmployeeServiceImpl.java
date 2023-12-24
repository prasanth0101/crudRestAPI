package com.reactProject.reactAndSpringProject.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactProject.reactAndSpringProject.dto.EmployeeDto;
import com.reactProject.reactAndSpringProject.entity.Employee;
import com.reactProject.reactAndSpringProject.exception.ResourceNotFoundException;
import com.reactProject.reactAndSpringProject.mapper.EmployeeMapper;
import com.reactProject.reactAndSpringProject.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepo.save(employee);

		return EmployeeMapper.mapTOEmployeeDto(savedEmployee);
	}

	@Override
	public EmployeeDto findById(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not exist with given given id: "+employeeId));
		
		return EmployeeMapper.mapTOEmployeeDto(employee);
	}

	@Override
	public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not exists with the given id"+employeeId));
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		Employee upadatedEmployee = employeeRepo.save(employee);
		return EmployeeMapper.mapTOEmployeeDto(upadatedEmployee);
	}

	@Override
	public List<EmployeeDto> getAllEmployee() {
		List<Employee> employees = employeeRepo.findAll();
		return employees.stream().map((employee)-> EmployeeMapper.mapTOEmployeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public String deleteByid(Long employeeId) {
		Employee employee = employeeRepo.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee Not exists with the given id"+employeeId));
		employeeRepo.deleteById(employeeId);
		return "employee Deleted Sucessfully";
	}
	
	

}
