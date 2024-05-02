package com.sparta.gwoc.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    static final Logger LOGGER = Logger.getLogger(Validator.class.getName());
    static final ArrayList<String> validPrefix = new ArrayList<>(Arrays.asList("Dr.", "Mrs.", "Hon.", "Mr.", "Ms.", "Drs.", "Prof."));

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
        if(empID != null && empID.length() == 6){
            LOGGER.fine("Valid ID");
            return true;
        }
        LOGGER.fine("EmployeeID: " + empID + "\nIs an invalid ID, ID must be of length 6");
        return false;
    }

    public static boolean isValidGender(String gender){
        if(gender.equals("M") || gender.equals("F")){
            LOGGER.fine("Valid gender");
            return true;
        }
        LOGGER.fine("Gender: " + gender + "\nIs an invalid gender, gender must be either M or F");
        return false;
    }

    public static boolean isValidCharacter(String character){
        if(character != null &&  character.matches("[A-Z]")){
            LOGGER.fine("Valid character");
            return true;
        }
        LOGGER.fine("Middle initial: " + character + "\nIs an invalid middle initial, middle initial must be a single capital alphabetical letter");
        return false;
    }

    public static boolean isValidEmail(String email){
        if(email != null && email.matches("^[A-Za-z]+([A-Za-z0-9.-]+)*" //First part of email
                    + "@" // Matches @
                    + "[A-Za-z]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")){ // Matches Domain
            LOGGER.fine("Valid email");
            return true;
        }
        LOGGER.fine("Email: " + email + "\nIs an invalid email, email must be in format xxxxx@xxxxx.xxx");
        return false;
    }

    public static boolean isValidString(String string){
        if(string != null && string.matches("^[A-Za-z]+")){
            LOGGER.fine("Valid name");
            return true;
        }
        LOGGER.fine("First/Last name: " + string + "\nIs an invalid name, name must only contain alphabetical letter");
        return false;
    }

    public static boolean isValidPrefix(String prefix){
        if(validPrefix.contains(prefix)){
            LOGGER.fine("Valid prefix");
            return true;
        }
        LOGGER.fine("Prefix: " + prefix + "\nIs an invalid prefix, current valid prefix are " + validPrefix);
        return false;
    }

    private static boolean isValidDateFormat(String date){
        return date != null && date.matches("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}");
    }

    public static boolean isValidDate(String birthDate, String joinDate){
        if(!(isValidDateFormat((birthDate)))){
            LOGGER.fine("Birth date: " + birthDate + "\nIs an invalid birth date");
            return false;
        }
        if(!(isValidDateFormat(joinDate))){
            LOGGER.fine("Join date: " + joinDate + "\nIs an invalid join date");
            return false;
        }
        
        LocalDate dateOfBirth = getLocalDateFromString(birthDate);
        LocalDate dateOfJoining = getLocalDateFromString(joinDate);

        if(dateOfBirth.isAfter(dateOfJoining)){
            LOGGER.fine("Date of birth can not be after date of joining" +
                    "Date of birth: " + dateOfBirth + "\n" +
                    "Date of join: " + dateOfJoining);
            return false;
        }

        if(dateOfJoining.isAfter(LocalDate.now())){
            LOGGER.fine("Date of joining can not be in the future" +
                    "Date of join: " + dateOfJoining + "\n" +
                    "Current date: " +LocalDate.now());
            return false;
        }
        LOGGER.fine("Valid dates");
        return true;
    }

    private static LocalDate getLocalDateFromString(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(date, dateTimeFormatter);
    }

    public static boolean isValidSalary(String empSalary){
        Integer salary = convertStringToInteger(empSalary);
        if(salary == null){
            LOGGER.fine("Salary must be a number");
            return false;
        }
        if(salary < 0){
            LOGGER.fine("Salary: " + salary + "\nSalary can't be negative");
            return false;
        }
        LOGGER.fine("Valid Salary");
        return true;
    }
    
    private static Integer convertStringToInteger(String str){
        Integer integer = null;
        try{
            integer = Integer.parseInt(str);
        }catch(NumberFormatException e){
            LOGGER.fine("Can not convert to integer" +
                    "\n" + str + " is not a number");
        }
        return integer;
    }
}
