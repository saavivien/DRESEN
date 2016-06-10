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
public class StructureAttache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStructure;
    
    @Column (nullable = false, unique = true)
    private String intituleStructure;
    
    @ManyToOne
    private Arrondissement arrondissement;
    
    @OneToMany (mappedBy = "structure")
    private List<Affectation> listAffectation;
    
    @OneToMany(mappedBy = "Structure")
    private List<Poste_Structure> listPoste_Structures;


    public StructureAttache(String intituleStructure, Arrondissement arrondissement) {
        this.intituleStructure = intituleStructure;
        this.arrondissement = arrondissement;
        this.listAffectation = new ArrayList<Affectation>();
    }

    public StructureAttache() {
    }
      
    
    
    public Long getIdStructure() {
        return idStructure;
    }

    public void setId(Long idStructure) {
        this.idStructure = idStructure;
    }

    public String getIntituleStructure() {
        return intituleStructure;
    }

    public void setIntituleStructure(String intituleStructure) {
        this.intituleStructure = intituleStructure;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public List<Affectation> getListAffectation() {
        return listAffectation;
    }

    public void setListAffectation(List<Affectation> listAffectation) {
        this.listAffectation = listAffectation;
    }

    public List<Poste_Structure> getListPoste_Structures() {
        return listPoste_Structures;
    }

    public void setListPoste_Structures(List<Poste_Structure> listPoste_Structures) {
        this.listPoste_Structures = listPoste_Structures;
    }

    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStructure != null ? idStructure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StructureAttache)) {
            return false;
        }
        StructureAttache other = (StructureAttache) object;
        return !((this.idStructure == null && other.idStructure != null) || (this.idStructure != null && !this.idStructure.equals(other.idStructure)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Structure[ id=" + idStructure + " ]";
    }
    
}
