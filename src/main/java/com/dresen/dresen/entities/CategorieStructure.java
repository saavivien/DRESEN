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
 * Cette classe permet de regrouper les structures d'attaches en catégorie de structure ie. les délégations départementales les lycées etc.
 */
@Entity
@NamedQueries({
     @NamedQuery(name = "CategorieStructure.findCategorieStructureByName", query = "SELECT cs FROM CategorieStructure cs WHERE cs.intituleCategorieStructure = :param")
})
public class CategorieStructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String intituleCategorieStructure;
            
    @OneToMany(mappedBy = "categorieStructure")
    private List<StructureAttache> listStructureAttaches;
       
    @OneToMany(mappedBy = "categorieStructure")
    private List<PosteStructure> listPosteStructures;

    public CategorieStructure() {
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<StructureAttache> getListStructureAttaches() {
        return listStructureAttaches;
    }

    public void setListStructureAttaches(List<StructureAttache> listStructureAttaches) {
        this.listStructureAttaches = listStructureAttaches;
    }

    public List<PosteStructure> getListPosteStructures() {
        return listPosteStructures;
    }

    public void setListPoste_Structures(List<PosteStructure> listPosteStructures) {
        this.listPosteStructures = listPosteStructures;
    }

    public String getIntituleCategorieStructure() {
        return intituleCategorieStructure;
    }

    public void setIntituleCategorieStructure(String intituleCategrieStructure) {
        this.intituleCategorieStructure = intituleCategrieStructure;
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
        if (!(object instanceof CategorieStructure)) {
            return false;
        }
        CategorieStructure other = (CategorieStructure) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return intituleCategorieStructure;
    }


    
}
