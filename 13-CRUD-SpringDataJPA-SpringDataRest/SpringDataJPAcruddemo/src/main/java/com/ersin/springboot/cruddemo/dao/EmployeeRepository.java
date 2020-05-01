package com.ersin.springboot.cruddemo.dao;

import com.ersin.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    // ne need any method

}
