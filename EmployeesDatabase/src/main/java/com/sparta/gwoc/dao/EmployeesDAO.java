package com.sparta.gwoc.dao;

import java.sql.Connection;

public class EmployeesDAO {
    private static Connection dbConnection;

   public void init() {
       DatabaseProperties properties = DatabaseProperties.loadPropertiesFromFile();
       ConnectionManager connectionManager = new ConnectionManager(properties);
       dbConnection = connectionManager.getConnection();
   }

//   public ArrayList<Employee> getAllEmployees() {
//
//   }


}
