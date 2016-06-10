/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ISpecialiteService;
import com.dresen.dresen.entities.Specialite;
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
public class SpecialiteBean {
    @ManagedProperty(value = "#{ISpecialiteService}")
    private ISpecialiteService iSpecialiteService;

    private Specialite specialite = new Specialite();

    public SpecialiteBean() {
    }

    public ISpecialiteService getiSpecialiteService() {
        return iSpecialiteService;
    }

    public void setiSpecialiteService(ISpecialiteService iSpecialiteService) {
        this.iSpecialiteService = iSpecialiteService;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
    }
    
    
    public Specialite createSpecialite(){
        return iSpecialiteService.createSpecialite(specialite);
    }
    public Specialite findSpecialiteById(){
        return iSpecialiteService.findSpecialiteById(specialite.getIdSpecialite());
    }
    public Specialite updateSpecialite(){
        return iSpecialiteService.updateSpecialite(specialite);
    }
    public List<Specialite> findAllSpecialite(){
        return iSpecialiteService.findAllSpecialite();
    }
}

