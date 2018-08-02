package org.arpit.java2blog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arpit.java2blog.dao.EmployeeDao;
import org.arpit.java2blog.model.Designation;
import org.arpit.java2blog.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDao employeeDao;
	
	
	
	@RequestMapping(value = "/emp", method = RequestMethod.GET, headers = "Accept=application/json")
	public String showEmployeePage(Model model)
	{
		
		
		model.addAttribute("empbean" ,new Employee());
		model.addAttribute("roles",employeeDao.getDesignationMap());
		
		
		/*List<Designation> list=employeeDao.getAlldesignation();
		model.addAttribute("list",list);*/
		
		List<Employee> list=employeeDao.getAllemployee();
		model.addAttribute("list",list);
		//Map<Integer,String> desgMap=employeeDao.getDesignationMap();
		
		
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
	public String deleteEmployee(@RequestParam("id") String id,RedirectAttributes redir)
	{
		employeeDao.deleteEmployee(Integer.parseInt(id));
		
		redir.addFlashAttribute("msg", "Record deleted successfully");
		 redir.addFlashAttribute("cssMsg", "danger");

		
		return "redirect:emp";
		
	
	}
	
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST, headers = "Accept=application/json")
	public String editEmployee(@RequestParam("id") String id,Model model,RedirectAttributes redir)
	{
		Employee employee =employeeDao.getEmployeeById(Integer.parseInt(id));
		System.out.println(employee);
		model.addAttribute("empbean" ,employee);
		
		List<Employee> list=employeeDao.getAllemployee();
		model.addAttribute("roles",employeeDao.getDesignationMap());
		model.addAttribute("list",list);
		
		
		return "employee";
		
	
	}
	
	
	
    @RequestMapping(value = "/emp", method = RequestMethod.POST, headers = "Accept=application/json")
	public String empDuplicatesChecking(@ModelAttribute Employee employee,RedirectAttributes redir)
	{
		
		if(employee.getId() ==0)
		{
		System.out.println(employee);
		boolean result=employeeDao.checkUserExistsOrNot(employee);
		if(result==false) 
		{
		
		employeeDao.addEmployee(employee);
		//ystem.out.println("Record Inserted Successfully");
		redir.addFlashAttribute("msg", "Record Inserted Successfully");
		redir.addFlashAttribute("cssMsg", "success");
		}
		else
		{
			//System.out.println("record alreday exists");
			redir.addFlashAttribute("msg", "Record Already Exists");
			redir.addFlashAttribute("cssMsg", "warning");

		}
		
		}
		
		else  //Edit recored comes here
		{
			 redir.addFlashAttribute("msg", "Record updated successfully");
			 redir.addFlashAttribute("cssMsg", "primary");

			employeeDao.addEmployee(employee);
			
			
			
			
			
			
		}
		
		return "redirect:emp";	
		
		
		
		//**This is for duplicate checking**
	
	}
	
    
    
    
    
    
    
       
    
    
}

