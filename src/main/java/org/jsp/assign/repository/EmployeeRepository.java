package org.jsp.assign.repository;

import org.jsp.assign.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{

	@Modifying
    @Transactional
	@Query("delete from Employee e WHERE e.id=?1")
	int deleteEmployeeById(int id);

}
