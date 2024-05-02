package com.sparta.gwoc.dao;

import com.sparta.gwoc.dto.Employee;

import java.sql.SQLException;
import java.util.List;

public interface DAOInterface {
    List<Employee> getAllEmployeeRecords() ;
    Employee getEmployeeRecordByID(String id);
    int deleteEmployeeRecordByID(String id);
    int insertEmployees(List<Employee> employeeList);
    int updateFirstNameById(String id, String newFirstName);

    // start the connection to database
    void openDBConnection();
    void closeDBConnection();


}
