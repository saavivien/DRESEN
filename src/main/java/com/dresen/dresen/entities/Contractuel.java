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
    @NamedQuery(name = "Contractuel.findContractuelActif", query = "SELECT DISTINCT c FROM Contractuel c, Affectation a JOIN c.listAffectations c_a WHERE c_a.dateFinAffect = NULL"),
    @NamedQuery(name = "Contractuel.findContractuelRetraites", query = "SELECT c FROM Contractuel c WHERE c.isRetraité = TRUE")       
})
public class Contractuel extends Agentp{
    
    @OneToMany (mappedBy = "contractuel")
    private List<RangerContract> listRangerContracts;

    public Contractuel() {
    }


    public List<RangerContract> getListRangerContracts() {
        return listRangerContracts;
    }

    public void setListRangerContracts(List<RangerContract> listRangerContracts) {
        this.listRangerContracts = listRangerContracts;
    }
    
}
