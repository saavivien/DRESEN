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
     @NamedQuery(name = "RangerContract.findRangerContractByIdAgent", query = "SELECT rc FROM RangerContract rc WHERE rc.contractuel.idAgent = :param"),
     @NamedQuery(name = "RangerContract.findRangerContractOpenByIdAgent", query = "SELECT rc FROM RangerContract rc WHERE rc.contractuel.idAgent = :param AND rc.dateFinRangerContract = NULL")
})
public class RangerContract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRangerContract;
    
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
    
    

    public Long getIdRangerContract() {
        return idRangerContract;
    }

    public void setIdRangerContract(Long idRangerContract) {
        this.idRangerContract = idRangerContract;
    }

    public Date getDateDebutRanger() {
        return dateDebutRangerContract;
    }

    public void setDateDebutRanger(Date dateDebutRanger) {
        this.dateDebutRangerContract = dateDebutRanger;
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
        hash += (idRangerContract != null ? idRangerContract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangerContract)) {
            return false;
        }
        RangerContract other = (RangerContract) object;
        return !((this.idRangerContract == null && other.idRangerContract != null) || (this.idRangerContract != null && !this.idRangerContract.equals(other.idRangerContract)));
    }

    
}
