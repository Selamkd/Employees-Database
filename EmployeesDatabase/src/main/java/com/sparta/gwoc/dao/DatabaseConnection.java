package com.sparta.gwoc.dao;

import java.sql.Connection;

public interface DatabaseConnection {
    Connection getConnection();
    void closeConnection();
}
