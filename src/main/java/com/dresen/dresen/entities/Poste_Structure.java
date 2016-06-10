/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Vivien Saa
 */
@Entity
public class Poste_Structure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPoste_Structure;
    @ManyToOne
    private Poste poste;
    
    @ManyToOne
    private StructureAttache structureAttache;

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public StructureAttache getStructureAttache() {
        return structureAttache;
    }

    public void setStructureAttache(StructureAttache structureAttache) {
        this.structureAttache = structureAttache;
    }

    public Poste_Structure() {
    }
    
    

    public Long getId() {
        return idPoste_Structure;
    }

    public void setIdPoste_Structure(Long idPoste_Structure) {
        this.idPoste_Structure = idPoste_Structure;
    }

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poste_Structure)) {
            return false;
        }
        Poste_Structure other = (Poste_Structure) object;
        if ((this.idPoste_Structure == null && other.idPoste_Structure != null) || (this.idPoste_Structure != null && !this.idPoste_Structure.equals(other.idPoste_Structure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.entities.Poste_Structure[ idPoste_Structure=" + idPoste_Structure + " ]";
    }
    
}
