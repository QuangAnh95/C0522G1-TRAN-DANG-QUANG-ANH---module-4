package com.casestudy.model.employee;

import com.casestudy.model.customers.Customers;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Position {
    @Id
    @GeneratedValue
    private long idPosition;
    private String namePosition;

    @OneToMany(mappedBy = "position")
    @JsonManagedReference
    private Set<Employee> employees;

    public Position() {
    }

    public Position(String namePosition, Set<Employee> employees) {
        this.namePosition = namePosition;
        this.employees = employees;
    }

    public Position(long idPosition, String namePosition, Set<Employee> employees) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.employees = employees;
    }

    public long getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(long idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
