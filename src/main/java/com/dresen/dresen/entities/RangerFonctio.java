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
     @NamedQuery(name = "RangerFonctio.findAllRangerFonctioOpen", query = "SELECT rf FROM RangerFonctio rf WHERE rf.dateFinRangerFonctio = NULL"),
     @NamedQuery(name = "RangerFonctio.findRangerFonctioByIdAgent", query = "SELECT rf FROM RangerFonctio rf WHERE rf.fonctionnaire.idAgent = :param"),
     @NamedQuery(name = "RangerFonctio.findRangerFonctioOpenByIdAgent", query = "SELECT rf FROM RangerFonctio rf WHERE rf.fonctionnaire.idAgent = :param AND rf.dateFinRangerFonctio = NULL")
})
public class RangerFonctio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRangerFonctio;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutRangerFonctio;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinRangerFonctio;
    
    @ManyToOne
    private Fonctionnaire fonctionnaire;
    
    @ManyToOne
    private GradeFonctio gradeFonctio;   

    public RangerFonctio() {
    }
    public Long getIdRangerFonctio() {
        return idRangerFonctio;
    }

    public RangerFonctio(Date dateDebutRangerFonctio, Date dateFinRangerFonctio, Fonctionnaire fonctionnaire, GradeFonctio gradeFonctio) {
        this.dateDebutRangerFonctio = dateDebutRangerFonctio;
        this.dateFinRangerFonctio = dateFinRangerFonctio;
        this.fonctionnaire = fonctionnaire;
        this.gradeFonctio = gradeFonctio;
    }

    
    
    public void setIdRangerFonctio(Long idRangerFonctio) {
        this.idRangerFonctio = idRangerFonctio;
    }

    public Date getDateDebutRangerFonctio() {
        return dateDebutRangerFonctio;
    }

    public void setDateDebutRangerFonctio(Date dateDebutRangerFonctio) {
        this.dateDebutRangerFonctio = dateDebutRangerFonctio;
    }

    public Date getDateFinRangerFonctio() {
        return dateFinRangerFonctio;
    }

    public void setDateFinRangerFonctio(Date dateFinRangerFonctio) {
        this.dateFinRangerFonctio = dateFinRangerFonctio;
    }

    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(Fonctionnaire fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public GradeFonctio getGradeFonctio() {
        return gradeFonctio;
    }

    public void setGradeFonctio(GradeFonctio gradeFonctio) {
        this.gradeFonctio = gradeFonctio;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRangerFonctio != null ? idRangerFonctio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RangerFonctio)) {
            return false;
        }
        RangerFonctio other = (RangerFonctio) object;
        return !((this.idRangerFonctio == null && other.idRangerFonctio != null) || (this.idRangerFonctio != null && !this.idRangerFonctio.equals(other.idRangerFonctio)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.RangerFonction[ id=" + idRangerFonctio + " ]";
    }
    
}
