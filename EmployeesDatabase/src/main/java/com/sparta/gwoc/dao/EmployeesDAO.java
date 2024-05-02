package com.sparta.gwoc.dao;

import com.sparta.gwoc.dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
    private static Connection dbConnection;
    private static PreparedStatements preparedStatements;
    private static ResultSet resultSet;



    public void init() {
        DatabaseProperties properties = DatabaseProperties.loadPropertiesFromFile();
        ConnectionManager connectionManager = new ConnectionManager(properties);
        dbConnection = connectionManager.getConnection();

    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(PreparedStatements.GET_ALL_EMPLOYEES);
        System.out.println(resultSet);
        while (resultSet.next()) {
            Employee employee = new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4).charAt(0),
                    resultSet.getString(5),
                    resultSet.getString(6).charAt(0),
                    resultSet.getString(7),
                    resultSet.getDate(8).toLocalDate(),
                    resultSet.getDate(9).toLocalDate(),
                    resultSet.getInt(10)

            );
            employeeList.add(employee);
        }
        return employeeList;
    }

    public static void main(String[] args) throws SQLException {
        EmployeesDAO dao = new EmployeesDAO();
        dao.init();
        List<Employee> employees = dao.getAllEmployees();
        dbConnection.close();
        System.out.println(employees);
    }


}
