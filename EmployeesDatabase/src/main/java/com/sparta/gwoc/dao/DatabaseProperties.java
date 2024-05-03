package com.sparta.gwoc.dao;

import com.sparta.gwoc.utils.LoggerUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public record DatabaseProperties(String url, String username, String password) {

    private static final Logger logger = LoggerUtil.getLogger(DatabaseProperties.class.getName());

    public static DatabaseProperties loadPropertiesFromFile() {
        Properties properties = new Properties();
        try {
            logger.info("Attempting to read properties from file: ");
            properties.load(new FileReader("src/main/resources/database.properties"));
        } catch (FileNotFoundException e) {
            logger.severe("Cannot find file. " + e.getMessage());
        } catch (IOException e) {
            logger.severe("Error reading from file. " + e.getMessage());
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return new DatabaseProperties(url, username, password);

    }
}
