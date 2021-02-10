package com.cg.mvc.a5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	
	int temp;

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView getIndex() {

		ModelAndView model = new ModelAndView("homepage");

		return model;
	}

	@RequestMapping(value = "/submitAdd.html", method = RequestMethod.POST)
	public ModelAndView submitAddForm() {

		ModelAndView model = new ModelAndView("add");

		return model;

	}

	@RequestMapping(value = "/addEmployee.html", method = RequestMethod.POST)
	public ModelAndView addEmployees(@ModelAttribute("employee") Employee employee) {

		EmployeeDB addDB = new EmployeeDB();
		addDB.addEmployee(employee.getEmployeeName(), employee.getEmployeeDepartment(),
				employee.getEmployeeDesignation(), employee.getEmployeeSalary());

		ModelAndView model = new ModelAndView("add");
		model.addObject("msg", "Employee Added");

		return model;
	}

	@RequestMapping(value = "/submitEdit.html", method = RequestMethod.POST)
	public ModelAndView submitDeleteForm() {
		ModelAndView model = new ModelAndView("delete");
		return model;
	}
	
	@RequestMapping(value = "/submitDeleteButton.html", method = RequestMethod.GET)
	public ModelAndView submitDeleteButton(@RequestParam int employeeId) {
		EmployeeDB delDB = new EmployeeDB();
		delDB.deleteEmployee(employeeId);
		
		ModelAndView model = new ModelAndView("delete");
		return model;
	}
	
	@RequestMapping(value = "/submitUpdate.html", method = RequestMethod.GET)
	public ModelAndView submitUpdateForm(@RequestParam int employeeId) {
		temp = employeeId;
		
		EmployeeDB upDB = new EmployeeDB();
		Employee employee = upDB.getEmployee(employeeId);

		
		ModelAndView model = new ModelAndView("update");
		model.addObject("empName", employee.getEmployeeName());
		model.addObject("empDep", employee.getEmployeeDepartment());
		model.addObject("empDes", employee.getEmployeeDesignation());
		model.addObject("empSal", employee.getEmployeeSalary());
		
		return model;
	}
	
	
	@RequestMapping(value = "/submitUpdateButton.html", method = RequestMethod.POST)
	public ModelAndView updateEmployees(@ModelAttribute("employee1") Employee employee) {
		EmployeeDB upDB = new EmployeeDB();
		upDB.updateEmployee(temp, employee.getEmployeeName(), employee.getEmployeeDepartment(),
				employee.getEmployeeDesignation(), employee.getEmployeeSalary());
		
		ModelAndView model = new ModelAndView("update");
		model.addObject("msg", "Employee Updated");
		return model;
	}
	
	
	


	
}
