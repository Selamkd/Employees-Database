package com.sparta.gwoc.userinterface;

import com.sparta.gwoc.dao.EmployeesDAO;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
public class UserInterfaceTests {
    private static EmployeesDAO mockEmployeesDAO;
    private static EmployeesDAO spyemployeesDAO;

    @BeforeAll
    static void setUpAll(){
        mockEmployeesDAO = Mockito.mock(EmployeesDAO.class);
    }
}
