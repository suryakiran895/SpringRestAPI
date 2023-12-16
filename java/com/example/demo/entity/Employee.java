package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="employee")
public class Employee
{
	@Column(name="ename")
	private String name;
	@Id
	@Column(name="eid")
	private int id;
	@Column(name="edept")
	private String dept;
}
