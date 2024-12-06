package com.learning.microservices.employee.service.app.dao;

import com.learning.microservices.employee.service.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    Employee findEmployeeByEmpId(int empId);
    
}
