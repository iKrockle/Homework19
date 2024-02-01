package com.skypro.hw19.homework19.controller;

import com.skypro.hw19.homework19.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam(required = false) String firstName
            ,@RequestParam(required = false) String lastName) {
        if (firstName==null||lastName==null){return "Укажите параметры firstName и lastName";}
        return employeeService.addEmployee(firstName,lastName);
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam(required = false) String firstName
            ,@RequestParam(required = false) String lastName) {
        if (firstName==null||lastName==null){return "Укажите параметры firstName и lastName";}
        return employeeService.delEmployee(firstName,lastName);
    }

    @GetMapping("/find")
    public String findEmployee(@RequestParam(required = false) String firstName
            ,@RequestParam(required = false) String lastName) {
        if (firstName==null||lastName==null){return "Укажите параметры firstName и lastName";}
        return employeeService.findEmployee(firstName,lastName);
    }
    @GetMapping("/all")
    public String getAll(){
        return "{\"employees\" : "+employeeService.employees+"}";
    }
}
