package com.learning.microservices.employee.service.app.service;

import com.learning.microservices.employee.service.app.model.Employee;
import com.learning.microservices.employee.service.app.dao.EmployeeDAO;
import com.learning.microservices.employee.service.app.response.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    public ResponseEntity<EmployeeResponse<List<Employee>>> getAllEmployees() {

        try {
            Optional<List<Employee>> allEmployeesList = Optional.of(employeeDAO.findAll());

            if (allEmployeesList.isPresent()) {
                return new ResponseEntity<>(new EmployeeResponse<>(allEmployeesList.get(), "Here is the list of all employees", HttpStatus.OK.value()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new EmployeeResponse<>(null, "No employees found", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new EmployeeResponse<>(null, "An error occured while trying to fetch list of all employees", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<EmployeeResponse<Employee>> getEmployeeById(int empId) {

        try {
            Optional<Employee> emp = Optional.ofNullable(employeeDAO.findEmployeeByEmpId(empId));

            if (emp.isPresent()) {
                return new ResponseEntity<>(new EmployeeResponse<>(emp.get(), "Employee found", HttpStatus.OK.value()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new EmployeeResponse<>(null, "Employee not found", HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new EmployeeResponse<>(null,"An error occurred when trying to search for the employee", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<String> insertOrUpdateEmployee(Employee employee) {

        try {
            employeeDAO.save(employee);
            return new ResponseEntity<>("Employee details saved successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("An error occurred while saving employee", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    public ResponseEntity<String> deleteEmployeeById(Integer empId) {

        try {
            employeeDAO.deleteById(empId);
            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("An error occured while deleting employee", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
