package com.sparta.gwoc;

import com.sparta.gwoc.dao.EmployeesDAO;
import com.sparta.gwoc.userinterface.UserInterface;

public class App {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(new EmployeesDAO());
        ui.openDBConnection();
        ui.loadValidatedEmployeeData();
        ui.closeDBConnection();
    }
}
