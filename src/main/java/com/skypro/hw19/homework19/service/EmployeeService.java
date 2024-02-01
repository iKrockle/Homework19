package com.skypro.hw19.homework19.service;

import com.skypro.hw19.homework19.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> employees = new ArrayList<>();
    int maxEmployees = 1;

    String addEmployee(String firstName, String lastName);
    String delEmployee(String firstName, String lastName);
    String findEmployee(String firstName, String lastName);
}
