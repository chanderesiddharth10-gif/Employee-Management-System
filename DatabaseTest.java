package com.employee.employee_management_api.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DatabaseTest {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    public void testConnection() {

        try {

            Connection connection =
                    DriverManager.getConnection(
                            url,
                            username,
                            password
                    );

            System.out.println("=================================");
            System.out.println("PostgreSQL Connection Successful!");
            System.out.println("Database: employee_db");
            System.out.println("=================================");

            connection.close();

        } catch (Exception e) {

            System.out.println("PostgreSQL Connection Failed!");
            e.printStackTrace();

        }
    }
}