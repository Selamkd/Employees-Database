package com.sparta.gwoc.dao;

import com.sparta.gwoc.dto.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeesDAOTest {

    DAOInterface dao;
    ConnectionManager connectionManager;
    Connection connection;

    @BeforeEach
    void setUp() {
        dao = new EmployeesDAO();
        dao.openDBConnection();
    }

    @AfterEach
    void tearDown() {
        dao.closeDBConnection();
    }

    @Test
    @DisplayName("test to see if getAllEmployees method returns an Array of Employees")
    void testToSeeIfGetAllEmployeesMethodReturnsAnArrayOfEmployees() {
        // Arrange

        // Act
        List<Employee> employees = dao.getAllEmployeeRecords();

        // Assert
        assertNotNull(employees, "The returned list of employees should not be null");
//        // Replace 'expectedSize' with the expected number of employees in the database
//        assertEquals(expectedSize, employees.size(), "The size of the returned list of employees should match the expected size");

    }

//    @Test
//    @DisplayName("test to see if an empty database returns an empty Array")
//    void testToSeeIfAnEmptyDatabaseReturnsAnEmptyArray() {
//
//        EmployeesDAO dao = new EmployeesDAO();
//        List<Employee> employees = dao.getAllEmployeeRecords();
//        assertEquals(0, employees.size(), "The list should be empty when the database is empty.");
//    }

//    @Test
//    @DisplayName("given a list of Employee Data, the database should be populated with that data")
//    void givenAListOfEmployeeDataTheDatabaseShouldBePopulatedWithThatData() {
//
//        org.junit.jupiter.api.Assertions.fail("Not implemented");
//    }
//
//    @Test
//    @DisplayName("given an empty list of Employee data, no data is added to the database")
//    void givenAnEmptyListOfEmployeeDataNoDataIsAddedToTheDatabase() {
//
//        org.junit.jupiter.api.Assertions.fail("Not implemented");
//    }

//    @Test
//    @DisplayName("given an empty list of Employee Data, a warning message should be logged")
//    void givenAnEmptyListOfEmployeeDataAWarningMessageShouldBeLogged() {
//
//        org.junit.jupiter.api.Assertions.fail("Not implemented");
//    }




}