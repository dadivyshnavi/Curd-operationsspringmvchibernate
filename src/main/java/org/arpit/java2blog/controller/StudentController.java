package org.arpit.java2blog.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.arpit.java2blog.config.FilesStuff;
import org.arpit.java2blog.config.SendSMS;
import org.arpit.java2blog.dao.LoginDao;
import org.arpit.java2blog.dao.StudentDao;
import org.arpit.java2blog.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StudentController {
	
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	SendSMS sendSMS;
	 @Autowired
	    private Environment env;  
	 @Autowired
	 LoginDao loginDao;
	
	 @Autowired FilesStuff fileTemplate;
	@RequestMapping(value = "/stu", method = RequestMethod.GET, headers = "Accept=application/json")
	private String showStudentPage(Model model) {
		
		model.addAttribute("stubean",new Student());
		model.addAttribute("roles",studentDao.getCourseMap());
		
		/*List<Course> list=studentDao.getAllcourse();
		model.addAttribute("list",list);*/
		
		List<Student> list=studentDao.getAllStudent();
		
		model.addAttribute("list",list);
		   
		   
		return "Student";
		
		
		
	}
	
	/*@RequestMapping(value="/stu" , method=RequestMethod.POST,headers = "Accept=application/json")
	public String saveStudent(@ModelAttribute Student student)
	{
		
		
		System.out.println(student);
		
		studentDao.addStudent(student);
		
		return "redirect:stu";
		
		
	}*/
	

	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET, headers = "Accept=application/json")
	public String deleteStudent(@RequestParam("id") String id)
	{
		studentDao.deleteStudent(Integer.parseInt(id));
		
		/*redir.addFlashAttribute("msg", "Record deleted successfully");
		 redir.addFlashAttribute("cssMsg", "danger");*/

		
		return "redirect:stu";
		
	
	}
	
	@RequestMapping(value = "/editStudent", method = RequestMethod.GET, headers = "Accept=application/json")
	public String editStudent(@RequestParam("id") String id,Model model)
	{
		Student student =studentDao.getStudentById(Integer.parseInt(id));
		System.out.println(student);
		model.addAttribute("stubean" ,student);
		
		List<Student> list=studentDao.getAllStudent();
		model.addAttribute("roles",studentDao.getCourseMap());
		model.addAttribute("list",list);
		
		
		return "Student";
		
	
	}
	
	@RequestMapping(value = "/stu", method = RequestMethod.POST, headers = "Accept=application/json")
		public String stuDuplicatesChecking(@ModelAttribute Student student,@RequestParam("file1") MultipartFile[] uploadedFiles) throws IOException
		{
			
			if(student.getId() == 0)
			{
			System.out.println(student);
			boolean result=studentDao.checkUserExistsOrNot(student);
			if(result==false) 
			{
				int filecount =0;
	        	 
	        	 for(MultipartFile multipartFile : uploadedFiles) {
	    				String fileName = multipartFile.getOriginalFilename();
	    				if(!multipartFile.isEmpty())
	    				{
	    					filecount++;
	    				 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
	    				}
	    			}
	        	 
	        	 if(filecount>0)
	        	 {
	        		 student.setFiles(fileTemplate.concurrentFileNames());
	        		 fileTemplate.clearFiles();
	        		 
	        	 }
			
				studentDao.addStudent(student);
				String message= student.getName()+"registered successfully";
				
				String str = env.getProperty("app.msg");
				
                System.out.println(str);
                 str = str.replace("_user_", student.getName());
                 str = str.replace("_address_", student.getAddress());
                 str = str.replace("_course_", student.getCourse());
                 
                 System.out.println(str);
 				
				sendSMS.sendSMS(str, student.getPhno());
				
				
			
			System.out.println("Record Inserted Successfully");
			/*redir.addFlashAttribute("msg", "Record Inserted Successfully");
			redir.addFlashAttribute("cssMsg", "success");*/
			}
			else
			{
				System.out.println("record alreday exists");
				/*redir.addFlashAttribute("msg", "Record Already Exists");
				redir.addFlashAttribute("cssMsg", "warning");
*/
			}
			
			}
			
			else  //Edit recored comes here
			{
				/* redir.addFlashAttribute("msg", "Record updated successfully");
				 redir.addFlashAttribute("cssMsg", "primary");
				 
*/				int filecount =0;

				for(MultipartFile multipartFile : uploadedFiles) {
						String fileName = multipartFile.getOriginalFilename();
						if(!multipartFile.isEmpty())
						{
							filecount++;
						 multipartFile.transferTo(fileTemplate.moveFileTodir(fileName));
						}
					}
				
				if(filecount>0)
				{
					 student.setFiles(fileTemplate.concurrentFileNames());
					 fileTemplate.clearFiles();
					 
				}

				 studentDao.addStudent(student);
				
				
				
				
				
				
			}
			
			return "redirect:stu";	
			
			
			
			//**This is for duplicate checking**
		
		}
		
	
	@GetMapping("/login")
	public String showhome1Page()
	{
		
		System.out.println("enter to jsp page");
		
		
		return "login";
		
		
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, headers = "Accept=application/json")
	public String showPage(HttpSession session,HttpServletRequest request)
	{
		String phno =request.getParameter("uname"); 
				
		
		String password = request.getParameter("pwd");
		
		System.out.println(phno+"   "+password);
		
		List result =loginDao.checkUserExistOrnot(phno);
		
		
		if(result.isEmpty())
		{
			return "login" ;
		}
		
		else
		{
			return "redirect:stu";
			
		}
		
		
		
		
}
}