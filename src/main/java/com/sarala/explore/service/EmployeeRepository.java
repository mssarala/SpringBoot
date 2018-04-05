package com.sarala.explore.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import com.sarala.explore.model.Employee;

import java.util.List;


@RepositoryRestResource
public interface  EmployeeRepository extends CrudRepository<Employee, Long > {
    List<Employee> findByLastName(@Param("lastName") String name);
    List<Employee> findByRole(@Param("role") String name);
    List<Employee> findAll();
}

