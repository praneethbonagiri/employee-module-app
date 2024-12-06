package com.learning.microservices.employee.service.app.controller;

import com.learning.microservices.employee.service.app.model.Employee;
import com.learning.microservices.employee.service.app.response.EmployeeResponse;
import com.learning.microservices.employee.service.app.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/employees")
    public ResponseEntity<EmployeeResponse<List<Employee>>> getEmployees() {
        return empService.getAllEmployees();
    }

    @GetMapping("/employee/{empId}")
    public ResponseEntity<EmployeeResponse<Employee>> getEmployeeById(@PathVariable("empId") Integer empId) {
        return empService.getEmployeeById(empId);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        return empService.insertOrUpdateEmployee(employee);
    }

    @DeleteMapping("deleteEmployee/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("empId") Integer empId) {
        return empService.deleteEmployeeById(empId);
    }
    
}
