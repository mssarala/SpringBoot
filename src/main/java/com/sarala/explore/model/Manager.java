package com.sarala.explore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Manager {

    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;

    @OneToMany(mappedBy = "manager")
    List<Employee> employees;

    private Manager() {

    }

    public Manager(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
