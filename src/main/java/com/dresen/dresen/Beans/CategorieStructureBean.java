/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.entities.CategorieStructure;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import com.dresen.dresen.ServiceInterface.ICategorieStructureService;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class CategorieStructureBean {

    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;

    private CategorieStructure categorieSturcture = new CategorieStructure();

    public ICategorieStructureService getiCategorieStructureService() {
        return iCategorieStructureService;
    }

    public void setiCategorieStructureService(ICategorieStructureService iCategorieStructureService) {
        this.iCategorieStructureService = iCategorieStructureService;
    }

    public CategorieStructure getCategorieSturcture() {
        return categorieSturcture;
    }

    public void setCategorieSturcture(CategorieStructure categorieSturcture) {
        this.categorieSturcture = categorieSturcture;
    }

    public CategorieStructureBean() {
    }

    public CategorieStructure createCategorieStructure() {
        try {
            iCategorieStructureService.createCategorieStructure(categorieSturcture);
            FacesMessage msg = new FacesMessage("Catégorie structure enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return categorieSturcture;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement de la catégorie structure, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public CategorieStructure updateCategorieStructure() {
        try {
            iCategorieStructureService.updateCategorieStructure(categorieSturcture);
            FacesMessage msg = new FacesMessage("Catégorie structure modifiée avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return categorieSturcture;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification de la catégorie structure, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public CategorieStructure findCategorieStructurebyId() {
        return iCategorieStructureService.findCategorieStructureById(categorieSturcture.getId());
    }

    public List<CategorieStructure> findAllCategorieStructure() {
        return iCategorieStructureService.findAllCategorieStructure();
    }

}
