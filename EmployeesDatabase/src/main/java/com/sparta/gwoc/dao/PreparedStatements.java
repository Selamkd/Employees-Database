package com.sparta.gwoc.dao;

public interface PreparedStatements {
    String GET_ALL_EMPLOYEES = "SELECT * FROM employees";
    String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE empID = ?";

}
