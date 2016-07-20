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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
@NamedQueries({ 
    @NamedQuery(name = "Corps.findCorpsByIntitule", query = "SELECT c FROM Corps c WHERE c.intituleCorps = :param")
})
public class Corps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corps)) {
            return false;
        }
        Corps other = (Corps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return intituleCorps;
    }
    
}
