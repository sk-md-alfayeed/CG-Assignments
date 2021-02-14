package com.cg.rest.a5;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}
	
	public Optional<Employee> getEmployee(int employeeId) {
		return employeeRepository.findById(employeeId);
	}

	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(int employeeId, Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
