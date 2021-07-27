package com.example.sampleproject.controller;

import com.example.sampleproject.entity.Employee;
import com.example.sampleproject.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/all", produces = "application/json")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public Employee getEmployeeById(@PathVariable("id") String id){
        return employeeService.getById(id);
    }
}
