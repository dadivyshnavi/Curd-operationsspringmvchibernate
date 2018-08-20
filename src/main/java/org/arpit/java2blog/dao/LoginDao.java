package org.arpit.java2blog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.arpit.java2blog.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional

public class LoginDao {
	
	
	 
	
	@PersistenceContext private EntityManager em;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Student>  checkUserExistOrnot(String phno)
	{
		
		String hql ="select * from student where phno='"+phno+"' ";
		
	     
	     
	     RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);		
	     return this.jdbcTemplate.query(hql, rowMapper);
	     
	}



}

	
	
	
	


