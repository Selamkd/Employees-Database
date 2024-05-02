package com.sparta.gwoc.dao;

import com.sparta.gwoc.dto.Employee;

import java.util.List;

public interface CRUDable {
    List<Employee> getAllEmployees();
    Employee getEmployeeByID(String id);
    Integer deleteEmployeeRecordByID(String id);
    
}
