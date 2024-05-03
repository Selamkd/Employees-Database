package com.sparta.gwoc.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DAOLoggingUtilsTests {

    static SQLException exception;

    @BeforeAll
    static void setupAll() {
        exception = new SQLException("Test exception", "23000", 3024);
    }

    @Test
    @DisplayName("Given a SQLException, logSQLException logs the correct error code")
    void givenASqlExceptionLogSqlExceptionLogsTheCorrectErrorCode() {
        String errorCode = "3024";
        assertThat(DAOLoggingUtils.logSQLException(exception), containsString(errorCode));
    }

    @Test
    @DisplayName("Given a SQLException, logSQLException correctly logs the error message")
    void givenASqlExceptionLogSqlExceptionCorrectlyLogsTheErrorMessage() {
        String errorMessage = "Test exception";
        assertThat(DAOLoggingUtils.logSQLException(exception), containsString(errorMessage));
    }

    @Test
    @DisplayName("Given a SQLException, logSQLException correctly logs the SQL state")
    void givenASqlExceptionLogSqlExceptionCorrectlyLogsTheSqlState() {
        String sqlState = "23000";
        assertThat(DAOLoggingUtils.logSQLException(exception), containsString(sqlState));
    }

}