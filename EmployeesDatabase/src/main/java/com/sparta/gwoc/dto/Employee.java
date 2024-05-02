package com.sparta.gwoc.dto;

import java.time.LocalDate;

public record Employee(String empID, String prefix, String firstName, char middleInitial, String lastName,
                       char gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoin, int salary) {

    @Override
    public String toString(){
        return  "\n" +
                "_______________________________________" + "\n" +
                "Employee ID: " +empID + "\n" +
                "Name: " + firstName + " " + middleInitial + " " + lastName + "\n" +
                "Gender: " + gender + "\n" +
                "Email: " + email + "\n" +
                "Date of Birth: " + dateOfBirth + "\n" +
                "Date of Join: " + dateOfJoin + "\n" +
                "Salary: " + salary + "\n";
    }
}