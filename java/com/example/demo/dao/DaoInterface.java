package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Employee;

public interface DaoInterface extends CrudRepository<Employee, Integer>
{

}
