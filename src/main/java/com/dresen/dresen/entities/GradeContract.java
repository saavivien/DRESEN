/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
public class GradeContract implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGradeContract;
    
    @Column (nullable = false, unique = true)
    private String intituleGradeContract;
    
    @Column
    private int retraite;

    public GradeContract() {
    }

    public GradeContract(String intituleGradeContract, int retraite) {
        this.intituleGradeContract = intituleGradeContract;
        this.listRangerContracts = new ArrayList<RangerContract>();
        this.retraite = retraite;
    }
    
    
    
    @OneToMany (mappedBy = "gradeContract")
    private List<RangerContract> listRangerContracts;

    public Long getIdGradeContract() {
        return idGradeContract;
    }

    public void setIdGradeContract(Long idGradeContract) {
        this.idGradeContract = idGradeContract;
    }

    public List<RangerContract> getListRangerContracts() {
        return listRangerContracts;
    }

    public void setListRangerContracts(List<RangerContract> listRangerContracts) {
        this.listRangerContracts = listRangerContracts;
    }

    public String getIntituleGradeContract() {
        return intituleGradeContract;
    }

    public void setIntituleGradeContract(String intituleGradeContract) {
        this.intituleGradeContract = intituleGradeContract;
    }

    public int getRetraite() {
        return retraite;
    }

    public void setRetraite(int retraite) {
        this.retraite = retraite;
    }

    
    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGradeContract != null ? idGradeContract.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradeContract)) {
            return false;
        }
        GradeContract other = (GradeContract) object;
        return !((this.idGradeContract == null && other.idGradeContract != null) || (this.idGradeContract != null && !this.idGradeContract.equals(other.idGradeContract)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.GradeContract[ id=" + idGradeContract + " ]";
    }
    
}
