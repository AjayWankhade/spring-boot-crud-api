package com.example.springstart.service;

import java.util.List;

import com.example.springstart.model.Employee;

public interface EmployeeService {

public List<Employee> getAll();
	
	public Employee get(int id);
	
	public void save(Employee emp);
	
	public void delete(int id);
}
