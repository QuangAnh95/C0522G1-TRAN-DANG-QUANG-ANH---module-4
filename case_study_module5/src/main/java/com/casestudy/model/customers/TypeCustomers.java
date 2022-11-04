package com.casestudy.model.customers;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
public class TypeCustomers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTypeCustomer;
    private String nameTypeCustomer;

    @OneToMany(mappedBy = "typeCustomers")
    @JsonManagedReference
    private Set<Customers> customers;

    public TypeCustomers() {
    }

    public TypeCustomers(long idTypeCustomer, String nameTypeCustomer, Set<Customers> customers) {
        this.idTypeCustomer = idTypeCustomer;
        this.nameTypeCustomer = nameTypeCustomer;
        this.customers = customers;
    }

    public TypeCustomers(String nameTypeCustomer, Set<Customers> customers) {
        this.nameTypeCustomer = nameTypeCustomer;
        this.customers = customers;
    }

    public String getNameTypeCustomer() {
        return nameTypeCustomer;
    }

    public void setNameTypeCustomer(String nameTypeCustomer) {
        this.nameTypeCustomer = nameTypeCustomer;
    }

    public Set<Customers> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customers> customers) {
        this.customers = customers;
    }

    public long getIdTypeCustomer() {
        return idTypeCustomer;
    }

    public void setIdTypeCustomer(long idTypeCustomer) {
        this.idTypeCustomer = idTypeCustomer;
    }
}
