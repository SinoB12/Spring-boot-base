package com.example.sampleproject.service;

import com.example.sampleproject.entity.Employee;

import java.util.List;

public interface EmployeeService {

    int create(Employee employee);

    List<Employee> getAll();

    Employee getById(String id);

    Long countAll();

    Employee getByEmail(String email);

    void registerNewEmployeeAfterLoginSuccess(String email, String name);
}
