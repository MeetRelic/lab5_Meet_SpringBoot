package com.greatlearning.lab5_Meet.services;

import com.greatlearning.lab5_Meet.models.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Employee addEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployeeById(Long id);
}
