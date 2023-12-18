package com.example.springstart.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.*;

import com.example.springstart.model.Employee;

import jakarta.persistence.EntityManager;

import jakarta.websocket.Session;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	@Override
	public List<Employee> getAll() {
	
		org.hibernate.Session currentSession=(org.hibernate.Session) entityManager.unwrap(org.hibernate.Session.class);
	         Query<Employee> query=currentSession.createQuery("from Employee",Employee.class);
	 	   List<Employee> list=query.getResultList();
	 	   return list;
	 	   
	}

	@Override
	public Employee get(int id) {
		org.hibernate.Session currentSession=entityManager.unwrap(org.hibernate.Session.class);
		Employee employee=currentSession.get(Employee.class,id);
		return employee;
	}

	@Override
	public void save(Employee emp) {
		org.hibernate.Session currentSession=entityManager.unwrap(org.hibernate.Session.class);
		currentSession.saveOrUpdate(emp);
		
		
	}

	@Override
	public void delete(int id) {
		org.hibernate.Session currentSession=entityManager.unwrap(org.hibernate.Session.class);
		Employee employee=currentSession.get(Employee.class,id);
         currentSession.delete(employee);
	}

}
