package com.employee.main;

import java.util.Scanner;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class EmployeeManagement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeDAO employeeDAO = new EmployeeDAO();

        while (true) {

            System.out.println(" ********************************* ");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println(" ********************************** ");

            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {

            case 1:

                scanner.nextLine();

                Employee employee = new Employee();

                System.out.print("Enter Name: ");
                employee.setName(scanner.nextLine());

                System.out.print("Enter Email: ");
                employee.setEmail(scanner.nextLine());

                System.out.print("Enter Department: ");
                employee.setDepartment(scanner.nextLine());

                System.out.print("Enter Salary: ");
                employee.setSalary(scanner.nextDouble());

                scanner.nextLine();

                System.out.print("Enter Phone: ");
                employee.setPhone(scanner.nextLine());

                employeeDAO.addEmployee(employee);

                break;

            case 2:
            	employeeDAO.getAllEmployees();

                break;

            case 3:
                System.out.print("Enter Employee ID: ");
                int searchId = scanner.nextInt();

                employeeDAO.getEmployeeById(searchId);

                break;

            case 4:
                System.out.print("Enter Employee ID to update: ");
                int updateId = scanner.nextInt();

                scanner.nextLine();

                Employee updateEmployee = new Employee();

                updateEmployee.setEmployee(updateId);

                System.out.print("Enter New Name: ");
                updateEmployee.setName(scanner.nextLine());

                System.out.print("Enter New Email: ");
                updateEmployee.setEmail(scanner.nextLine());

                System.out.print("Enter New Department: ");
                updateEmployee.setDepartment(scanner.nextLine());

                System.out.print("Enter New Salary: ");
                updateEmployee.setSalary(scanner.nextDouble());

                scanner.nextLine();

                System.out.print("Enter New Phone: ");
                updateEmployee.setPhone(scanner.nextLine());

                employeeDAO.updateEmployee(updateEmployee);

                break;

            case 5:
                System.out.print("Enter Employee ID to delete: ");
                int deleteId = scanner.nextInt();

                employeeDAO.deleteEmployee(deleteId);

                break;

            case 6:
                System.out.println(
                        "Thank you for using Employee Management System!");

                scanner.close();

                return;

            default:
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}