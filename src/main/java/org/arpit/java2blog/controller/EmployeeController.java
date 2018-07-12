package org.arpit.java2blog.controller;

import org.arpit.java2blog.dao.EmployeeDao;
import org.arpit.java2blog.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET, headers = "Accept=application/json")
	public String showEmployeePage(Model model)
	{
		
		
		model.addAttribute("empbean" ,new Employee());
		
		return "employee";
		
		
		
		
		
	}
	
	
	@RequestMapping(value = "/emp", method = RequestMethod.POST, headers = "Accept=application/json")
	public String saveEmployee(@ModelAttribute Employee employee)
	{
		
		
		System.out.println(employee);
		
		employeeDao.addEmployee(employee);
		
		return "redirect:emp";
		
		
	
		
		
		
		
		
	}
	
	

}
