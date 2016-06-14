/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Vivien Saa
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Agentp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    @Column(unique = true)
    private String matricule;
    
    @Column
    private String nom;
    
    @Column
    private String prenom;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateEntreFonctionPub;
    
    @Column
    private Sexe sexe;
    
    @Column
    private String regionOrigine;
    
    @Column
    private String departementOrigine;
    
    @Column
    private String arrondissementOrigine;
    
    @Column
    private String nomJeuneFille;
    
    @OneToMany (mappedBy = "agent")
    private List<Affectation> listAffectations;
    
    @OneToMany (mappedBy = "agent")
    private List<Promotion> listPromotions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
    


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateEntreFonctionPub() {
        return dateEntreFonctionPub;
    }

    public void setDateEntreFonctionPub(Date dateEntreFonctionPub) {
        this.dateEntreFonctionPub = dateEntreFonctionPub;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getRegionOrigine() {
        return regionOrigine;
    }

    public void setRegionOrigine(String regionOrigine) {
        this.regionOrigine = regionOrigine;
    }

    public String getDepartementOrigine() {
        return departementOrigine;
    }

    public void setDepartementOrigine(String departementOrigine) {
        this.departementOrigine = departementOrigine;
    }

    public String getArrondissementOrigine() {
        return arrondissementOrigine;
    }

    public void setArrondissementOrigine(String arrondissementOrigine) {
        this.arrondissementOrigine = arrondissementOrigine;
    }

    public String getNomJeuneFille() {
        return nomJeuneFille;
    }

    public void setNomJeuneFille(String nomJeuneFille) {
        this.nomJeuneFille = nomJeuneFille;
    }

    public List<Affectation> getListAffectations() {
        return listAffectations;
    }

    public void setListAffectations(List<Affectation> listAffectations) {
        this.listAffectations = listAffectations;
    }

    public List<Promotion> getListPromotions() {
        return listPromotions;
    }

    public void setListPromotions(List<Promotion> listPromotions) {
        this.listPromotions = listPromotions;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agentp other = (Agentp) obj;
        return !(this.id != other.id && (this.id == null || !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Agent{" + "idAgent=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", dateEntreFonctionPub=" + dateEntreFonctionPub + ", sexe=" + sexe + ", nomJeuneFille=" + nomJeuneFille + '}';
    }
    
    
    
 
    
}
