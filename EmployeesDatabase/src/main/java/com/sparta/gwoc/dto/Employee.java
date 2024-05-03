package com.sparta.gwoc.dto;

import java.time.LocalDate;
import java.util.Objects;

public record Employee(String empID, String prefix, String firstName, char middleInitial, String lastName,
                       char gender, String email, LocalDate dateOfBirth, LocalDate dateOfJoin, int salary) {


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(empID, employee.empID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(empID);
    }

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
