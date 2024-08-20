package com.srikanth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.entity.Employee;
import com.srikanth.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployees() {

		List<Employee> allEmps = employeeRepository.findAll();
		return allEmps;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		Employee saveEmployee = employeeRepository.save(employee);
		return saveEmployee;
	}

	@Override
	public Optional<Employee> getEmpById(Long id) {
		Optional<Employee> getEmpById = employeeRepository.findById(id);
		if (getEmpById.isPresent()) {
			getEmpById.get();
		}
		return getEmpById;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee emp = employeeRepository.findById(id).get();
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		Employee saveEmp = employeeRepository.save(emp);
		return saveEmp;
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee Id is deleted :" + id;
	}

}
