/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
public class Fonctionnaire extends Agentp{
    
    @ManyToOne 
    private Specialite specialite;
    
    @OneToMany (mappedBy = "fonctionnaire")
    private List<RangerFonctio> listRangerFonctios;
  
    public Fonctionnaire() {
    }
    
    

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }

    public List<RangerFonctio> getListRangerFonctios() {
        return listRangerFonctios;
    }

    public void setListRangerFonctios(List<RangerFonctio> listRangerFonctios) {
        this.listRangerFonctios = listRangerFonctios;
    }
    
    
}
