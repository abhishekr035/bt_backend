package org.jsp.assign.service;

import org.jsp.assign.entity.Employee;
import org.springframework.http.ResponseEntity;

public interface EmployeeService 
{

	ResponseEntity<?> saveEmployee(Employee employee);

	ResponseEntity<?> updateEmployee(Employee employee);

	ResponseEntity<?> findEmployeeById(int id);

	ResponseEntity<?> findAllEmployees();

	ResponseEntity<?> deleteEmployeeById(int id);

}
