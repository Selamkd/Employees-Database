package com.sparta.gwoc.dao;

import com.sparta.gwoc.utils.LoggerUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ConnectionManager implements DatabaseConnection {

    private Connection connection;
    private final DatabaseProperties properties;
    private static final Logger logger = LoggerUtil.getLogger(ConnectionManager.class.getName());

    public ConnectionManager(DatabaseProperties properties) {
     this.properties = properties;
    }

    public void setUpConnection() {
        try {
            logger.info("Attempting to establish connection to database: " + properties.url());
            connection = DriverManager.getConnection(properties.url(), properties.username(), properties.password());
        } catch (SQLException e) {
            logger.severe("Unable to establish connection" + DAOLoggingUtils.logSQLException(e));
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
                logger.info("Attempting to close connection to database.");
                connection.close();
            } catch (SQLException e) {
                logger.severe("Unable to close database connection." + DAOLoggingUtils.logSQLException(e));
            }
        }
    }
}