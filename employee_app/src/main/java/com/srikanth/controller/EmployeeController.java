package com.srikanth.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srikanth.entity.Employee;
import com.srikanth.service.EmployeeService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getEmps")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> allEmployees = employeeService.getAllEmployees();
		return new ResponseEntity<>(allEmployees, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getEmpById(@PathVariable Long id) {
		Optional<Employee> getEmployee = employeeService.getEmpById(id);
		return new ResponseEntity<>(getEmployee, HttpStatus.OK);
	}

	@PostMapping("/saveEmp")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		Employee saveEmployee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(saveEmployee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		Employee updateEmployee = employeeService.updateEmployee(id, employee);
		return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
	}

	@DeleteMapping("/{deleteEmpById}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Long deleteEmpById) {
		String deleteEmployee = employeeService.deleteEmployee(deleteEmpById);
		return new ResponseEntity<>(deleteEmployee, HttpStatus.OK);
	}

}
