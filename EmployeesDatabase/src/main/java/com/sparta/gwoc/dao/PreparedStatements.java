package com.sparta.gwoc.dao;

public interface PreparedStatements {
    String GET_ALL_EMPLOYEES = "SELECT * FROM employees";
    String GET_EMPLOYEE_BY_ID = "SELECT * FROM employees WHERE emp_id = ?";
    String DELETE_EMPLOYEE_BY_ID = "DELETE FROM employees WHERE emp_id = ?";
    String INSERT_EMPLOYEES = """
            INSERT INTO employees (emp_id, prefix, first_name, middle_name_initial, last_name,
            gender, email, date_of_birth, date_of_joining, salary)
            VALUES (?,?, ?, ? ,?, ?, ?, ?, ?, ?)
            """;
    String UPDATE_FIRSTNAME_BY_ID = "UPDATE employees SET first_name = ? WHERE emp_id = ?";
    String GET_COUNT_OF_ALL_EMPLOYEES = "SELECT COUNT(*) FROM employees";
}
