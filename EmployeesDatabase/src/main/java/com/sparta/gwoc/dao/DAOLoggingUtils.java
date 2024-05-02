package com.sparta.gwoc.dao;

import java.sql.SQLException;

public class DAOLoggingUtils {
    public static String logSQLException(SQLException e) {
        return ". Error " + e.getErrorCode()
                + " (SQL state: " + e.getSQLState() + ")"
                + " " + e.getMessage();
    }
}
