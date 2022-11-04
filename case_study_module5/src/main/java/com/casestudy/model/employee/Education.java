package com.casestudy.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEducation;
    private String nameEducation;

    @OneToMany(mappedBy = "education")
    @JsonManagedReference
    private Set<Employee> employees;

    public Education() {
    }

    public Education(String nameEducation, Set<Employee> employees) {
        this.nameEducation = nameEducation;
        this.employees = employees;
    }

    public Education(long idEducation, String nameEducation, Set<Employee> employees) {
        this.idEducation = idEducation;
        this.nameEducation = nameEducation;
        this.employees = employees;
    }

    public long getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(long idEducation) {
        this.idEducation = idEducation;
    }

    public String getNameEducation() {
        return nameEducation;
    }

    public void setNameEducation(String nameEducation) {
        this.nameEducation = nameEducation;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
