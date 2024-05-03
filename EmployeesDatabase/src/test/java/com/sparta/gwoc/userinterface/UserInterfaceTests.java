package com.sparta.gwoc.userinterface;

import com.sparta.gwoc.dao.EmployeesDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class UserInterfaceTests {
    private static EmployeesDAO mockEmployeesDAO;
    private static UserInterface userInterface;

    @BeforeEach
    public void setUp() {
        mockEmployeesDAO = Mockito.mock(EmployeesDAO.class);
        userInterface = new UserInterface(mockEmployeesDAO);
    }

    @Nested
    @DisplayName("Delete Employee record by Id tests")
    class DeleteEmployeeRecordByIDTests {
        @Test
        @DisplayName("Given a valid id of '227135' should return 1(num of rows updated)")
        void givenAnIdOf1ShouldReturn1() {
           when(userInterface.deleteEmployeeRecordByID("227135")).thenReturn(0);


        }
    }
}

