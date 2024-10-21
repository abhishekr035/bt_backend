package org.jsp.assign.controller;

import org.jsp.assign.entity.Employee;
import org.jsp.assign.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController 
{
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) 
	{
		return employeeService.saveEmployee(employee);
	} 
    
    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) 
	{
		return employeeService.updateEmployee(employee);
	}
    
    @GetMapping(value = "/{id}")
	public ResponseEntity<?> findEmployeeById(@PathVariable int id)
	{
		return employeeService.findEmployeeById(id);
	}
    
    @GetMapping
	public ResponseEntity<?> findAllEmployees()
	{
		return employeeService.findAllEmployees();
	}
    
    @DeleteMapping("/{id}")
	public ResponseEntity<?> DeleteEmployeeByid(@PathVariable int id) 
	{
		return employeeService.deleteEmployeeById(id);
	}
    
    
    
}

