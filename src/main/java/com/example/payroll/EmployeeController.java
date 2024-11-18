package com.example.payroll;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //GET
    @GetMapping("/employees")
    List<Employee> all() {
        return employeeService.getAllEmployees();
    }

    //POST
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
        return employeeService.SaveEmployee(newEmployee);
    }

    //GET
    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    //PUT
    @PutMapping("/employees/{id}")
    Employee updateEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
        return employeeService.updateEmployee(id, newEmployee);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
