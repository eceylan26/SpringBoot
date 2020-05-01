package com.ersin.springboot.cruddemo.dao;

import com.ersin.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

}
