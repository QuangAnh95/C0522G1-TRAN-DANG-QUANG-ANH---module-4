package com.casestudy.model.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Workplace {
    @Id
    @GeneratedValue
    private long idWorkplace;
    private String nameWorkplace;

    @OneToMany(mappedBy = "workplace")
    @JsonManagedReference
    private Set<Employee> employees;

    public Workplace() {
    }

    public Workplace(String nameWorkplace, Set<Employee> employees) {
        this.nameWorkplace = nameWorkplace;
        this.employees = employees;
    }

    public Workplace(long idWorkplace, String nameWorkplace, Set<Employee> employees) {
        this.idWorkplace = idWorkplace;
        this.nameWorkplace = nameWorkplace;
        this.employees = employees;
    }

    public long getIdWorkplace() {
        return idWorkplace;
    }

    public void setIdWorkplace(long idWorkplace) {
        this.idWorkplace = idWorkplace;
    }

    public String getNameWorkplace() {
        return nameWorkplace;
    }

    public void setNameWorkplace(String nameWorkplace) {
        this.nameWorkplace = nameWorkplace;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
