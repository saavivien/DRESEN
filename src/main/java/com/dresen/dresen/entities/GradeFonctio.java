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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
public class GradeFonctio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idGradeFonctio;
    
    @Column (nullable = false, unique = true)
    private String intituleGradeFonctio;
    
    @Column
    private Categorie categororie;
    
    @Column
    private int retraite;
    
    @OneToMany (mappedBy = "gradeFonctio")
    private List<RangerFonctio> listRangerFonctios; 
    
    @ManyToOne
    private Cadre cadre;

    public GradeFonctio() {
    }
    
    

    public Long getIdGradeFonctio() {
        return idGradeFonctio;
    }

    public void setId(Long idGradeFonctio) {
        this.idGradeFonctio = idGradeFonctio;
    }

    public String getIntituleGradeFonctio() {
        return intituleGradeFonctio;
    }

    public void setIntituleGradeFonctio(String intituleGradeFonctio) {
        this.intituleGradeFonctio = intituleGradeFonctio;
    }

    public Categorie getCategororie() {
        return categororie;
    }

    public void setCategororie(Categorie categororie) {
        this.categororie = categororie;
    }

    public List<RangerFonctio> getListRangerFonctios() {
        return listRangerFonctios;
    }

    public void setListRangerFonctios(List<RangerFonctio> listRangerFonctios) {
        this.listRangerFonctios = listRangerFonctios;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public int getRetraite() {
        return retraite;
    }

    public void setRetraite(int retraite) {
        this.retraite = retraite;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGradeFonctio != null ? idGradeFonctio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradeFonctio)) {
            return false;
        }
        GradeFonctio other = (GradeFonctio) object;
        return !((this.idGradeFonctio == null && other.idGradeFonctio != null) || (this.idGradeFonctio != null && !this.idGradeFonctio.equals(other.idGradeFonctio)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.data.GradeFonctio[ id=" + idGradeFonctio + " ]";
    }
    
}
