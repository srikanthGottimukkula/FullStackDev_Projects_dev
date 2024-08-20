package com.srikanth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.srikanth.entity.Employee;

@Service
public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	
	public Employee saveEmployee(Employee employee);
	
	public Optional<Employee> getEmpById(Long id);
	
	public Employee updateEmployee(Long id, Employee employee);
	
	public String deleteEmployee(Long id);
	

}
