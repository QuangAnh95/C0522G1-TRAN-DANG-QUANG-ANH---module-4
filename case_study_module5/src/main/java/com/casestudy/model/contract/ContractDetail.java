package com.casestudy.model.contract;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idContractDetail;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "id_attachFacility", referencedColumnName = "idAttachFacility")
    @JsonBackReference
    private AttachFacility attachFacility;

    @ManyToOne
    @JoinColumn(name = "id_Contract", referencedColumnName = "idContract")
    @JsonBackReference
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(int quantity, AttachFacility attachFacility, Contract contract) {
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public ContractDetail(long idContractDetail, int quantity, AttachFacility attachFacility, Contract contract) {
        this.idContractDetail = idContractDetail;
        this.quantity = quantity;
        this.attachFacility = attachFacility;
        this.contract = contract;
    }

    public long getIdContractDetail() {
        return idContractDetail;
    }

    public void setIdContractDetail(long idContractDetail) {
        this.idContractDetail = idContractDetail;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
