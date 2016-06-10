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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 * classe intermédiare entre les postes et les structure d'attache afin d'éviter le Many-To-Many
 */
@Entity
//@NamedQueries({
//     @NamedQuery(name = "Poste.findPosteByStructure", query = "SELECT p FROM Poste p, poste_StructureAttache s JOIN s.listPostes s_p WHERE s_p.idPoste=:Param")
//})
public class Poste implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPoste;
    
    @Column (nullable = false, unique = true)
    private String intitulePoste;
    
    @OneToMany (mappedBy = "poste")
    private List<Promotion> listPromotions;
    
    @OneToMany(mappedBy = "poste")
    private List<Poste_Structure> listPoste_Structures;
    
    public Poste() {
    }

    /**
     *
     * @param intitule
     */
    public Poste(String intitule) {
        this.intitulePoste = intitule;
    }
    
    
    

    public Long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(Long idPoste) {
        this.idPoste = idPoste;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitule(String intitule) {
        this.intitulePoste = intitule;
    }

    
    public List<Promotion> getListPromotions() {
        return listPromotions;
    }

    public void setListPromotions(List<Promotion> listPromotions) {
        this.listPromotions = listPromotions;
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
        hash += (idPoste != null ? idPoste.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poste)) {
            return false;
        }
        Poste other = (Poste) object;
        return !((this.idPoste == null && other.idPoste != null) || (this.idPoste != null && !this.idPoste.equals(other.idPoste)));
    }

    @Override
    public String toString() {
        return "Poste{" + "intitule=" + intitulePoste + '}';
    }

  
    
}
