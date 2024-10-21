package org.jsp.assign.daoImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.assign.dao.EmployeeDao;
import org.jsp.assign.entity.Employee;
import org.jsp.assign.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> findEmployeeById(int id) {
		return employeeRepository.findById(id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public int deleteEmployeeById(int id) {
	 
	return employeeRepository.deleteEmployeeById(id);
	}

//	@Override
//	public Optional<Employee> deleteEmployeeById(int id) {
//	  
//		
//	}

}
