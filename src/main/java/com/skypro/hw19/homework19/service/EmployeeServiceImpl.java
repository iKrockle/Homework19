package com.skypro.hw19.homework19.service;

import com.skypro.hw19.homework19.Employee;
import com.skypro.hw19.homework19.exception.EmployeeAlreadyAddedException;
import com.skypro.hw19.homework19.exception.EmployeeNotFoundException;
import com.skypro.hw19.homework19.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (employees.contains(employee)){
                throw new EmployeeAlreadyAddedException("Сотрудник уже существует");
        }

        if (employees.size()==maxEmployees){
            throw new EmployeeStorageIsFullException("Штат уже полон");
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee delEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName,lastName);
        if (!employees.contains(employee)){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

        if (employees.contains(employee)) {
            return employee;
        }
        return null;
    }
}
