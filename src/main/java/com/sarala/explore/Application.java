package com.sarala.explore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.sarala.explore.model.Employee;
import com.sarala.explore.model.Manager;
import com.sarala.explore.service.EmployeeRepository;
import com.sarala.explore.service.ManagerRepository;

import java.util.Arrays;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initData(EmployeeRepository employeeRepository, ManagerRepository managerRepository) {
        return  args -> {
            Manager manager = managerRepository.save(new Manager("Sarala", "Ramesh"));
            employeeRepository.save(new Employee("Janani", "Ramesh", "Pianoist", manager));
            employeeRepository.save(new Employee("Ranjani", "Ramesh", "Artist", manager));
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}