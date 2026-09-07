package com.employee.employee_management_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee_management_api.dao.EmployeeDAO;
import com.employee.employee_management_api.model.Employee;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = {
	    "http://127.0.0.1:5500",
	    "http://localhost:5500"
})

@RestController
public class EmployeeController {

    private final EmployeeDAO employeeDAO;

    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }


    // Test API
    @GetMapping("/api/test")
    public String test() {

        return "Employee Management API is working!";
    }


    // Get All Employees
    @GetMapping("/api/employees")
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }
    
    
    @GetMapping("/api/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id) {

        return employeeDAO.getEmployeeById(id);
    }
    
    @PostMapping("/api/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employeeDAO.addEmployee(employee);

        return employee;
    }
    
    @PutMapping("/api/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeDAO.updateEmployee(employee);

        return employee;
    }
    
    
    @DeleteMapping("/api/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeDAO.deleteEmployee(id);

        return "Employee deleted successfully!";
    }
}