package com.example.sampleproject.service.impl;

import com.example.sampleproject.entity.Employee;
import com.example.sampleproject.repository.EmployeeRepository;
import com.example.sampleproject.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public int create(Employee employee) {
        return employeeRepository.insert(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(String id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Long countAll() {
        return employeeRepository.countAll();
    }

    @Override
    public Employee getByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public void registerNewEmployeeAfterLoginSuccess(String email, String name) {
        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setEmpName(name);
        create(employee);
    }
}
