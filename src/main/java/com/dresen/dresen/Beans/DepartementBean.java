/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.entities.Departement;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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

    public Departement createDepartement() {
        try {
            iDepartementService.createDepartement(departement);
            FacesMessage msg = new FacesMessage("Département enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return departement;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement du département, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Departement findDepartementById() {
        return iDepartementService.findDepartementById(departement.getId());
    }

    public Departement updateDepartement() {
        try {
            iDepartementService.updateDepartement(departement);
            FacesMessage msg = new FacesMessage("Département modifié avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return departement;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification du département, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Departement> findAllDepartement() {
        return iDepartementService.findAllDepartement();
    }

    public void reset() {
        this.departement.setIntituleDepartement("");
        this.setDepartement(null);
    }
}
