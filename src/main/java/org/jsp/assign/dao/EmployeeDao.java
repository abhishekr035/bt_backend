package org.jsp.assign.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.assign.entity.Employee;


public interface EmployeeDao 
{
	Employee saveEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	Optional<Employee> findEmployeeById(int id);
	
	List<Employee> findAllEmployees();
	
	int deleteEmployeeById(int id);
}
