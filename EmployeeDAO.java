package com.employee.employee_management_api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.employee.employee_management_api.model.Employee;

@Repository
public class EmployeeDAO {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;


    // Get All Employees
    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<>();

        String sql = "SELECT * FROM employees";

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            ResultSet resultSet =
                    preparedStatement.executeQuery();


            while (resultSet.next()) {

                Employee employee = new Employee();

                employee.setEmployee(
                	    resultSet.getInt("employee_id")
                	);

                employee.setName(
                        resultSet.getString("name")
                );

                employee.setEmail(
                        resultSet.getString("email")
                );

                employee.setDepartment(
                        resultSet.getString("department")
                );

                employee.setSalary(
                        resultSet.getDouble("salary")
                );

                employee.setPhone(
                        resultSet.getString("phone")
                );

                employees.add(employee);
            }


            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return employees;
    }


    public Employee getEmployeeById(int employeeId) {

        String sql = "SELECT * FROM employees WHERE employee_id = ?";

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, employeeId);

            ResultSet resultSet =
                    preparedStatement.executeQuery();

            if (resultSet.next()) {

                Employee employee = new Employee();

                employee.setEmployee(
                        resultSet.getInt("employee_id")
                );

                employee.setName(
                        resultSet.getString("name")
                );

                employee.setEmail(
                        resultSet.getString("email")
                );

                employee.setDepartment(
                        resultSet.getString("department")
                );

                employee.setSalary(
                        resultSet.getDouble("salary")
                );

                employee.setPhone(
                        resultSet.getString("phone")
                );

                resultSet.close();
                preparedStatement.close();
                connection.close();

                return employee;
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }
    
    
 // Add Employee
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees " +
                     "(name, email, department, salary, phone) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Employee Added Successfully!");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void updateEmployee(Employee employee) {

        String sql = "UPDATE employees SET " +
                     "name = ?, " +
                     "email = ?, " +
                     "department = ?, " +
                     "salary = ?, " +
                     "phone = ? " +
                     "WHERE employee_id = ?";

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setInt(6, employee.getEmployee());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Employee Updated Successfully!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    
    public void deleteEmployee(int employeeId) {

        String sql = "DELETE FROM employees WHERE employee_id = ?";

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setInt(1, employeeId);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            System.out.println("Employee Deleted Successfully!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}