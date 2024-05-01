package com.sparta.gwoc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeParser {

    public static Employee convertStringToEmployee(String employeeRecord) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String[] parts = employeeRecord.split(",");

        return new Employee(
                Integer.parseInt(parts[0]),                  // empID
                parts[1],                                    // prefix
                parts[2],                                    // firstName
                parts[3].charAt(0),                          // middleInitial
                parts[4],                                    // lastName
                parts[5].charAt(0),                          // gender
                parts[6],                                    // email
                LocalDate.parse(parts[7], formatter),        // dateOfBirth
                LocalDate.parse(parts[8], formatter),        // dateOfJoin
                Integer.parseInt(parts[9])                  // salary
        );
    }
}
