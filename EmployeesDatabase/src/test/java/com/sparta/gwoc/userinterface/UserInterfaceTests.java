package com.sparta.gwoc.userinterface;

import com.sparta.gwoc.dto.Employee;
import com.sparta.gwoc.userinterface.UserInterface;
import com.sparta.gwoc.dao.EmployeesDAO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserInterfaceTests {
    private static EmployeesDAO mockEmployeesDAO;
    private static UserInterface userInterface;

    @Before
    public void setUp() {
        mockEmployeesDAO = Mockito.mock(EmployeesDAO.class);
        userInterface = new UserInterface(mockEmployeesDAO);
    }

    @Test
    public void testDeleteEmployeeRecordsById() {
        when(mockEmployeesDAO.deleteEmployeeRecordByID("2376")).thenReturn(1);

        int result = userInterface.deleteEmployeeRecordByID("2376");

        assertEquals(1, result);
    }

  @org.junit.jupiter.api.Test
  @DisplayName("testDeleteEmployeeRecordsByIdFail")
  void testDeleteEmployeeRecordsByIdFail() {

      when(mockEmployeesDAO.deleteEmployeeRecordByID("2376")).thenReturn(0);
      int result = userInterface.deleteEmployeeRecordByID("2376");

      assertEquals(0, result);

  }



  @org.junit.jupiter.api.Test
  @DisplayName("check insert employees returns records added")
  void checkInsertEmployeesReturnsRecordsAdded() {
      List<Employee> employeeList = new ArrayList<>();
      when(mockEmployeesDAO.insertEmployees(employeeList)).thenReturn(employeeList.size());

      int result = userInterface.insertEmployees(employeeList);

      assertEquals(employeeList.size(), result);


  }
   
   @org.junit.jupiter.api.Test
   @DisplayName("check update first name by id returns num of rows updated")
   void checkUpdateFirstNameByIdReturnsNumOfRowsUpdated() {
     String ID = "234554";
     String newFirstName = "Selam";
     int rowsAffected = 1;
       when(mockEmployeesDAO.updateFirstNameById(ID, newFirstName)).thenReturn(rowsAffected);
       int actualRowsAffected = userInterface.updateFirstNameById(ID, newFirstName);
       assertEquals(rowsAffected, actualRowsAffected);

   }

 
 @org.junit.jupiter.api.Test
 @DisplayName("check get all employee records returns employee records  ")
 void checkGetAllEmployeeRecordsReturnsEmployeeRecords() {
     List<Employee> expectedEmployees = new ArrayList<>();

     expectedEmployees.add(new Employee("23456", "ms", "Selam", 'K', "Ararsa", 'f', "selamkedir@icloud.com", LocalDate.now(), LocalDate.of(2023, 10, 10), 5000));
     when(mockEmployeesDAO.getAllEmployeeRecords()).thenReturn(expectedEmployees);

     List<Employee> actualEmployees = userInterface.getAllEmployeeRecords();


     assertEquals(expectedEmployees, actualEmployees);

 }

}
