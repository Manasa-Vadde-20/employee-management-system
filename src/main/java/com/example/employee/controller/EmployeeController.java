package com.example.employee.controller;

import com.example.employee.model.Employee;
import com.example.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // Create with Validation
    @PostMapping
    public ResponseEntity<?> addEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    // Read All
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // 🔍 Search by Name
    @GetMapping("/search/name")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }

    // 🔍 Search by Email
    @GetMapping("/search/email")
    public List<Employee> searchByEmail(@RequestParam String email) {
        return employeeService.searchByEmail(email);
    }

    // 🔍 Search by Department
    @GetMapping("/search/department")
    public List<Employee> searchByDepartment(@RequestParam String department) {
        return employeeService.searchByDepartment(department);
    }

    // Read One by ID (⚠️ Must come after /search/... mappings)
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // Update with Validation
    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employeeDetails, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errors.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(employeeService.updateEmployee(id, employeeDetails));
    }

    // Delete
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
