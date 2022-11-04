package com.casestudy.model.facility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFacilityType;
    private String nameFacilityType;

    @OneToMany(mappedBy = "facilityType")
    @JsonManagedReference
    private Set<Facility> facilities;

    public FacilityType() {
    }

    public FacilityType(String nameFacilityType, Set<Facility> facilities) {
        this.nameFacilityType = nameFacilityType;
        this.facilities = facilities;
    }

    public FacilityType(long idFacilityType, String nameFacilityType, Set<Facility> facilities) {
        this.idFacilityType = idFacilityType;
        this.nameFacilityType = nameFacilityType;
        this.facilities = facilities;
    }

    public long getIdFacilityType() {
        return idFacilityType;
    }

    public void setIdFacilityType(long idFacilityType) {
        this.idFacilityType = idFacilityType;
    }

    public String getNameFacilityType() {
        return nameFacilityType;
    }

    public void setNameFacilityType(String nameFacilityType) {
        this.nameFacilityType = nameFacilityType;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
