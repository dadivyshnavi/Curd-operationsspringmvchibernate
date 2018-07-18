package org.arpit.java2blog.dao;

import java.util.List;

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
	SessionFactory sessionfactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionfactory = sf;
	}
	 
	 
	 public void addStudent(Student student) {
		 
		 
		 Session session=this.sessionfactory.getCurrentSession();
		 
		 session.save(student);
		 
		 
		 
	 }


	public List<Student> getAllStudent() {
	
		String hql ="from Student";
		
		 Session session=this.sessionfactory.getCurrentSession();
		 
		 Query query=session.createQuery(hql);//here persistent class name is Emp  
		 List<Student> list=query.list();
		 
		 System.out.println(list);
		
		return list;
	}


	


}
