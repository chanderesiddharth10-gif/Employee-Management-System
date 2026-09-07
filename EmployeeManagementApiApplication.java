package com.employee.employee_management_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.employee.employee_management_api.config.DatabaseTest;

@SpringBootApplication
public class EmployeeManagementApiApplication {

    public static void main(String[] args) {

        var context =
                SpringApplication.run(
                        EmployeeManagementApiApplication.class,
                        args
                );

        DatabaseTest databaseTest =
                context.getBean(DatabaseTest.class);

        databaseTest.testConnection();
    }
}