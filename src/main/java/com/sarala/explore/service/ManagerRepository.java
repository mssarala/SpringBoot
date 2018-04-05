package com.sarala.explore.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.repository.query.Param;
import com.sarala.explore.model.Manager;

import java.util.List;


@RepositoryRestResource
public interface  ManagerRepository extends CrudRepository<Manager, Long > {
    List<Manager> findByEmployeesRoleContains(@Param("role") String name);
    List<Manager> findDistinctByEmployeesRole(@Param("role") String name);
}