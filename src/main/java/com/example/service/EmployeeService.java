package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.entity.Employee;

public interface EmployeeService {
	//Employee saveEmployee(Employee employee); //for crud without html
	void saveEmployee(Employee employee);
List<Employee> getAllEmployess();
Employee getEmployeeById(long id);
/*
 * Employee updateEmployee(Employee employee,long id); void deleteEmployee(long
 * id);
 */

void deleteEmployeeById(long id);

}
