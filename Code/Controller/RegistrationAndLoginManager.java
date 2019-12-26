package bsuir.Controller;

import bsuir.Model.Employee;

import java.util.List;

public class RegistrationAndLoginManager {

    private FileManager _fileManager = new FileManager();

    public Employee LogIn(String email, String password)
    {
        return _fileManager.getEmployee(email,password);
    }

    private List<String> getEmployeeInfo()
    {
        return null;
    }

    private void Registration(){

    }

    private void createEmployee()
    {

    }

}
