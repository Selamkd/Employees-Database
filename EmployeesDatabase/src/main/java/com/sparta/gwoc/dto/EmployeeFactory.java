package com.sparta.gwoc.dto;

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
        ArrayList<String> invalidEmployees = new ArrayList<>();
        Path path = null;

        try(Stream<String> employees = Files.lines(Paths.get(Objects.requireNonNull(EmployeeFactory.class.getClassLoader().getResource("employees-corrupted.csv")).toURI())).skip(1)) {
            employees.forEach(employee -> {
                if(Validator.isValidEmployee(employee)){
                    validEmployees.add(EmployeeParser.convertStringToEmployee(employee));
                }else{
                    invalidEmployees.add(employee);
                }
            });

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        for(String employee : invalidEmployees){
            System.out.println(employee);
        }
        System.out.println(invalidEmployees.size());

        return validEmployees;
    }

    public static void main(String[] args) {
        getValidEmployees();
    }


}
