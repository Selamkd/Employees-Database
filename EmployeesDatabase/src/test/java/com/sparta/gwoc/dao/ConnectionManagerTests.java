package com.sparta.gwoc.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConnectionManagerTests {

    static ConnectionManager connectionManager;

    @BeforeAll
    static void setupAll() {
        DatabaseProperties properties = new DatabaseProperties(
                "jdbc:mysql://localhost/employee_schema", "root", "root");
        connectionManager = new ConnectionManager(properties);
    }

    @Test
    @DisplayName("When connection manager creates a connection, the connection is valid")
    void whenConnectionManagerCreatesAConnectionTheConnectionIsValid() throws SQLException {
        Connection connection = connectionManager.getConnection();
        assertThat(true, equalTo(connection.isValid(5)));
    }

    @Test
    @DisplayName("When connection manager creates a connection, the connection url matches the properties url")
    void whenConnectionManagerCreatesAConnectionTheConnectionUrlMatchesThePropertiesUrl() throws SQLException {
        Connection connection = connectionManager.getConnection();
        String url = connection.getMetaData().getURL();
        assertThat("jdbc:mysql://localhost/employee_schema", is(equalTo(url)));
    }

    @Test
    @DisplayName("Investigate schema")
    void investigateSchema() throws SQLException {
        Connection connection = connectionManager.getConnection();
        String url = connection.getMetaData().getURL();
    }
}
