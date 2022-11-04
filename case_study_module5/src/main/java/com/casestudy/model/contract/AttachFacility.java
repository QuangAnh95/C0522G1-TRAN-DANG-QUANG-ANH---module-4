package com.casestudy.model.contract;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAttachFacility;
    private String nameAttachFacility;
    private double cost;
    private String unit;
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    @JsonManagedReference
    private Set<ContractDetail> contractDetails;

    public AttachFacility() {
    }

    public AttachFacility(String nameAttachFacility, double cost, String unit, String status, Set<ContractDetail> contractDetails) {
        this.nameAttachFacility = nameAttachFacility;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public AttachFacility(long idAttachFacility, String nameAttachFacility, double cost, String unit, String status, Set<ContractDetail> contractDetails) {
        this.idAttachFacility = idAttachFacility;
        this.nameAttachFacility = nameAttachFacility;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public long getIdAttachFacility() {
        return idAttachFacility;
    }

    public void setIdAttachFacility(long idAttachFacility) {
        this.idAttachFacility = idAttachFacility;
    }

    public String getNameAttachFacility() {
        return nameAttachFacility;
    }

    public void setNameAttachFacility(String nameAttachFacility) {
        this.nameAttachFacility = nameAttachFacility;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
