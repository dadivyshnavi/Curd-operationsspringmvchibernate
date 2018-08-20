package org.arpit.java2blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.arpit.java2blog.model.Course;
import org.arpit.java2blog.model.Designation;
import org.arpit.java2blog.model.Employee;
import org.arpit.java2blog.model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class StudentDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	 
	 
	 public void addStudent(Student student) {
		 
		 
		 Session session=this.sessionFactory.getCurrentSession();
		 
		 session.saveOrUpdate(student);
		 
		 
		 
	 }

	 @SuppressWarnings("unchecked")
	public List<Student> getAllStudent() {
	
		String hql ="from Student";
		
		 Session session=this.sessionFactory.getCurrentSession();
		 
		 Query query=session.createQuery(hql);//here persistent class name is Emp  
		
		List<Student> list=query.list();
		 
		 System.out.println(list);
		
		return list;
	}

	 public void deleteStudent(int id) {
		 

			String hql="delete from Student where id="+id;
			
			System.out.println(hql);
			Session session=this.sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			//query.setParameter("id", String.valueOf(id));
			int status=query.executeUpdate();
			if(status==1)
				System.out.println("record deleted");
			else
				System.out.println("record not deleted");						
			
	    }

	 public Student getStudentById(int parseInt) {
			// TODO Auto-generated method stub
			
			String hql="from Student where id="+parseInt ;
			Session session=this.sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			List<Student> list= query.list();
			
			if(list.isEmpty())
			{
				
				return null;
			}
			else
			{
			return list.get(0);
			}
		}
		public boolean checkUserExistsOrNot(Student student)
		
		{
			
			String hql="from Student where phno="+student.getPhno();
			Session session=this.sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			
			List<Student> list= query.list();
			
			
			if(list.size()>0)
			{
				return true;
				
			}
				
			else
			{
				return false;
			}
			
		}
	

	 public List<Course> getAllcourse(){
			
			String hql="from Course";
			Session session=this.sessionFactory.getCurrentSession();
			Query query=session.createQuery(hql);
			List<Course> list=query.list();
			
			
			
			
			
			
			System.out.println(list);
			
			return list;
			
			
			
	}
		
		 public Map<Integer,String> getCourseMap(){
			 
			 List<Course> list=getAllcourse();
			 Map<Integer,String> map=new HashMap<Integer,String>();
			 for(Course  entry:list) {
				 
				 map.put(entry.getId(),entry.getCourse());
				 
				 
				 
			 }
			return map;
			 
			 
			 
			 
			 
			 
		 }


}
