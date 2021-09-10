package com.incture.loneworker.Service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.incture.loneworker.Service.EmployeeService;
import com.incture.loneworker.exception.ResourceNotFoundException;
import com.incture.loneworker.model.Employee;
import com.incture.loneworker.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()){
			return employee.get();
		}else {
			throw new ResourceNotFoundException("Employee", "id", id);
		}
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		
		//check if employee exists
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setfName(employee.getfName());
		existingEmployee.setlName(employee.getlName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save to db
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.deleteById(id);
		
	}


	@Override
	public Employee loginEmployee(String email, String pw) {
		  
		Optional<Employee> employee = employeeRepository.findByEmail(email);
		  if(employee.isPresent()){
			  Employee loggedIn = employee.get();
			  String password = loggedIn.getPassword();
			  if(pw.equals(password)){
				  loggedIn.setLoggedin(true);
	              employeeRepository.save(loggedIn);
			      return loggedIn;
			  }
			  
				/*  
			  else {
				  //change to pw not found
				  throw new ResourceNotFoundException("Employee", "id", id); 
				}*/
		  }
		
			  return new Employee();
		  /*
		  else {
			  throw new ResourceNotFoundException("Employee", "id", id);
			  */
		 
		  }
		  //Employee loggedInEmployee = employeeRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee", "id", id)); 
		  //List<Employee> findByName(String username);
	

	@Override
	public void logout(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		  if(employee.isPresent()){
			  Employee loggedOut = employee.get();
			  loggedOut.setLoggedin(false);
			  employeeRepository.save(loggedOut);			  			  
		  }

	}
}
	

