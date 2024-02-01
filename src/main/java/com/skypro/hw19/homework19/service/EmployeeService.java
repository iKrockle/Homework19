package com.skypro.hw19.homework19.service;

import com.skypro.hw19.homework19.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> employees = new ArrayList<>();
    int maxEmployees = 2;

    Employee addEmployee(String firstName, String lastName);
    Employee delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
}
