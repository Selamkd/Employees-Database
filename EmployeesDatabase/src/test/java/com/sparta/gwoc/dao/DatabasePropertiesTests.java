package com.sparta.gwoc.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class DatabasePropertiesTests {

    @Test
    @DisplayName("After loading properties from file, the expected URL is loaded")
    void afterLoadingPropertiesFromFileTheExpectedUrlIsLoaded() {
        DatabaseProperties properties = DatabaseProperties.loadPropertiesFromFile();
        assertThat(properties.url(), is(equalTo("jdbc:mysql://localhost/employee_schema")));
    }

    @Test
    @DisplayName("After loading properties from file, the username is root")
    void afterLoadingPropertiesFromFileTheUsernameIsRoot() {
        DatabaseProperties properties = DatabaseProperties.loadPropertiesFromFile();
        assertThat(properties.username(), is(equalTo("root")));
    }

    @Test
    @DisplayName("After loading properties from file, the password is root")
    void afterLoadingPropertiesFromFileThePasswordIsRoot() {
        DatabaseProperties properties = DatabaseProperties.loadPropertiesFromFile();
        assertThat(properties.password(), is(equalTo("root")));
    }
}
