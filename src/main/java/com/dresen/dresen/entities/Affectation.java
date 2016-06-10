/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author Vivien Saa
 */
@Entity
@NamedQueries({
     @NamedQuery(name = "Affectation.findAllAffectationOpen", query = "SELECT a FROM Affectation a WHERE a.dateFinAffect=NULL"),
     @NamedQuery(name = "Affectation.findAffectationByIdAgent", query = "SELECT a FROM Affectation a WHERE a.agent.idAgent = :param"),
     @NamedQuery(name = "Affectation.findAffectationOpenByIdAgent", query = "SELECT a FROM Affectation a WHERE a.agent.idAgent = :param AND a.dateFinAffect=NULL")
}
)
public class Affectation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAffectation;
    
    @Column 
    private String numeroAffectation;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutAffect;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinAffect;
    
    @ManyToOne
    private Agentp agent;
    
    @ManyToOne
    private StructureAttache structure;

    public Affectation() {
    }
    

    public String getNumeroAffectation() {
        return numeroAffectation;
    }

    public void setNumeroAffectation(String numeroAffectation) {
        this.numeroAffectation = numeroAffectation;
    }

    public Date getDateDebutAffect() {
        return dateDebutAffect;
    }

    public void setDateDebutAffect(Date dateDebutAffect) {
        this.dateDebutAffect = dateDebutAffect;
    }

    public Date getDateFinAffect() {
        return dateFinAffect;
    }

    public void setDateFinAffect(Date dateFinAffect) {
        this.dateFinAffect = dateFinAffect;
    }
    
    

    public Long getIdAffectation() {
        return idAffectation;
    }

    public Agentp getAgent() {
        return agent;
    }

    public void setAgent(Agentp agent) {
        this.agent = agent;
    }

    public StructureAttache getStructure() {
        return structure;
    }

    public void setStructure(StructureAttache structure) {
        this.structure = structure;
    }
    
    

    /**
     *
     * @param idAffectation
     */
    public void setIdAffectation(Long idAffectation) {
        this.idAffectation = idAffectation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAffectation != null ? idAffectation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Affectation)) {
            return false;
        }
        Affectation other = (Affectation) object;
        return !((this.idAffectation == null && other.idAffectation != null) || (this.idAffectation != null && !this.idAffectation.equals(other.idAffectation)));
    }
    
}
