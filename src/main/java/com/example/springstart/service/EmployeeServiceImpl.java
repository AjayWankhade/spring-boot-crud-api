package com.example.springstart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springstart.dao.EmployeeDao;
import com.example.springstart.dao.EmployeeDaoImpl;
import com.example.springstart.model.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	 private EmployeeDao employeeDao; 
	
	@Transactional
	@Override
	public List<Employee> getAll() {
		List<Employee> list=employeeDao.getAll();
		return list;
	}

	@Transactional
	@Override
	public Employee get(int id) {
		return employeeDao.get(id);
	}

	@Transactional
	@Override
	public void save(Employee emp) {
		employeeDao.save(emp);
		
		
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
		
	}

}
