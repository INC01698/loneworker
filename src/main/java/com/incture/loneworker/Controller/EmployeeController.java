package com.incture.loneworker.Controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.incture.loneworker.Service.EmployeeService;
import com.incture.loneworker.model.Employee;

@RestController
@RequestMapping("/")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("register")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping("users/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("users/{id}")
	public ResponseEntity<Employee> getElementById(@PathVariable("id") long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
	}
	
	@PutMapping("users/edit/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,employeeId), HttpStatus.OK);
	}
	
	@DeleteMapping("users/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<String>("Employee Deleted", HttpStatus.OK);
	}
	

	@GetMapping("login/{name}/{password}")
	public ResponseEntity<Employee> loginEmployee(@PathVariable("name") String name, @PathVariable("password") String password ){
		return new ResponseEntity<Employee>(employeeService.loginEmployee(name,password),HttpStatus.OK);
	}
	
	@GetMapping("logout/{id}")
	public ResponseEntity<String> logoutEmployee(@PathVariable("id") long id ){
		employeeService.logout(id);
		return new ResponseEntity<String>("Successfully Logged Out!",HttpStatus.OK);
	}
	
	
}
