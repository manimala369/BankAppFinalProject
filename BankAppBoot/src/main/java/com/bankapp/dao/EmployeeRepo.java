package com.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{
	public Employee findByName(String name);
}
