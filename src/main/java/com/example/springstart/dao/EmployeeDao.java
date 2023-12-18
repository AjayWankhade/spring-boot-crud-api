package com.example.springstart.dao;

import java.util.List;

import com.example.springstart.model.Employee;

public interface EmployeeDao {

	public List<Employee> getAll();
	
	public Employee get(int id);
	
	public void save(Employee emp);
	
	public void delete(int id);
	
}
