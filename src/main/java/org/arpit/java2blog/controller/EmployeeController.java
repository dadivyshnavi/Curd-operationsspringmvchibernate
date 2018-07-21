package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.dao.EmployeeDao;
import org.arpit.java2blog.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET, headers = "Accept=application/json")
	public String showEmployeePage(Model model)
	{
		
		
		model.addAttribute("empbean" ,new Employee());
		
		List<Employee> list=employeeDao.getAllemployee();
		model.addAttribute("list",list);
		
		return "employee";
		
		
		
		
		
	}
	
	/*@RequestMapping(value = "/emp", method = RequestMethod.POST, headers = "Accept=application/json")
	public String saveEmployee(@ModelAttribute Employee employee)
	{
		
		
		System.out.println(employee);
		
		employeeDao.addEmployee(employee);
		
		return "redirect:emp";
		
		
	
	}*/
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteEmployee(@RequestParam("id") String id)
	{
		employeeDao.deleteEmployee(Integer.parseInt(id));
		
		  
		
		return "redirect:emp";
		
	
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET, headers = "Accept=application/json")
	public String editEmployee(@RequestParam("id") String id,Model model)
	{
		Employee employee =employeeDao.getEmployeeById(Integer.parseInt(id));
		System.out.println(employee);
		model.addAttribute("empbean" ,employee);
		
		List<Employee> list=employeeDao.getAllemployee();
		model.addAttribute("list",list);
		
		return "employee";
		
	
	}
	
	
	
    @RequestMapping(value = "/emp", method = RequestMethod.POST, headers = "Accept=application/json")
	public String empDuplicatesChecking(@ModelAttribute Employee employee)
	{
		
		if(employee.getId() ==0)
		{
		System.out.println(employee);
		boolean result=employeeDao.checkUserExistsOrNot(employee);
		if(result==false) 
		{
		
		employeeDao.addEmployee(employee);
		System.out.println("Record Inserted Successfully");
		}
		else
		{
			System.out.println("record alreday exists");
		}
		
		}
		
		else  //Edit recored comes here
		{
			
			
			employeeDao.addEmployee(employee);
			
			
			
			
			
			
		}
		
		return "redirect:emp";	
		
		
		
		//**This is for duplicate checking**
	
	}
	
	
}
