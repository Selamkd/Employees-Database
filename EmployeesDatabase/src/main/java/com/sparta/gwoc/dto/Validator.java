package com.sparta.gwoc.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidEmployee(String employee){
        String[] fields = employee.split(",");
        return isValidEmployeeID(fields[0])
                && isValidPrefix(fields[1])
                && isValidString(fields[2])
                && isValidCharacter(fields[3])
                && isValidString(fields[4])
                && isValidGender(fields[5])
                && isValidEmail(fields[6])
                && isValidDate(fields[7], fields[8])
                && isValidSalary(fields[9]);
    }

    // EmployeeID can start with 0
    public static boolean isValidEmployeeID(String empID){
        return empID != null && empID.length() == 6 && empID.matches("^[0-9]{6}$");
    }

    public static boolean isValidGender(String gender){
        return gender.equals("M") || gender.equals("F");
    }

    public static boolean isValidCharacter(String character){
        return character.matches("[A-Z]");
    }

    public static boolean isValidEmail(String email){
        return email != null
                && email.matches("^[a-zA-Z][a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]*" + // Matches local part
                        "@" + // Matches @
                        "[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$" // Matches domain
                );
    }

    public static boolean isValidString(String string){
        return string != null && string.matches("^[A-Za-z]+");
    }

    public static boolean isValidPrefix(String prefix){
        return prefix != null && prefix.matches("^[A-Za-z]+[.]");
    }

    public static boolean isValidDateFormat(String date){
        return date != null && date.matches("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}");
    }

    public static boolean isValidDate(String birthDate, String joinDate){
        if(!(isValidDateFormat(birthDate) && isValidDateFormat(joinDate))){
            return false;
        }
        
        LocalDate dateOfBirth = getLocalDateFromString(birthDate);
        LocalDate dateOfJoining = getLocalDateFromString(joinDate);
        
        return dateOfBirth.isBefore(dateOfJoining);
    }

    private static LocalDate getLocalDateFromString(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(date, dateTimeFormatter);
    }

    public static boolean isValidSalary(String empSalary){
        Integer salary = convertStringToInteger(empSalary);
        return salary != null && salary > 0;
    }
    
    private static Integer convertStringToInteger(String str){
        Integer integer = null;
        try{
            integer = Integer.parseInt(str);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return integer;
    }




}
