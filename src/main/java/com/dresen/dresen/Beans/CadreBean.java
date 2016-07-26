/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ICadreService;
import com.dresen.dresen.ServiceInterface.ICorpsService;
import com.dresen.dresen.entities.Cadre;
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
public class CadreBean {

    @ManagedProperty(value = "#{ICadreService}")
    private ICadreService iCadreService;

    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;

    private long idCorps;
    private List<Corps> listCorps;
    private Corps corps = new Corps();
    private Cadre cadre = new Cadre();

    public CadreBean() {
        idCorps = 0L;
    }

    public ICadreService getiCadreService() {
        return iCadreService;
    }

    public void setiCadreService(ICadreService iCadreService) {
        this.iCadreService = iCadreService;
    }

    public Corps getCorps() {
        return corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
    }

    public long getIdCorps() {
        return idCorps;
    }

    public void setIdCorps(long idCorps) {
        this.idCorps = idCorps;
    }

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public List<Corps> getListCorps() {
        return iCorpsService.findAllCorps();
    }

    public void setListCorps(List<Corps> listCorps) {
        this.listCorps = listCorps;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public Cadre createCadre() {
        try {
            corps = iCorpsService.findCorpsById(idCorps);
            cadre.setCorps(corps);
            iCadreService.createCadre(cadre);
            FacesMessage msg = new FacesMessage("Cadre enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return cadre;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement du cadre, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Cadre findCadrebyId() {
        return iCadreService.findCadreById(cadre.getId());
    }

    public Cadre updateCadre() {
        try {
            corps = iCorpsService.findCorpsById(idCorps);
            cadre.setCorps(corps);
            iCadreService.updateCadre(cadre);
            FacesMessage msg = new FacesMessage("Cadre modifié avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return cadre;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification du cadre, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Cadre> findAllCadre() {
        return iCadreService.findAllCadre();
    }

}
