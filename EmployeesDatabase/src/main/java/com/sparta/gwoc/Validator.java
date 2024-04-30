package com.sparta.gwoc;

public class Validator {

    private boolean validEmployeeID(int empID){
        return empID < 1000000 && empID > 99999;
    }

    private boolean validGender(char gender){
        return gender == 'M' || gender == 'F';
    }

    private boolean validCharacter(String string){
        return string != null && string.matches("[A-Z]");
    }

    private static boolean validEmail(String email){
        return email != null
                && email.matches("^[A-Za-z]+(\\.[A-Za-z]+)*" + // Matches local part
                "@" + // Matches @
                "[A-Za-z]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$" // Matches Domain
        );
    }
}
