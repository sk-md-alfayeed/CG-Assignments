package com.cg.rest.a5;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	

	@RequestMapping("/getAllEmployee")
	public List<Employee> getAllEmployee() {

		return employeeService.getAllEmployee();
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}

	@RequestMapping(value = "/getEmployee/{employeeId}", method = RequestMethod.GET)
	public Optional<Employee> getEmployee(@PathVariable int employeeId) {
		return employeeService.getEmployee(employeeId);

	}
	
	@RequestMapping(value = "/updateEmployee/{employeeId}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable int employeeId, @RequestBody Employee employee) {
		employeeService.updateEmployee(employeeId, employee);
	}
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	public void deleteEmployee(@PathVariable int employeeId) {
		employeeService.deleteEmployee(employeeId);
	}
	
	
}
