package org.arpit.java2blog.dao;

import java.util.List;

import org.arpit.java2blog.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class EmployeeDao {
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	
	
	public void addEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllemployee(){
		
		String hql="from Employee";
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		List<Employee> list=query.list();
		System.out.println(list);
		
		return list;
		
		
		
}
	
	 public void deleteEmployee(int id) {
		 

			String hql="delete from Employee where id="+id;
			
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



	public Employee getEmployeeById(int parseInt) {
		// TODO Auto-generated method stub
		
		String hql="from Employee where id="+parseInt ;
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		
		List<Employee> list= query.list();
		
		if(list.isEmpty())
		{
			
			return null;
		}
		else
		{
		return list.get(0);
		}
	}
	public boolean checkUserExistsOrNot(Employee em)
	
	{
		String hql="from Employee where salary="+em.getSalary();
		Session session=this.sessionFactory.getCurrentSession();
		Query query=session.createQuery(hql);
		
		List<Employee> list= query.list();
		if(list.size()>0)
		{
			return true;
		}
			
		else
		{
			return false;
		}
		
	}



	
	 
	
	 
	 
	
}
