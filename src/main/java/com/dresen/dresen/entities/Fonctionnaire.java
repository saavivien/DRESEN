/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
@NamedQueries({ 
    @NamedQuery(name = "Fonctionnaire.findFonctionnaireActif", query = "SELECT DISTINCT f FROM Fonctionnaire f, Affectation a JOIN f.listAffectations f_a WHERE f_a.dateFinAffect = NULL"),
    @NamedQuery(name = "Fonctionnaire.findFonctionnaireRetraites", query = "SELECT f FROM Fonctionnaire f WHERE f.isRetraite = TRUE")        
})
public class Fonctionnaire extends Agentp{
    
    @OneToMany (mappedBy = "fonctionnaire")
    private List<RangerFonctio> listRangerFonctios;
  
    public Fonctionnaire() {
    }

    public List<RangerFonctio> getListRangerFonctios() {
        return listRangerFonctios;
    }

    public void setListRangerFonctios(List<RangerFonctio> listRangerFonctios) {
        this.listRangerFonctios = listRangerFonctios;
    }
    
    
}
