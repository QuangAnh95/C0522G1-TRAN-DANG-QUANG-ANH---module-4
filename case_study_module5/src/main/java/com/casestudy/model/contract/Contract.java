package com.casestudy.model.contract;

import com.casestudy.model.customers.Customers;
import com.casestudy.model.customers.TypeCustomers;
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

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;


}
