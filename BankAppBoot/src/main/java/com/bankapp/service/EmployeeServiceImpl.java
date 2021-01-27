package com.bankapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.EmployeeRepo;
import com.bankapp.entity.Employee;

@Service

@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepo employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
	
		this.employeeRepo = employeeRepo;
	}

	@Override
	public void addUser(Employee employee) {
		employeeRepo.save(employee);
		
	}

	@Override
	public Employee findByName(String name) {
		// TODO Auto-generated method stub
		return employeeRepo.findByName(name);
		}

	
}

