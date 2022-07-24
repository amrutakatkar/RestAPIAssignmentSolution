package com.glearning.SpringAssignmentSolution.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.glearning.SpringAssignmentSolution.model.Employee;
import com.glearning.SpringAssignmentSolution.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> fetchEmployees() {
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee fetchEmployee(@PathVariable("id") long employeeId) {
		return employeeService.findById(employeeId);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Employee saveStudent(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/{id}")
	public Employee updateStudent(@RequestBody Employee employee, @PathVariable("id") long employeeId) {
		return employeeService.updateEmployee(employee, employeeId);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployee(@PathVariable("id") long employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
}