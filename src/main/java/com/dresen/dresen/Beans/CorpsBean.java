/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ICorpsService;
import com.dresen.dresen.entities.Corps;
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
public class CorpsBean {

    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;

    private Corps corps = new Corps();

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public Corps getCorps() {
        return corps;
    }

    public CorpsBean() {
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }

    public Corps createCorps() {
        try {
            iCorpsService.createCorps(corps);
            FacesMessage msg = new FacesMessage("Corps enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return corps;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement du corps, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Corps findCorpsById() {
        return iCorpsService.findCorpsById(corps.getId());
    }

    public Corps updateCorps() {
        try {
            iCorpsService.updateCorps(corps);
            FacesMessage msg = new FacesMessage("Corps modifié avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return corps;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification du corps, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Corps> findAllCorps() {
        return iCorpsService.findAllCorps();
    }
}
