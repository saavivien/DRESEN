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
    
    public CategorieStructure createCategorieStructure(){
        return iCategorieStructureService.createCategorieStructure(categorieSturcture);
    }
    public CategorieStructure updateCategorieStructure(){
        return iCategorieStructureService.updateCategorieStructure(categorieSturcture);
    }
    public CategorieStructure findCategorieStructurebyId(){
        return iCategorieStructureService.findCategorieStructureById(categorieSturcture.getId());
    }
    public List<CategorieStructure> findAllCategorieStructure(){
        return iCategorieStructureService.findAllCategorieStructure();
    }
    
    
    
}
