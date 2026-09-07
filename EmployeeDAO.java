package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.employee.model.Employee;
import com.employee.util.DBConnection;

public class EmployeeDAO {

	
	//FOR ADDING EMP DETAILS  
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employees " +
                     "(name, email, department, salary, phone) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);

            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getDepartment());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());

            int rows = preparedStatement.executeUpdate();

            if (rows > 0) {
                System.out.println("Employee Added Successfully!");
            }

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
        
        //FOR FETCHING/VIEW ALL EMP DETAILS
        public void getAllEmployees() {

            String sql = "SELECT * FROM employees";

            try {

                Connection connection = DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    System.out.println("Employee ID: "
                            + resultSet.getInt("employee_id"));

                    System.out.println("Name: "
                            + resultSet.getString("name"));

                    System.out.println("Email: "
                            + resultSet.getString("email"));

                    System.out.println("Department: "
                            + resultSet.getString("department"));

                    System.out.println("Salary: "
                            + resultSet.getDouble("salary"));

                    System.out.println("Phone: "
                            + resultSet.getString("phone"));

                    System.out.println("-------------------------");
                }

                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        
    }
        
        
        
        
       //FOR FETCHING /VIEW SPECIFIC SELECTED EMP DETAILS BY THEIR ID 
        public void getEmployeeById(int employeeId) {

            String sql = "SELECT * FROM employees WHERE employee_id = ?";

            try {

                Connection connection = DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                preparedStatement.setInt(1, employeeId);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {

                    System.out.println("Employee ID: "
                            + resultSet.getInt("employee_id"));

                    System.out.println("Name: "
                            + resultSet.getString("name"));

                    System.out.println("Email: "
                            + resultSet.getString("email"));

                    System.out.println("Department: "
                            + resultSet.getString("department"));

                    System.out.println("Salary: "
                            + resultSet.getDouble("salary"));

                    System.out.println("Phone: "
                            + resultSet.getString("phone"));

                } else {

                    System.out.println("Employee not found!");

                }

                resultSet.close();
                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        
        
        
        //TO UPDATING EMP DETAILS SUCH AS NAME,EMAIL,SALARY,PHONE,DEPARTMENT
        public void updateEmployee(Employee employee) {

            String sql = "UPDATE employees SET " +
                         "name = ?, email = ?, department = ?, salary = ?, phone = ? " +
                         "WHERE employee_id = ?";

            try {

                Connection connection = DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                preparedStatement.setString(1, employee.getName());
                preparedStatement.setString(2, employee.getEmail());
                preparedStatement.setString(3, employee.getDepartment());
                preparedStatement.setDouble(4, employee.getSalary());
                preparedStatement.setString(5, employee.getPhone());
                preparedStatement.setInt(6, employee.getEmployee());

                int rows = preparedStatement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Employee Updated Successfully!");
                } else {
                    System.out.println("Employee not found!");
                }

                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        
        //TO DELETE EMPLOYEE RECORDS
        public void deleteEmployee(int employeeId) {

            String sql = "DELETE FROM employees WHERE employee_id = ?";

            try {

                Connection connection = DBConnection.getConnection();

                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql);

                preparedStatement.setInt(1, employeeId);

                int rows = preparedStatement.executeUpdate();

                if (rows > 0) {
                    System.out.println("Employee Deleted Successfully!");
                } else {
                    System.out.println("Employee not found!");
                }

                preparedStatement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}     