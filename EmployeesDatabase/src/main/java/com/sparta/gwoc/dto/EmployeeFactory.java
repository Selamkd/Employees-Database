package com.sparta.gwoc.dto;


import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static com.sparta.gwoc.dto.EmployeeParser.*;

public class EmployeeFactory {
    static final Logger LOGGER = Logger.getLogger(EmployeeFactory.class.getName());

    public static ArrayList<Employee> getValidEmployees(){
        ArrayList<Employee> validEmployees = new ArrayList<>();
        ArrayList<Employee> invalidEmployees = new ArrayList<>();
        ArrayList<Employee> duplicateEmployees = new ArrayList<>();
        Path path = null;
        LOGGER.info("Starting to go through employees-corrupted csv file");
        try(Stream<String> employees = Files.lines(Paths.get(Objects.requireNonNull(EmployeeFactory.class.getClassLoader().getResource("employees-corrupted.csv")).toURI())).skip(1)) {
            employees.forEach(employee -> {

                if(validEmployees.contains(convertStringToEmployee(employee))){
                    duplicateEmployees.add(convertStringToEmployee(employee));
                    validEmployees.remove(convertStringToEmployee(employee));
                }
                if(Validator.isValidEmployee(employee) && !duplicateEmployees.contains(convertStringToEmployee(employee))){
                    LOGGER.fine("Employee: " + employee + " is valid" );
                    validEmployees.add(convertStringToEmployee(employee));
                }else{
                    LOGGER.fine("Employee: " + employee + " is invalid");
                    invalidEmployees.add(convertStringToEmployee(employee));
                }
            });

        } catch (IOException | URISyntaxException e) {
            LOGGER.warning("File don't exists, ensure file is in the correct location (Inside resources file) and is named employees-corrupted.csv");
        }
        LOGGER.info("Finished going through employees-corrupted csv file");

        LOGGER.info("All invalid employees: "
                + invalidEmployees
                + "\nThe IDs of all duplicate employees: "
                + getIDs(duplicateEmployees)
                + "\nIn total "
                + (invalidEmployees.size() - duplicateEmployees.size())
                + " employee are invalid"
                + " and " + duplicateEmployees.size()
                + " employee are duplicates."
                + "\nCurrently there are "
                + validEmployees.size()
                + " valid employees");
        return validEmployees;
    }

    private static ArrayList<String> getIDs(ArrayList<Employee> employees){
        ArrayList<String> IDs = new ArrayList<>();
        for(Employee employee : employees){
            IDs.add(employee.empID());
        }
        return IDs;
    }
}
