package com.sparta.gwoc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    private static boolean isValidEmployeeID(String empID){
        Integer id = convertStringToInteger(empID);
        return id != null && id < 1000000 && id > 99999;
    }

    private static boolean isValidGender(String gender){
        return gender.equals("M") || gender.equals("F");
    }

    private static boolean isValidCharacter(String character){
        return character.matches("[A-Z]");
    }

    private static boolean isValidEmail(String email){
        return email != null
                && email.matches(
                        "^[A-Za-z]+(\\.[A-Za-z]+)*" + // Matches local part
                        "@" + // Matches @
                        "[A-Za-z]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" // Matches Domain
                );
    }

    private static boolean isValidString(String string){
        return string != null && string.matches("^[A-Za-z]+");
    }

    private static boolean isValidPrefix(String prefix){
        return prefix != null && prefix.matches("^[A-Za-z]+[.]");
    }

    private static boolean isValidDateFormat(String date){
        return date != null && date.matches("[0-9]{1,2}\\/[0-9]{1,2}\\/[0-9]{4}");
    }

    private static boolean isValidDate(String birthDate, String joinDate){
        if(!(isValidDateFormat(birthDate) && isValidDateFormat(joinDate))){
            return false;
        }
        
        LocalDate dateOfBirth = getLocalDateFromString(birthDate);
        LocalDate dateOfJoining = getLocalDateFromString(joinDate);
        
        return dateOfBirth.isBefore(dateOfJoining);
    }

    private static LocalDate getLocalDateFromString(String date){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("mm/dd/yyyy");
        return LocalDate.parse(date, dateTimeFormatter);
    }

    private static boolean isValidSalary(String empSalary){
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
