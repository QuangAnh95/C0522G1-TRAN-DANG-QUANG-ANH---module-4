package com.casestudy.model.facility;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.*;
import java.util.Set;

@Entity
public class RenType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRenType;
    private String nameRenType;

    @OneToMany(mappedBy = "renType")
    @JsonManagedReference
    private Set<Facility> facilities;

    public RenType() {
    }

    public RenType(String nameRenType, Set<Facility> facilities) {
        this.nameRenType = nameRenType;
        this.facilities = facilities;
    }

    public RenType(long idRenType, String nameRenType, Set<Facility> facilities) {
        this.idRenType = idRenType;
        this.nameRenType = nameRenType;
        this.facilities = facilities;
    }

    public long getIdRenType() {
        return idRenType;
    }

    public void setIdRenType(long idRenType) {
        this.idRenType = idRenType;
    }

    public String getNameRenType() {
        return nameRenType;
    }

    public void setNameRenType(String nameRenType) {
        this.nameRenType = nameRenType;
    }

    public Set<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(Set<Facility> facilities) {
        this.facilities = facilities;
    }
}
