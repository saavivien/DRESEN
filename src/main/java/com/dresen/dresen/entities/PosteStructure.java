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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Vivien Saa
 * this entity is usefull in order to create a link between a type of structure and various posts a structure has
 */
@Entity
@NamedQueries({
     @NamedQuery(name = "PosteStructure.findPosteStructureByPoste", query = "SELECT ps FROM PosteStructure ps WHERE ps.poste.id = :param"),
     @NamedQuery(name = "PosteStructure.deletePosteStructureByPoste", query = "DELETE FROM PosteStructure WHERE poste.id = :param"),
     @NamedQuery(name = "PosteStructure.findPosteStructureByCategorieStructure", query = "SELECT ps FROM PosteStructure ps WHERE ps.categorieStructure.id = :param")
})
public class PosteStructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Poste poste;
    
    @ManyToOne
    private CategorieStructure categorieStructure;

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public CategorieStructure getCategorieStructure() {
        return categorieStructure;
    }

    public void setCategorieStructure(CategorieStructure categorieStructure) {
        this.categorieStructure = categorieStructure;
    }


    
    public PosteStructure() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setIdPoste_Structure(Long idPoste_Structure) {
        this.id = idPoste_Structure;
    }

    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PosteStructure)) {
            return false;
        }
        PosteStructure other = (PosteStructure) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.dresen.dresen.entities.Poste_Structure[ idPoste_Structure=" + id + " ]";
    }
    
}
