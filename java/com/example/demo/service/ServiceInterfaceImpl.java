package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoInterface;
import com.example.demo.entity.Employee;

@Service
public class ServiceInterfaceImpl implements ServiceInterface
{
	@Autowired
	private DaoInterface dao;
	
	@Override
	public Employee register(Employee emp) 
	{
		return dao.save(emp);
	}
	@Override
	public Boolean findEmployee(int id) 
	{
		return dao.existsById(id);	//this method will return true if any employee exist with given id otherwise return false.
	}
	@Override
	public Iterable<Employee> getEmployees() 
	{
		return dao.findAll();
	}
	@Override
	public Employee updateEmployee(int id,Employee newEmp) 
	{
		Employee oldEmp = dao.findById(id).get();
		oldEmp.setDept(newEmp.getDept());
		oldEmp.setName(newEmp.getName());
		//don't set the id value
		return dao.save(oldEmp);
	}
	@Override
	public void deleteEmployee(int id) 
	{
		dao.deleteById(id); // we can't return delete methods because all predefined methods declared with void as return type.
	}

}
