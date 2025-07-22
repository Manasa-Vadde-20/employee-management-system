package com.example.employee.repository;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Search by name (case-insensitive, partial match)
    List<Employee> findByNameContainingIgnoreCase(String name);

    // Search by email (case-insensitive, partial match)
    List<Employee> findByEmailContainingIgnoreCase(String email);

    // Search by department (case-insensitive, partial match)
    List<Employee> findByDepartmentContainingIgnoreCase(String department);
}