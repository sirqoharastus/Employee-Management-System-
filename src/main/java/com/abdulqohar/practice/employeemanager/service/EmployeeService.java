package com.abdulqohar.practice.employeemanager.service;

import com.abdulqohar.practice.employeemanager.domain.Employee;
import com.abdulqohar.practice.employeemanager.exception.EmployeeNotFoundException;
import com.abdulqohar.practice.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {
     private EmployeeRepository employeeRepository;

     @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) throws IOException {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
         return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
         return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long id) {
         employeeRepository.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
         return employeeRepository.findEmployeeById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee with id" + id + "not found"));
    }
}
