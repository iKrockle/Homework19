package com.skypro.hw19.homework19.service;

import com.skypro.hw19.homework19.Employee;
import com.skypro.hw19.homework19.EmployeeAlreadyAddedException;
import com.skypro.hw19.homework19.EmployeeNotFoundException;
import com.skypro.hw19.homework19.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        try{
            checkDouble(employee);
            checkSize();
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            return e.getMessage();
        }
        employees.add(employee);
        return employee.toString();
    }

    @Override
    public String delEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        try{
            checkNotFound(employee);
        }catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        employees.remove(employee);
        return employee.toString();
    }

    @Override
    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        try{
            checkNotFound(employee);
        }catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
        for (Employee employee_r:employees) {
            if (employee_r.equals(employee)) {
                return employee.toString();
            }
        }
        return null;
    }

    static void checkSize() throws EmployeeStorageIsFullException {
        if (employees.size()==maxEmployees){
            throw new EmployeeStorageIsFullException("Штат уже полон");
        }
    }

    void checkDouble(Employee employee) throws EmployeeAlreadyAddedException {
        for (Employee employee_r:employees){
            if (employee_r.equals(employee)){
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
            }
        }
    }

    static void checkNotFound(Employee employee) throws EmployeeNotFoundException {
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
}
