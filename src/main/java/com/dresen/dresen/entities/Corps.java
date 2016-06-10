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
public class Corps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCoprs;
    
    @Column (nullable = false, unique = true)
    private String intituleCorps;
    
    @OneToMany (mappedBy = "corps")
    private List<Cadre> listCadres;

    public Corps() {
    }

    public Corps(String intituleCorps) {
        this.intituleCorps = intituleCorps;
        this.listCadres = new ArrayList<Cadre>();
    }
    
    

    public Long getIdCoprs() {
        return idCoprs;
    }

    public void setIdCoprs(Long idCoprs) {
        this.idCoprs = idCoprs;
    }

    public String getIntituleCorps() {
        return intituleCorps;
    }

    public void setIntituleCorps(String intituleCorps) {
        this.intituleCorps = intituleCorps;
    }

    public List<Cadre> getListCadres() {
        return listCadres;
    }

    public void setListCadres(List<Cadre> listCadres) {
        this.listCadres = listCadres;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCoprs != null ? idCoprs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corps)) {
            return false;
        }
        Corps other = (Corps) object;
        if ((this.idCoprs == null && other.idCoprs != null) || (this.idCoprs != null && !this.idCoprs.equals(other.idCoprs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Corps[ id=" + idCoprs + " ]";
    }
    
}
