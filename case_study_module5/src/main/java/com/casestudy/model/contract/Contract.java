package com.casestudy.model.contract;

import com.casestudy.model.customers.Customers;
import com.casestudy.model.employee.Employee;
import com.casestudy.model.facility.Facility;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContract;
    private String startDate;
    private String endDate;
    private double deposit;
    private int isDelete;

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "idCustomer")
    @JsonBackReference
    private Customers customers;

    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "idEmployee")
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "id_facility", referencedColumnName = "idFacility")
    @JsonBackReference
    private Facility facility;

    public Contract() {
    }

    public Contract(String startDate, String endDate, double deposit, Set<ContractDetail> contractDetails, Customers customers, Employee employee, Facility facility) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.contractDetails = contractDetails;
        this.customers = customers;
        this.employee = employee;
        this.facility = facility;
    }

    public Contract(long idContract, String startDate, String endDate, double deposit, Set<ContractDetail> contractDetails, Customers customers, Employee employee, Facility facility) {
        this.idContract = idContract;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.contractDetails = contractDetails;
        this.customers = customers;
        this.employee = employee;
        this.facility = facility;
    }

    public long getIdContract() {
        return idContract;
    }

    public void setIdContract(long idContract) {
        this.idContract = idContract;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
