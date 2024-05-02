package com.sparta.gwoc.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public record DatabaseProperties(String url, String username, String password) {

    public static DatabaseProperties loadPropertiesFromFile() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/database.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        return new DatabaseProperties(url, username, password);

    }
}
