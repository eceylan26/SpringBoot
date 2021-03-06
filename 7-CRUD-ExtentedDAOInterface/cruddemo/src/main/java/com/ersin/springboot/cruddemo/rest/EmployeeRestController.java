package com.ersin.springboot.cruddemo.rest;

import com.ersin.springboot.cruddemo.dao.EmployeeDAO;
import com.ersin.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    // quick inject employee dao using cons. injection
    @Autowired
    public EmployeeRestController(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }













}
