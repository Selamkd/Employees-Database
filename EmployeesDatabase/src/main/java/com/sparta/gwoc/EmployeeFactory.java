package com.sparta.gwoc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class EmployeeFactory {

    public static ArrayList<Employee> getValidEmployees(){

        ArrayList<Employee> validEmployees = new ArrayList<>();
        Path path = null;

        try(Stream<String> lines = Files.lines(
                Paths.get(Objects.requireNonNull(EmployeeFactory.class.getClassLoader().getResource("employees-corrupted.csv")).toURI())))
        {
            lines.forEach(line ->{

            });

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return validEmployees;
    }

    public static void main(String[] args) {
        System.out.println(getValidEmployees());
    }
}
