/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Vivien Saa
 */
@Entity
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
