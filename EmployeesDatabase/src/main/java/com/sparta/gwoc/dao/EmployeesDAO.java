package com.sparta.gwoc.dao;

import com.sparta.gwoc.dto.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO implements DAOInterface {
    private static Connection dbConnection;
    private static PreparedStatements preparedStatements;
    private static ResultSet resultSet;


    @Override
    public void openDBConnection() {
        DatabaseProperties properties = DatabaseProperties.loadPropertiesFromFile();
        ConnectionManager connectionManager = new ConnectionManager(properties);
        dbConnection = connectionManager.getConnection();
    }

    @Override
    public List<Employee> getAllEmployeeRecords() {
        List<Employee> employeeList = new ArrayList<>();

        try (Statement statement = dbConnection.createStatement();
             ResultSet resultSet = statement.executeQuery(PreparedStatements.GET_ALL_EMPLOYEES);) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee getEmployeeRecordByID(String id) {
        return null;
    }

    @Override
    public int deleteEmployeeRecordByID(String id) {

        try (Statement statement = dbConnection.createStatement();
             ResultSet resultSet = statement.executeQuery(PreparedStatements.DELETE_EMPLOYEE_BY_ID);) {
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

                //employeeList.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int insertEmployees(List<Employee> employeeList) {
        return 0;
    }

    @Override
    public int updateFirstNameById(String id, String newFirstName) {
        return 0;
    }


    public void closeDBConnection() {
        try {
            dbConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        EmployeesDAO dao = new EmployeesDAO();
        dao.openDBConnection();
        List<Employee> employees = dao.getAllEmployeeRecords();
        dao.closeDBConnection();
        System.out.println(employees);
    }


}
