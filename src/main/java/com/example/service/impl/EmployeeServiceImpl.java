package com.example.service.impl;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.exception.ResourceNotFoundException;
import com.example.reository.EmployeeRepository;
import com.example.service.EmployeeService;
@Service
public class EmployeeServiceImpl  implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository=employeeRepository;
	}

	
	
	/* for crud witjout html
	 * @Override public Employee saveEmployee(Employee employee) { // TODO  
	 * Auto-generated method stub return employeeRepository.save(employee); }
	 */
	@Override
	public List<Employee> getAllEmployess() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	@Override
	public Employee getEmployeeById(long id) {
		
//	Optional<Employee>	 employee=employeeRepository.findById(id);
		// TODO Auto-generated method stub
		/*
		 * if(employee.isPresent()) { return employee.get(); } else { throw new
		 * ResourceNotFoundException("Employee", "id", id); } return null;
		 */
		return employeeRepository.findById(id).orElseThrow(()->new  ResourceNotFoundException("Employee", "id", id));
	}
	/*
	 * @Override public Employee updateEmployee(Employee employee, long id) { //
	 * TODO Auto-generated method stub Employee
	 * existingEmp=employeeRepository.findById(id).orElseThrow(()->new
	 * ResourceNotFoundException("Employee", "id", id));
	 * existingEmp.setFirstName(employee.getFirstName());
	 * existingEmp.setLastName(employee.getLastName());
	 * existingEmp.setEmail(employee.getEmail());
	 * employeeRepository.save(existingEmp); return existingEmp; }
	 * 
	 * @Override public void deleteEmployee(long id) { // TODO Auto-generated method
	 * stub employeeRepository.findById(id).orElseThrow(()->new
	 * ResourceNotFoundException("Employee", "id", id));
	 * employeeRepository.deleteById(id); }
	 */



	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		this.employeeRepository.save(employee);
		
	}
	
	@Override
	public void deleteEmployeeById(long id) {
		this.employeeRepository.deleteById(id);
	}

	
}
