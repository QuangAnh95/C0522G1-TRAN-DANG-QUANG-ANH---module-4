package com.casestudy.model.facility;

import com.casestudy.model.contract.Contract;
import com.casestudy.model.customers.Customers;
import com.casestudy.model.employee.Position;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFacility;
    private String nameFacility;
    private int area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberOfFloors;
    private String facilityFree;
    private int isDelete;

    @ManyToOne
    @JoinColumn(name = "id_FacilityType", referencedColumnName = "idFacilityType")
    @JsonBackReference
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "id_RenType", referencedColumnName = "idRenType")
    @JsonBackReference
    private RenType renType;


    @OneToMany(mappedBy = "facility")
    @JsonManagedReference
    private Set<Contract> contracts;

    public Facility() {
    }

    public Facility(String nameFacility, int area, double cost, int maxPeople, String standardRoom, String description, double poolArea, int numberOfFloors, String facilityFree, FacilityType facilityType, RenType renType) {
        this.nameFacility = nameFacility;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.renType = renType;
    }

    public long getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(long idFacility) {
        this.idFacility = idFacility;
    }

    public String getNameFacility() {
        return nameFacility;
    }

    public void setNameFacility(String nameFacility) {
        this.nameFacility = nameFacility;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RenType getRenType() {
        return renType;
    }

    public void setRenType(RenType renType) {
        this.renType = renType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
