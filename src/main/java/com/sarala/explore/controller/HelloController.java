package com.sarala.explore.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import com.sarala.explore.model.Employee;
import com.sarala.explore.service.CreateReport;
import com.sarala.explore.service.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;

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

    @RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
    public @ResponseBody void download(HttpServletResponse response) throws FileNotFoundException {
        CreateReport.createExcel();

        File file = new File("D:\\Temp\\delete\\sarala.xlsx");
        InputStream in = new FileInputStream(file);

        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
        response.setHeader("Content-Length", String.valueOf(file.length()));
        try {
            FileCopyUtils.copy(in, response.getOutputStream());
        } catch(Exception e) {

        }

    }





}
