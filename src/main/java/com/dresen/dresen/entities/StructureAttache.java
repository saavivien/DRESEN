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
    private Long id;
    
    @Column (nullable = false, unique = true)
    private String intituleStructure;
    
    @ManyToOne
    private Arrondissement arrondissement;
    
    @ManyToOne
    private CategorieStructure categorieStructure;
    
    @OneToMany (mappedBy = "structureAttache")
    private List<Affectation> listAffectation;
   

    public StructureAttache(String intituleStructure, Arrondissement arrondissement) {
        this.intituleStructure = intituleStructure;
        this.arrondissement = arrondissement;
        this.listAffectation = new ArrayList<Affectation>();
    }

    public StructureAttache() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CategorieStructure getCategorieStructure() {
        return categorieStructure;
    }

    public void setCategorieStructure(CategorieStructure categorieStructure) {
        this.categorieStructure = categorieStructure;
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
        if (!(object instanceof StructureAttache)) {
            return false;
        }
        StructureAttache other = (StructureAttache) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Structure[ id=" + id + " ]";
    }
    
}
