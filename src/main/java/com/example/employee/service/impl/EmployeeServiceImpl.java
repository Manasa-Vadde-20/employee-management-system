package com.example.employee.service.impl;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Save employee
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all employees
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee by ID
    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    // Update employee
    @Override
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee employee = getEmployeeById(id);
        employee.setName(employeeDetails.getName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        return employeeRepository.save(employee);
    }

    // Delete employee
    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // Search by name
    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    // Search by email
    @Override
    public List<Employee> searchByEmail(String email) {
        return employeeRepository.findByEmailContainingIgnoreCase(email);
    }

    // Search by department
    @Override
    public List<Employee> searchByDepartment(String department) {
        return employeeRepository.findByDepartmentContainingIgnoreCase(department);
    }
}
