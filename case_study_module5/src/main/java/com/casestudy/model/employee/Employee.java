package com.casestudy.model.employee;
import com.casestudy.model.contract.Contract;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmployee;
    private String nameEmployee;
    private String dayEmployee;
    private String citizenEmployee;
    private double salaryEmployee;
    private String phoneEmployee;
    private String emailEmployee;
    private String addressEmployee;
    private int isDelete;

    @ManyToOne
    @JoinColumn(name = "id_position", referencedColumnName = "idPosition")
    @JsonBackReference
    private Position position;

    @ManyToOne
    @JoinColumn(name = "id_education", referencedColumnName = "idEducation")
    @JsonBackReference
    private Education education;

    @ManyToOne
    @JoinColumn(name = "id_workplace", referencedColumnName = "idWorkplace")
    @JsonBackReference
    private Workplace workplace;


    @OneToMany(mappedBy = "employee")
    @JsonManagedReference
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(long idEmployee, String nameEmployee, String dayEmployee, String citizenEmployee, double salaryEmployee, String phoneEmployee, String emailEmployee, String addressEmployee, Position position, Education education, Workplace workplace) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.dayEmployee = dayEmployee;
        this.citizenEmployee = citizenEmployee;
        this.salaryEmployee = salaryEmployee;
        this.phoneEmployee = phoneEmployee;
        this.emailEmployee = emailEmployee;
        this.addressEmployee = addressEmployee;
        this.position = position;
        this.education = education;
        this.workplace = workplace;
    }

    public long getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(long idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDayEmployee() {
        return dayEmployee;
    }

    public void setDayEmployee(String dayEmployee) {
        this.dayEmployee = dayEmployee;
    }

    public String getCitizenEmployee() {
        return citizenEmployee;
    }

    public void setCitizenEmployee(String citizenEmployee) {
        this.citizenEmployee = citizenEmployee;
    }

    public double getSalaryEmployee() {
        return salaryEmployee;
    }

    public void setSalaryEmployee(double wageEmployee) {
        this.salaryEmployee = wageEmployee;
    }

    public String getPhoneEmployee() {
        return phoneEmployee;
    }

    public void setPhoneEmployee(String phoneEmployee) {
        this.phoneEmployee = phoneEmployee;
    }

    public String getEmailEmployee() {
        return emailEmployee;
    }

    public void setEmailEmployee(String emailEmployee) {
        this.emailEmployee = emailEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Workplace getWorkplace() {
        return workplace;
    }

    public void setWorkplace(Workplace workplace) {
        this.workplace = workplace;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
