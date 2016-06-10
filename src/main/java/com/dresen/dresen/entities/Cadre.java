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
public class Cadre implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCadre;
    
    @Column (nullable = false, unique = true)
    private String intituleCadre;
    
    @OneToMany (mappedBy = "cadre")
    private List<GradeFonctio> listGradeFonctios;
    
    @ManyToOne
    private Corps corps;

    public Cadre() {
    }

    public Cadre(String intituleCadre, Corps corps) {
        this.intituleCadre = intituleCadre;
        this.listGradeFonctios = new ArrayList<GradeFonctio>();
        this.corps = corps;
    }
    
    

    public String getIntituleCadre() {
        return intituleCadre;
    }

    public void setIntituleCadre(String intituleCadre) {
        this.intituleCadre = intituleCadre;
    }
    

    public Long getIdCadre() {
        return idCadre;
    }

    public void setId(Long idCadre) {
        this.idCadre = idCadre;
    }

    public List<GradeFonctio> getListGradeFonctio() {
        return listGradeFonctios;
    }

    public void setListGradeFonctio(List<GradeFonctio> listGradeFonctio) {
        this.listGradeFonctios = listGradeFonctio;
    }

    public Corps getCorps() {
        return corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }
    
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCadre != null ? idCadre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadre)) {
            return false;
        }
        Cadre other = (Cadre) object;
        return !((this.idCadre == null && other.idCadre != null) || (this.idCadre != null && !this.idCadre.equals(other.idCadre)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Cadre[ id=" + idCadre + " ]";
    }
    
}
