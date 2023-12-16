package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.ServiceInterface;

@RestController
@ComponentScan(basePackages = "com.example.demo.entity")
public class FrontController 
{
	@Autowired
	private ServiceInterface service;
	
	@PostMapping("/register")
	public String registerEmployee(@RequestBody Employee emp) //if you not include @RequestBody Annotation you will get an error like "{property name} can't be null". 
	{
		if(service.findEmployee(emp.getId()))
			return "Employee with id "+emp.getId()+" is already exist";
		else
			return service.register(emp)+"\nRegistered Successfully with above details";
	}

//	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/display")
	public Iterable<Employee> showEmployees()
	{
		return service.getEmployees();
	}
	
	@PutMapping("/update/{id}")
	public String updateEmployee(@PathVariable int id, @RequestBody Employee emp)
	{
		if(service.findEmployee(id))
			return "Updated Successfully with below details\n"+service.updateEmployee(id,emp);
		else
			return "Employee with id "+id+" is not exist";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id)
	{
		if(service.findEmployee(id))
		{
			service.deleteEmployee(id);
			return "Deleted Successfully";
		}
		else
			return "Employee with id "+id+" is not exist";
	}
}


