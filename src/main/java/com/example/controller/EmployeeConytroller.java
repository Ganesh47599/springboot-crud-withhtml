package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

@Controller

public class EmployeeConytroller {

	private EmployeeService employeeService;
	
	public EmployeeConytroller(EmployeeService employeeService ) {
		super();
		this.employeeService=employeeService;
		
	
	}
	@GetMapping("/showFormUpdate/{id}")
	public String showFormUpdate(@PathVariable(value="id") long id,Model model){
		Employee employee=employeeService.getEmployeeById(id);
		model.addAttribute("employee",employee);
		return "update_employee";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) 
	{
	Employee employee=new Employee();
	model.addAttribute("employee",employee);
	return "new_employee";
	}
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	//build creeate employee RESt API
	/*crud without html
	 * @PostMapping("/ps") public ResponseEntity<Employee> saveEmployee(@RequestBody
	 * Employee employee){ return new
	 * ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.
	 * CREATED);
	 * 
	 * }
	 */
	//get All employess
//	@GetMapping("/ps")
//	public List<Employee> getAllEmployeee(){
//		return employeeService.getAllEmployess();
//	}
	
	@GetMapping("/")
	public String getAllEmployess(Model model) {
		model.addAttribute("listEmployees",employeeService.getAllEmployess());
		return "index";
	}
	//build get employee by id 
	
	//update
	/*
	 * @PutMapping("/ps/{id}") public ResponseEntity<Employee>
	 * upddateEmployee(@PathVariable("id") long id , @RequestBody Employee
	 * employee){ return new
	 * ResponseEntity<Employee>(employeeService.updateEmployee(employee,
	 * id),HttpStatus.OK);
	 * 
	 * 
	 * }
	 */
	

	
	//delete employee id
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") long id){
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
		
	}
}
