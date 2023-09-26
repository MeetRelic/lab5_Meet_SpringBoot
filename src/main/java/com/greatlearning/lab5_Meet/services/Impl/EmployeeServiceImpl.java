package com.greatlearning.lab5_Meet.services.Impl;

import com.greatlearning.lab5_Meet.models.Employee;
import com.greatlearning.lab5_Meet.repository.EmployeeRepository;
import com.greatlearning.lab5_Meet.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
       return employeeRepository.findAll();

    }

    @Override
    public Employee addEmployee(Employee employee) {
        if (employee != null) {
            Employee savedEmployee =employeeRepository.save(employee);
            return savedEmployee;
        }
        return employee;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> emOptional = employeeRepository.findById(id);
        if(emOptional.isPresent()) {
            return emOptional.get();
        }
        throw new RuntimeException("Employee don't exist with id " + id.toString());
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = getEmployeeById(id);
        log.info(" Edit Request Recieved for empId : {}" , employee.getId());
		existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

}
