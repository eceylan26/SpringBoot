package com.ersin.springboot.thymeleafdemo.controller;

import com.ersin.springboot.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmplyoeeController {

    // load employee data
    private List<Employee> theEmployees;

    @PostConstruct
    private void loadData(){

        Employee empl1 = new Employee(1,"Ersin","CEYLAN","ersin@gmail.com");
        Employee empl2 = new Employee(2,"Ersin2","CEYLAN2","ersin2@gmail.com");
        Employee empl3 = new Employee(3,"Ersin3","CEYLAN3","ersin3@gmail.com");

        theEmployees=new ArrayList<>();
        theEmployees.add(empl1);
        theEmployees.add(empl2);
        theEmployees.add(empl3);

    }

    // add mapping for /list
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        theModel.addAttribute("employees",theEmployees);

        return "list-employees";

    }
}
