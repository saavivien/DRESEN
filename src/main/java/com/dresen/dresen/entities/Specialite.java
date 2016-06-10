/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
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
public class Specialite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSpecialite;
    
    @Column (nullable = false, unique = true)
    private String intituleSpecialite;
    
    @OneToMany (mappedBy = "specialite")
    private List<Fonctionnaire> listFonctionnaires;

    public Specialite() {
    }
    
    

    public Long getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(Long idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public String getIntituleSpecialite() {
        return intituleSpecialite;
    }

    public void setIntituleSpecialite(String intituleSpecialite) {
        this.intituleSpecialite = intituleSpecialite;
    }

    public List<Fonctionnaire> getListFonctionnaires() {
        return listFonctionnaires;
    }

    public void setListFonctionnaires(List<Fonctionnaire> listFonctionnaires) {
        this.listFonctionnaires = listFonctionnaires;
    }
    
    

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSpecialite != null ? idSpecialite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Specialite)) {
            return false;
        }
        Specialite other = (Specialite) object;
        if ((this.idSpecialite == null && other.idSpecialite != null) || (this.idSpecialite != null && !this.idSpecialite.equals(other.idSpecialite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Specialite[ id=" + idSpecialite + " ]";
    }
    
}
