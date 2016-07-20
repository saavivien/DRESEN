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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
@NamedQueries({ 
    @NamedQuery(name = "Specialite.findSpecialiteByIntitule", query = "SELECT s FROM Specialite s WHERE s.intituleSpecialite = :param")
})
public class Specialite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false, unique = true)
    private String intituleSpecialite;
    
    @OneToMany (mappedBy = "specialite")
    private List<Agentp> listAgentps;

    public Specialite() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getIntituleSpecialite() {
        return intituleSpecialite;
    }

    public void setIntituleSpecialite(String intituleSpecialite) {
        this.intituleSpecialite = intituleSpecialite;
    }

    public List<Agentp> getListAgentps() {
        return listAgentps;
    }

    public void setListAgentps(List<Agentp> listAgentps) {
        this.listAgentps = listAgentps;
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
        if (!(object instanceof Specialite)) {
            return false;
        }
        Specialite other = (Specialite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Specialite[ id=" + id + " ]";
    }
    
}
