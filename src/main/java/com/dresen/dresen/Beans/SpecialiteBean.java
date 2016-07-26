/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ISpecialiteService;
import com.dresen.dresen.entities.Specialite;
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

    public Specialite createSpecialite() {
        try {
            iSpecialiteService.createSpecialite(specialite);
            FacesMessage msg = new FacesMessage("Spécialite enregistrée avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return specialite;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement de la spécialité, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Specialite findSpecialiteById() {
        return iSpecialiteService.findSpecialiteById(specialite.getId());
    }

    public Specialite updateSpecialite() {
        try {
            iSpecialiteService.updateSpecialite(specialite);
            FacesMessage msg = new FacesMessage("Spécialité modifiée avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return specialite;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification du poste, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Specialite> findAllSpecialite() {
        return iSpecialiteService.findAllSpecialite();
    }
}
