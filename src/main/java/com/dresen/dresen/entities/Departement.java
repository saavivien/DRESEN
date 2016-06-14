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
public class Departement implements Serializable {

   // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false, unique = true)
    private String intituleDepartement;
    
    @OneToMany (mappedBy = "departement")
    private List<Arrondissement> listArrondissements;

    public Departement(String intituleDepartement) {
        this.intituleDepartement = intituleDepartement;
        this.listArrondissements = new ArrayList<Arrondissement>();
    }

    public Departement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    

    public String getIntituleDepartement() {
        return intituleDepartement;
    }

    public void setIntituleDepartement(String intituleDepartement) {
        this.intituleDepartement = intituleDepartement;
    }

    public List<Arrondissement> getListArrondissements() {
        return listArrondissements;
    }

    public void setListArrondissements(List<Arrondissement> listArrondissements) {
        this.listArrondissements = listArrondissements;
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
        if (!(object instanceof Departement)) {
            return false;
        }
        Departement other = (Departement) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Departement[ id=" + id + " ]";
    }
    
}
