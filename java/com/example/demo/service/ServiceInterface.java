package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface ServiceInterface 
{
	public Employee register(Employee emp);
	public Boolean findEmployee(int id);
	public Iterable<Employee> getEmployees();
	public Employee updateEmployee(int id,Employee emp);
	public void deleteEmployee(int id);
	
}
