package com.example.springstart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springstart.model.Employee;
import com.example.springstart.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService  employeeService;
	
	@GetMapping("/employee")
	public List<Employee> get(){
		return employeeService.getAll();
	}
	
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee employee)
	{
        employeeService.save(employee);
        return employee;
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) throws Exception
	{
		Employee employeeObject=employeeService.get(id);
		if(employeeObject==null)
		{
			throw new Exception("Not found");
		}
		
		
		return employeeService.get(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) throws Exception
	{
		Employee employeeObject=employeeService.get(id);
		if(employeeObject==null)
		{
			throw new Exception("Not found");
		}
		employeeService.delete(id);
		return "Employee object deleted : "+ id+employeeObject;
	}
	
	@PutMapping("/employee")
	public Employee update(@RequestBody Employee empObject)
	{
		employeeService.save(empObject);
		return empObject;
	}
}
