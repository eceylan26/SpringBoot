package com.ersin.springboot.cruddemo.rest;

import com.ersin.springboot.cruddemo.dao.EmployeeDAO;
import com.ersin.springboot.cruddemo.entity.Employee;
import com.ersin.springboot.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick inject employee dao using cons. injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee!=null){
            return employee;
        }
        else
            throw new RuntimeException("Employee id not found ! " + employeeId);
    }

    //add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... intead of update

        theEmployee.setId(0);
        employeeService.save(theEmployee);

        return theEmployee;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeService.save(employee);

        return employee;
    }










}
