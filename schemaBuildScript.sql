-- Create schema if it does not exist
CREATE SCHEMA IF NOT EXISTS employee_schema;

-- Switch to the created schema
USE employee_schema;

-- Drop the employees table if it exists
DROP TABLE IF EXISTS employees;

-- Create table for employees
CREATE TABLE IF NOT EXISTS employees (
    emp_id int PRIMARY KEY,
    prefix VARCHAR(10) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    middle_name_initial CHAR(1) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    gender CHAR(1) NOT NULL,
    email VARCHAR(100) NOT NULL,
	date_of_birth DATE NOT NULL,
    date_of_joining DATE NOT NULL,
    salary int NOT NULL
);

-- Insert data into employees table
-- INSERT INTO employee_schema.employees (emp_id, prefix, first_name, middle_name_initial, last_name, 
-- gender, email, date_of_birth, date_of_joining, salary) 
-- VALUES (111111, 'Mr.', 'Manish', 'B', 'Gadhvi', 'M', 'email@mail.com', '2020-05-15', '2020-05-15', 20000);

-- INSERT INTO employee_schema.employees (emp_id, prefix, first_name, middle_name_initial, last_name, 
-- gender, email, date_of_birth, date_of_joining, salary) 
-- VALUES (222222, 'Mr.', 'Alex', 'E', 'Blunt', 'M', 'alex@mail.com', '2020-05-15', '2020-05-15', 30000);
