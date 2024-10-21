package org.jsp.assign.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.assign.dao.EmployeeDao;
import org.jsp.assign.entity.Employee;
import org.jsp.assign.exceptionClasses.InvalidEmployeeIdException;
import org.jsp.assign.exceptionClasses.NoEmployeeFoundException;
import org.jsp.assign.responseStructure.ResponseStructure;
import org.jsp.assign.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public ResponseEntity<?> saveEmployee(Employee employee) 
	{
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Saved Successfully..!").body(employeeDao.saveEmployee(employee)).build());
	}

	@Override
	public ResponseEntity<?> updateEmployee(Employee employee)
	{
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Details Updated Successfully............").body(employeeDao.updateEmployee(employee)).build());
	}

	@Override
	public ResponseEntity<?> findEmployeeById(int id) 
	{
		Optional<Employee> optional = employeeDao.findEmployeeById(id);
		if (optional.isEmpty()) {
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id...,Unable to find..!").build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Event Id verifies Successfully............").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findAllEmployees() 
	{
		List<Employee> employee = employeeDao.findAllEmployees();
		if(employee.isEmpty())
			throw NoEmployeeFoundException.builder().message("No Employee Found in the Database..!").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("All Employees Found Successfully...!").body(employeeDao.findAllEmployees()).build());
		
	}

	@Override
	public ResponseEntity<?> deleteEmployeeById(int id) {
		Optional<Employee> optional = employeeDao.findEmployeeById(id);
		if (optional.isEmpty()) 
		{
			throw InvalidEmployeeIdException.builder().message("Invalid Employee Id...,Unable to Delete..!").build();
		}
		
		int em = employeeDao.deleteEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Deleted successfully..........").body(em).build());
	}
}
