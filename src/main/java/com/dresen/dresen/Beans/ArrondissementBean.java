/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IArrondissementService;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.entities.Arrondissement;
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
public class ArrondissementBean {

    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;

    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService iDepartementService;

    private Arrondissement arrondissement = new Arrondissement();
    private Departement departement = new Departement();

    private List<Departement> listDepartement;
    private Long idDepartement;

    public ArrondissementBean() {
        idDepartement = 0L;
    }

    public IArrondissementService getiArrondissementService() {
        return iArrondissementService;
    }

    public void setiArrondissementService(IArrondissementService iArrondissementService) {
        this.iArrondissementService = iArrondissementService;
    }

    public IDepartementService getiDepartementService() {
        return iDepartementService;
    }

    public void setiDepartementService(IDepartementService iDepartementService) {
        this.iDepartementService = iDepartementService;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public Long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(Long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public List<Departement> getListDepartement() {
        return iDepartementService.findAllDepartement();
    }

    public void setListDepartement(List<Departement> listDepartement) {
        this.listDepartement = listDepartement;
    }

    public Arrondissement createArrondissement() {
        try {
            departement = iDepartementService.findDepartementById(idDepartement);
            arrondissement.setDepartement(departement);
            iArrondissementService.createArrondissement(arrondissement);
            FacesMessage msg = new FacesMessage("Arrondissement enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return arrondissement;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement de l'arrondissement, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Arrondissement findArrondissementById() {
        return iArrondissementService.findArrondissementById(arrondissement.getId());
    }

    public Arrondissement updateArrondissement() {
        try {
            departement = iDepartementService.findDepartementById(idDepartement);
            arrondissement.setDepartement(departement);
            iArrondissementService.updateArrondissement(arrondissement);
            FacesMessage msg = new FacesMessage("Arrondissement modifié avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return arrondissement;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification de l'arrondissement, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Arrondissement> findAllArrondissement() {
        return iArrondissementService.findAllArrondissement();
    }

}
