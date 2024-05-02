package com.sparta.gwoc.dao;

import com.sparta.gwoc.dto.Employee;
import com.sparta.gwoc.utils.LoggerUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeesDAO implements DAOInterface {
    public static Connection dbConnection;
    private static final Logger logger = Logger.getLogger(EmployeesDAO.class.getName());

    static {
            LoggerUtil.setup(logger);
    }

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
             ResultSet resultSet = statement.executeQuery(PreparedStatements.GET_ALL_EMPLOYEES)) {
            System.out.println(resultSet);
            while (resultSet.next()) {
                Employee employee = resultSetToEmployee(resultSet);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            logger.warning("SQL Statement Execution Failed" + logSQLException(e));
        }
        return employeeList;
    }


    private Employee resultSetToEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
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
    }


    @Override
    public Employee getEmployeeRecordByID(String id) {
        Employee employee = null;

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(PreparedStatements.GET_EMPLOYEE_BY_ID)) {
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(resultSet);
            if (resultSet.next()) {
                employee = resultSetToEmployee(resultSet);
            }
        } catch (SQLException e) {
            logger.warning("SQL Statement Execution Failed" + logSQLException(e));
        }
        return employee;
    }


    @Override
    public int deleteEmployeeRecordByID(String id) {
        int recordsUpdated = 0;
        try (PreparedStatement preparedStatements = dbConnection.prepareStatement(PreparedStatements.DELETE_EMPLOYEE_BY_ID)) {
            preparedStatements.setString(1, id);
            recordsUpdated = preparedStatements.executeUpdate();

        } catch (SQLException e) {
            logger.warning("SQL Statement Execution Failed" + logSQLException(e));
        }
        return recordsUpdated;
    }


    @Override
    public int insertEmployees(List<Employee> employeeList) {
        int recordsInserted = 0;
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(PreparedStatements.INSERT_EMPLOYEES)) {
            for (Employee employee : employeeList) {
                prepareInsertStatement(employee, preparedStatement);
                recordsInserted += preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            logger.warning("SQL Statement Execution Failed" + logSQLException(e));
        }
        return recordsInserted;
    }

    private void prepareInsertStatement(Employee employee, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, employee.empID());
        preparedStatement.setString(2, employee.prefix());
        preparedStatement.setString(3, employee.firstName());
        preparedStatement.setString(4, String.valueOf(employee.middleInitial()));
        preparedStatement.setString(5, employee.lastName());
        preparedStatement.setString(6, String.valueOf(employee.gender()));
        preparedStatement.setString(7, employee.email());
        preparedStatement.setDate(8, Date.valueOf(employee.dateOfBirth()));
        preparedStatement.setDate(9, Date.valueOf(employee.dateOfJoin()));
        preparedStatement.setInt(10, employee.salary());
    }


    @Override
    public int updateFirstNameById(String id, String newFirstName) {
        int rowsAffected = 0;
        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(PreparedStatements.UPDATE_FIRSTNAME_BY_ID)) {
            preparedStatement.setString(1, newFirstName);
            preparedStatement.setString(2, id);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.warning("SQL Statement Execution Failed" + logSQLException(e));
        }
        return rowsAffected;
    }

    @Override
    public int countTheNumberOfEmployees() {
        int totalCount  =0;

        try (Statement statement = dbConnection.createStatement();
             ResultSet resultSet = statement.executeQuery(PreparedStatements.GET_COUNT_OF_ALL_EMPLOYEES)) {

            while (resultSet.next()) {
                totalCount = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            logger.warning("SQL Statement Execution Failed" + logSQLException(e));
        }
        return totalCount;
}

    @Override
    public void closeDBConnection() {
        try {
            dbConnection.close();
            logger.info("Database connection closed successfully.");
        } catch (SQLException e) {
            logger.warning("Unable to close database connection."
                            + logSQLException(e));
        }
    }

    private String logSQLException(SQLException e) {
        return " Error " + e.getErrorCode() + " " + e.getMessage();
    }

    public static void main(String[] args) throws SQLException {
        EmployeesDAO dao = new EmployeesDAO();
        dao.openDBConnection();
        List<Employee> employees = dao.getAllEmployeeRecords();
        Employee manish = dao.getEmployeeRecordByID("111111");

        Employee bob = new Employee("333334", "Mr.", "Bob", 'B', "Brown", 'M',
                "bob@bob.com", LocalDate.now(), LocalDate.now(), 30000);
        int inserted = dao.insertEmployees(List.of(bob));
        System.out.println(inserted + " records inserted");

        dao.closeDBConnection();
        System.out.println(employees);
        System.out.println(manish);

    }


}

