package com.sparta.gwoc.userinterface;

import com.sparta.gwoc.dao.DAOInterface;
import com.sparta.gwoc.dao.EmployeesDAO;
import com.sparta.gwoc.dto.Employee;
import com.sparta.gwoc.dto.EmployeeFactory;

import java.util.List;

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
        if(rowsUpdated > 0){
            System.out.println("Employee with ID " + id + "deleted successfully.");
        }else{
            System.out.println("No employee found with ID" + id);
        }
        return rowsUpdated;
   }

   public int countTheNumberOfEmployees() {
        return 0;
   }


   public int insertEmployees(List <Employee> employeeList){
        int rowsUpdated = employeesDAO.insertEmployees(employeeList);
        if(rowsUpdated > 0){
            System.out.println("Employees inserted successfully.");
        }else{
            System.out.println("Failed to insert employees.");
        }

        return rowsUpdated;
   }

   public int updateFirstNameById(String id, String newFirstName){
        int rowsAffected =  employeesDAO.updateFirstNameById(id,newFirstName);

        if(rowsAffected > 0){
            System.out.println("Employee with ID " + id + "'s first name updated to " + newFirstName + ".");
        }else{
            System.out.println("No employee found with ID" + id);
        }

        return rowsAffected;
   }


    @Override
    public int countTheNumberOfEmployees() {
        return employeesDAO.countTheNumberOfEmployees();
    }

   public void loadValidatedEmployeeData() {
        List<Employee> employees =EmployeeFactory.getValidEmployees();
        insertEmployees(employees);
   }

}

