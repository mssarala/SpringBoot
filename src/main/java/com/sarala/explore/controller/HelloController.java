package com.sarala.explore.controller;

import java.util.List;

import com.sarala.explore.model.Employee;
import com.sarala.explore.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {


    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/hello")
    public String helloJspPage() {
        return ("hello");
    }

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView listAllEmployees() {
        ModelAndView  mv = new ModelAndView("employees");
        mv.setViewName("employees");

        List<Employee> employees = employeeRepository.findAll();
        mv.addObject("employees", employees);

        return mv;
    }

}
