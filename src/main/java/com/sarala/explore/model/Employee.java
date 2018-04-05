package com.sarala.explore.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    Long id;

    String firstName;
    String lastName;
    String role;

    @ManyToOne
    Manager manager;

    private Employee() {

    }
    public Employee(String firstName, String lastName, String role, Manager manager) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}