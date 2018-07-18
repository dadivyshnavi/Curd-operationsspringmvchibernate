package org.arpit.java2blog.controller;

import java.util.List;

import org.arpit.java2blog.dao.StudentDao;
import org.arpit.java2blog.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	
	@Autowired
	StudentDao studentDao;
	
	@RequestMapping(value = "/stu", method = RequestMethod.GET, headers = "Accept=application/json")
	private String showStudentPage(Model model) {
		
		model.addAttribute("stubean",new Student());
		 List<Student> list =       studentDao.getAllStudent();
		 model.addAttribute("list",list);
		   
		   
		return "Student";
		
		
		
	}
	
	@RequestMapping(value="/stu" , method=RequestMethod.POST,headers = "Accept=application/json")
	public String saveStudent(@ModelAttribute Student student)
	{
		
		
		System.out.println(student);
		
		studentDao.addStudent(student);
		
		return "redirect:stu";
		
		
	}
	
/*	@RequestMapping(value = "/viewStudents", method = RequestMethod.GET, headers = "Accept=application/json")
	private String showStudentsList(Model model) {
		
		   List<Student> list =       studentDao.getAllStudent();
		   
		   
		   System.out.println(list);
		
		   model.addAttribute("list",list);
		   
		return "studentList";
		
		// this is for Show studentsList view in separate .jsp (studentsList.jsp)file after adding in form.
		
	}*/
	
	
	
	

}
