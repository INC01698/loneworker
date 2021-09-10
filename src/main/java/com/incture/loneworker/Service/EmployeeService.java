package com.incture.loneworker.Service;

import java.util.List;

import com.incture.loneworker.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(long id);
	
	void logout(long id);

	Employee loginEmployee(String email, String pw);
}
