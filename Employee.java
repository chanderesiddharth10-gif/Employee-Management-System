package com.employee.model;

public class Employee {
	
	
	private int employee;
	private String name;
	private String email;
	private String department;
	private double salary;
	private String phone;
	
	
	
	
	public Employee(int employee, String name, String email, String department, double salary, String phone) {
		super();
		this.employee = employee;
		this.name = name;
		this.email = email;
		this.department = department;
		this.salary = salary;
		this.phone = phone;
	}
	
	




public Employee() {
		super();
	}






public int getEmployee() {
		return employee;
	}
public void setEmployee(int employee) {
		this.employee = employee;
	}


public String getName() {
		return name;
	}
public void setName(String name) {
		this.name = name;
	}


public String getEmail() {
		return email;
	}
public void setEmail(String email) {
		this.email = email;
	}


public String getDepartment() {
		return department;
	}
public void setDepartment(String department) {
		this.department = department;
	}


public double getSalary() {
		return salary;
	}
public void setSalary(double salary) {
		this.salary = salary;
	}


public void setPhone(String phone) {
      this.phone = phone;
}

public String getPhone() {
	return phone;
	}
}
