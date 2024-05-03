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
        assertThat(connection.isValid(5), is(true));
    }

    @Test
    @DisplayName("When connection manager creates a connection, the connection url matches the properties url")
    void whenConnectionManagerCreatesAConnectionTheConnectionUrlMatchesThePropertiesUrl() throws SQLException {
        Connection connection = connectionManager.getConnection();
        String expectedUrl = "jdbc:mysql://localhost/employee_schema";
        String url = connection.getMetaData().getURL();
        assertThat(url, is(equalTo(expectedUrl)));
    }

    @Test
    @DisplayName("Investigate schema")
    void investigateSchema() throws SQLException {
        Connection connection = connectionManager.getConnection();
        String url = connection.getMetaData().getURL();
    }

    @Test
    @DisplayName("When connection manager closes a connection, the connection is closed")
    void whenConnectionManagerClosesAConnectionTheConnectionIsClosed() throws SQLException {
        Connection connection = connectionManager.getConnection();
        connectionManager.closeConnection();
        assertThat(connection.isClosed(), is(true));
    }
}
