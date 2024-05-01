package com.sparta.gwoc;

import java.time.LocalDate;

public class Validator {

    private boolean validEmployeeID(int empID){
        return empID < 1000000 && empID > 99999;
    }

    private boolean validGender(char gender){
        return gender == 'M' || gender == 'F';
    }

    private boolean validCharacter(char character){
        return character >='a' && character <= 'z';
    }

    private boolean validEmail(String email){
        return email != null
                && email.matches("^[A-Za-z]+(\\.[A-Za-z]+)*" + // Matches local part
                "@" + // Matches @
                "[A-Za-z]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" // Matches Domain
        );
    }

    private static boolean validString(String string){
        return string != null && string.matches("^[A-Za-z]+");
    }

    private static boolean validPrefix(String prefix){
        return prefix != null && prefix.matches("^[A-Za-z]+[.]");
    }

    private static boolean validSalary(int salary){
        return salary > 0;
    }


}
