/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.entities.Departement;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class DepartementBean {
    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService iDepartementService;
    
    private Departement departement = new Departement();

    public IDepartementService getiDepartementService() {
        return iDepartementService;
    }

    public void setiDepartementService(IDepartementService iDepartementService) {
        this.iDepartementService = iDepartementService;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public DepartementBean() {
    }
    public Departement createDepartement(){
        return iDepartementService.createDepartement(departement);
    }
    public Departement findDepartementById(){
        return iDepartementService.findDepartementById(departement.getId());
    }
    public Departement updateDepartement(){
        return iDepartementService.updateDepartement(departement);
    }
     public List<Departement> findAllDepartement(){
        return iDepartementService.findAllDepartement();
    }
    
    
}
