/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
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
     @NamedQuery(name = "Promotion.findAllPromotionOpen", query = "SELECT p FROM Promotion p WHERE p.dateFinPromo = NULL"),
     @NamedQuery(name = "Promotion.findPromotionByIdAgent", query = "SELECT p FROM Promotion p WHERE p.agent.id = :param"),
     @NamedQuery(name = "Promotion.findPromotionOpenByIdAgent", query = "SELECT p FROM Promotion p WHERE p.agent.id = :param AND p.dateFinPromo= NULL")
})
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String numeroPromotion;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutPromo;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinPromo;
    
    @ManyToOne
    private Agentp agent;
    
    @ManyToOne
    private Poste poste;

    public Promotion(String numeroPromotion, Date dateDebutPromo, Date dateFinPromo, Agentp agent, Poste poste) {
        this.numeroPromotion = numeroPromotion;
        this.dateDebutPromo = dateDebutPromo;
        this.dateFinPromo = dateFinPromo;
        this.agent = agent;
        this.poste = poste;
    }

    public Promotion() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    


    public String getNumeroPromotion() {
        return numeroPromotion;
    }

    public void setNumeroPromotion(String numeroPromotion) {
        this.numeroPromotion = numeroPromotion;
    }

    public Date getDateDebutPromo() {
        return dateDebutPromo;
    }

    public void setDateDebutPromo(Date dateDebutPromo) {
        this.dateDebutPromo = dateDebutPromo;
    }

    public Date getDateFinPromo() {
        return dateFinPromo;
    }

    public void setDateFinPromo(Date dateFinPromo) {
        this.dateFinPromo = dateFinPromo;
    }

    public Agentp getAgent() {
        return agent;
    }

    public void setAgent(Agentp agent) {
        this.agent = agent;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
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
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Promotion[ id=" + id + " ]";
    }
    
}
