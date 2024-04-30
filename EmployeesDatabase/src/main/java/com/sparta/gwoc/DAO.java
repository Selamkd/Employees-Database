package com.sparta.gwoc;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DAO {
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;


    //insert employee
    //read employeee
    //edit employee
    //delete employee
    public static Connection getConnection() {

        Properties properties = new Properties();

        readFile(properties);

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        try {

            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}