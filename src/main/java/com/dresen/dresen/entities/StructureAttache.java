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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "StructureAttache.findStructureAttacheByCategorieAndArrondissement", query = "SELECT sa FROM StructureAttache sa WHERE sa.arrondissement.id = :param1 AND sa.categorieStructure.id = :param2")       
})
public class StructureAttache implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column (nullable = false, unique = true)
    private String intituleStructure;
    
    @Column (nullable = false, unique = true)
    private String codeStructure;
    
    @ManyToOne
    private Arrondissement arrondissement;
    
    @ManyToOne
    private CategorieStructure categorieStructure;
    
    @OneToMany (mappedBy = "structureAttache")
    private List<Affectation> listAffectation;
   
    public StructureAttache() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
      

    public String getIntituleStructure() {
        return intituleStructure;
    }

    public void setIntituleStructure(String intituleStructure) {
        this.intituleStructure = intituleStructure;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public List<Affectation> getListAffectation() {
        return listAffectation;
    }

    public void setListAffectation(List<Affectation> listAffectation) {
        this.listAffectation = listAffectation;
    }

    public CategorieStructure getCategorieStructure() {
        return categorieStructure;
    }

    public void setCategorieStructure(CategorieStructure categorieStructure) {
        this.categorieStructure = categorieStructure;
    }

    public String getCodeStructure() {
        return codeStructure;
    }

    public void setCodeStructure(String codeStructure) {
        this.codeStructure = codeStructure;
    }
    

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
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
        final StructureAttache other = (StructureAttache) obj;
        if ((this.intituleStructure == null) ? (other.intituleStructure != null) : !this.intituleStructure.equals(other.intituleStructure)) {
            return false;
        }
        if ((this.codeStructure == null) ? (other.codeStructure != null) : !this.codeStructure.equals(other.codeStructure)) {
            return false;
        }
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if (this.arrondissement != other.arrondissement && (this.arrondissement == null || !this.arrondissement.equals(other.arrondissement))) {
            return false;
        }
        return !(this.categorieStructure != other.categorieStructure && (this.categorieStructure == null || !this.categorieStructure.equals(other.categorieStructure)));
    }

   

    @Override
    public String toString() {
        return "com.dresen.dresen.data.Structure[ id=" + id + " ]";
    }
    
}