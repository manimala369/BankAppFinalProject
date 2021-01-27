package com.bankapp.service;

import com.bankapp.entity.Employee;

public interface EmployeeService {
	public void addUser(Employee employee);
	public Employee findByName(String name);
}
