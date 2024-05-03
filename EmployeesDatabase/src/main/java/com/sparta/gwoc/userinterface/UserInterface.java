package com.sparta.gwoc.userinterface;

import com.sparta.gwoc.dao.DAOInterface;
import com.sparta.gwoc.dao.EmployeesDAO;
import com.sparta.gwoc.dto.Employee;
import com.sparta.gwoc.utils.LoggerUtil;

import java.util.ArrayList;
import java.util.List;

import static com.sparta.gwoc.dto.EmployeeFactory.getValidEmployees;

public class UserInterface implements DAOInterface {

   private EmployeesDAO employeesDAO;


    public UserInterface(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    public void openDBConnection(){
        employeesDAO.openDBConnection();
    }

    public void closeDBConnection(){
        employeesDAO.closeDBConnection();
    }

    public List<Employee> getAllEmployeeRecords(){
       return employeesDAO.getAllEmployeeRecords();
    }

    public Employee getEmployeeRecordByID(String id) {
        return employeesDAO.getEmployeeRecordByID(id);
    }

   public int deleteEmployeeRecordByID(String id){
        int rowsUpdated =  employeesDAO.deleteEmployeeRecordByID(id);
        if(rowsUpdated == 0){
            LoggerUtil.info("Employee with ID " + id + "  " + "deleted successfully.");
        }else{
            LoggerUtil.info("No employee found with ID" + id);
        }
        return rowsUpdated;
   }


   public int insertEmployees(List <Employee> employeeList){
        int rowsUpdated = employeesDAO.insertEmployees(employeeList);
        if(rowsUpdated > 0){
            LoggerUtil.info("Employees inserted successfully.");
        }else{
           LoggerUtil.info("Failed to insert employees.");
        }

        return rowsUpdated;
   }
    public int loadEmployees() {
        ArrayList<Employee> validEmployees = getValidEmployees();
        int rowsUpdated = insertEmployees(validEmployees);
        return rowsUpdated;
    }

   public int updateFirstNameById(String id, String newFirstName){
        int rowsAffected =  employeesDAO.updateFirstNameById(id,newFirstName);

        if(rowsAffected > 0){
            LoggerUtil.info("Employee with ID " + id + "'s first name updated to " + newFirstName + ".");
        }else{
            LoggerUtil.info("No employee found with ID" + id);
        }

        return rowsAffected;
   }

}

