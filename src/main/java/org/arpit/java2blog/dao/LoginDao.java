package org.arpit.java2blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.arpit.java2blog.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class LoginDao {
	
	
	 
	
	@PersistenceContext private EntityManager em;
	
	public List checkUserExistOrnot(String phno)
	{
		
		String hql ="select * from student where phno='"+phno+"' ";
		Query query =em.createNativeQuery(hql);
		
	     List result =query.getResultList();
	     
	   return result;
	}



}

	
	
	
	


