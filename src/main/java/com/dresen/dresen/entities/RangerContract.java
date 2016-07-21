/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Vivien Saa
 */
@Entity
@NamedQueries({
     @NamedQuery(name = "RangerContract.findAllRangerContractOpen", query = "SELECT rc FROM RangerContract rc WHERE rc.dateFinRangerContract = NULL"),
     @NamedQuery(name = "RangerContract.findRangerContractByIdAgent", query = "SELECT rc FROM RangerContract rc WHERE rc.contractuel.id = :param"),
     @NamedQuery(name = "RangerContract.findRangerContractOpenByIdAgent", query = "SELECT rc FROM RangerContract rc WHERE rc.contractuel.id = :param AND rc.dateFinRangerContract = NULL"),
     @NamedQuery(name = "RangerContract.findLastRangerContractByIdAgent", query = "SELECT rc FROM RangerContract rc WHERE rc.contractuel.id = :param AND rc.dateDebutRangerContract >= ALL(SELECT rc.dateDebutRangerContract FROM RangerContract rc WHERE rc.contractuel.id = :param)")       
})
public class RangerContract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutRangerContract;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinRangerContract;
    
    @ManyToOne
    private Contractuel contractuel;
    
    @ManyToOne
    private GradeContract gradeContract;   

    public RangerContract() {
    }

    public RangerContract(Date dateDebutRanger, Date dateFinRanger, Contractuel contratuel, GradeContract gradeContract) {
        this.dateDebutRangerContract = dateDebutRanger;
        this.dateFinRangerContract = dateFinRanger;
        this.contractuel = contratuel;
        this.gradeContract = gradeContract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebutRangerContract() {
        return dateDebutRangerContract;
    }

    public void setDateDebutRangerContract(Date dateDebutRangerContract) {
        this.dateDebutRangerContract = dateDebutRangerContract;
    }

    public Date getDateFinRangerContract() {
        return dateFinRangerContract;
    }

    public void setDateFinRangerContract(Date dateFinRangerContract) {
        this.dateFinRangerContract = dateFinRangerContract;
    }

    public Contractuel getContractuel() {
        return contractuel;
    }

    public void setContractuel(Contractuel contractuel) {
        this.contractuel = contractuel;
    }

    public Date getDateFinRanger() {
        return dateFinRangerContract;
    }

    public void setDateFinRanger(Date dateFinRanger) {
        this.dateFinRangerContract = dateFinRanger;
    }

    public Contractuel getContratuel() {
        return contractuel;
    }

    public void setContratuel(Contractuel contratuel) {
        this.contractuel = contratuel;
    }

    public GradeContract getGradeContract() {
        return gradeContract;
    }

    public void setGradeContract(GradeContract gradeContract) {
        this.gradeContract = gradeContract;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangerContract)) {
            return false;
        }
        RangerContract other = (RangerContract) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    
}
