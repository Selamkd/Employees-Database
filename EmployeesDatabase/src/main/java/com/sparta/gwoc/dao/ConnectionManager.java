package com.sparta.gwoc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager implements DatabaseConnection {

    private Connection connection;
    private final DatabaseProperties properties;

    public ConnectionManager(DatabaseProperties properties) {
     this.properties = properties;
    }

    public void setUpConnection() {
        try {
            connection = DriverManager.getConnection(properties.url(), properties.username(), properties.password());
        } catch (SQLException e) {
            e.printStackTrace();
            connection = null;
        }
    }

    @Override
    public Connection getConnection() {
        if (connection == null) {
            setUpConnection();
        }
        return connection;
    }

    @Override
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}