package com.example.employee.service;

import com.example.employee.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, Employee employeeDetails);
    void deleteEmployee(Long id);
    List<Employee> searchByName(String name);
    List<Employee> searchByEmail(String email);
    List<Employee> searchByDepartment(String department);
}
