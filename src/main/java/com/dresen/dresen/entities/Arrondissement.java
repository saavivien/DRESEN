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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
public class Arrondissement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArrondissement;
    
    @Column (nullable = false, unique = true)
    private String intituleArrondissement;
    
    @ManyToOne
    private Departement departement;
    
    @OneToMany (mappedBy = "arrondissement")
    private List<StructureAttache> listStructures;

    public Arrondissement() {
    }


    public Arrondissement(String intituleArrondissement, Departement departement) {
        this.intituleArrondissement = intituleArrondissement;
        this.departement = departement;
        this.listStructures = new ArrayList<StructureAttache>();
    }
    

    
    
    
    public Long getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(Long idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public String getIntituleArrondissement() {
        return intituleArrondissement;
    }

    public void setIntituleArrondissement(String intituleArrondissement) {
        this.intituleArrondissement = intituleArrondissement;
    }

    
    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<StructureAttache> getListStructures() {
        return listStructures;
    }

    public void setListStructures(List<StructureAttache> listStructures) {
        this.listStructures = listStructures;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArrondissement != null ? idArrondissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arrondissement)) {
            return false;
        }
        Arrondissement other = (Arrondissement) object;
        return !((this.idArrondissement == null && other.idArrondissement != null) || (this.idArrondissement != null && !this.idArrondissement.equals(other.idArrondissement)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Arrondissement[ id=" + idArrondissement + " ]";
    }
    
}