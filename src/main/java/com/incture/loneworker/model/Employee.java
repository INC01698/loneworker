package com.incture.loneworker.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE_DETAILS")

public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long eid;
	
	@Column(name="first_name" ,  nullable = false)
	@JsonProperty(value = "fName")
	private String fName;
	
	@Column(name="last_name")
	@JsonProperty(value = "lName")
	private String lName;
	
	@Column(name="email" ,  nullable = false)
	@JsonProperty(value = "email")
	private String email;

	@Column(name="password" ,  nullable = false)
	@JsonProperty(value = "password")
	private String password;
	
	@Column(name="dep" ,  nullable = false)
	@JsonProperty(value = "dep")
	private String dep;

	@Column(name="admin" ,  nullable = false)
	@JsonProperty(value = "admin")
	private String admin;
	
	@Column(name="logged_in")
	@JsonProperty(value = "loggedin")
	private boolean loggedin;
	
	public Employee() {
		
	}

	public Employee(long eid, String fName, String lName, String email, String password, String dep, String admin,
			boolean loggedin) {
		super();
		this.eid = eid;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.password = password;
		this.dep = dep;
		this.admin = admin;
		this.loggedin = loggedin;
	}

	public long getEid() {
		return eid;
	}

	public void setEid(long eid) {
		this.eid = eid;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDep() {
		return dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", password="
				+ password + ", dep=" + dep + ", admin=" + admin + ", loggedin=" + loggedin + "]";
	}
		
}
