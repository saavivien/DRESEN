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
 * classe intermédiare entre les postes et les structure d'attache afin d'éviter le Many-To-Many
 */
@Entity
@NamedQueries({
     @NamedQuery(name = "Poste.findPosteByName", query = "SELECT p FROM Poste p WHERE p.intitulePoste = :Param")
})
public class Poste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false, unique = true)
    private String intitulePoste;
    
    @Column (nullable = false, unique = true)
    private String code;
    
    @OneToMany (mappedBy = "poste")
    private List<Promotion> listPromotions;
    
    @OneToMany(mappedBy = "poste")
    private List<PosteStructure> listPoste_Structures;
    
    public Poste() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    
    public List<Promotion> getListPromotions() {
        return listPromotions;
    }

    public void setListPromotions(List<Promotion> listPromotions) {
        this.listPromotions = listPromotions;
    }

    public List<PosteStructure> getListPoste_Structures() {
        return listPoste_Structures;
    }

    public void setListPoste_Structures(List<PosteStructure> listPoste_Structures) {
        this.listPoste_Structures = listPoste_Structures;
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
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        return !((this.id== null && other.id != null) || (this.id!= null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Poste{" + "intitule=" + intitulePoste + '}';
    }

  
    
}
