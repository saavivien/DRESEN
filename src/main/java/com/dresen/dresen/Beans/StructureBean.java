/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IArrondissementService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Arrondissement;
import com.dresen.dresen.entities.StructureAttache;
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
public class StructureBean {
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
    
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    
    @ManagedProperty(value = "#{ICategorieStructuretService}")
    private ICategorieStructureService iCategorieStructureService;
    
    private long idArrondissement;
    private long idCategorieStructure;
    private StructureAttache structureAttache = new StructureAttache();
    private List<Arrondissement> listArrondissement;
    private List<CategorieStructure> listCategorieStructure;
    private Arrondissement arrondissement = new Arrondissement();
    private CategorieStructure CategorieStructure = new CategorieStructure();

    public StructureBean() {
        idArrondissement = 0L;
        idCategorieStructure = 0L;
    }

    public ICategorieStructureService getiCategorieStructureService() {
        return iCategorieStructureService;
    }

    public void setiCategorieStructureService(ICategorieStructureService iCategorieStructureService) {
        this.iCategorieStructureService = iCategorieStructureService;
    }

    

    public long getIdCategorieStructure() {
        return idCategorieStructure;
    }

    public void setIdCategorieStructure(long idCategorieStructure) {
        this.idCategorieStructure = idCategorieStructure;
    }

    public List<CategorieStructure> getListCategorieStructure() {
        return iCategorieStructureService.findAllCategorieStructure();
    }

    public void setListCategorieStructure(List<CategorieStructure> listCategorieStructure) {
        this.listCategorieStructure = listCategorieStructure;
    }
    
    

    public IStructureService getiStructureService() {
        return iStructureService;
    }

    public void setiStructureService(IStructureService iStructureService) {
        this.iStructureService = iStructureService;
    }

    public IArrondissementService getiArrondissementService() {
        return iArrondissementService;
    }

    public void setiArrondissementService(IArrondissementService iArrondissementService) {
        this.iArrondissementService = iArrondissementService;
    }

    public long getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(long idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public StructureAttache getStructureAttache() {
        return structureAttache;
    }

    public void setStructureAttache(StructureAttache structureAttache) {
        this.structureAttache = structureAttache;
    }

    public List<Arrondissement> getListArrondissement() {
        return iArrondissementService.findAllArrondissement();
    }

    public void setListArrondissement(List<Arrondissement> listArrondissement) {
        this.listArrondissement = listArrondissement;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public CategorieStructure getCategorieStructure() {
        return CategorieStructure;
    }

    public void setCategorieStructure(CategorieStructure CategorieStructure) {
        this.CategorieStructure = CategorieStructure;
    }
    
    
    public StructureAttache createStructure(){
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        CategorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        structureAttache.setCategorieStructure(CategorieStructure);
        structureAttache.setArrondissement(arrondissement);
        return iStructureService.createStructureAttache(structureAttache);
    }
    public StructureAttache findStructureById(){
        return iStructureService.findStructureAttacheById(structureAttache.getId());
    } 
    public StructureAttache updateStructure(){
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        CategorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        structureAttache.setCategorieStructure(CategorieStructure);
        structureAttache.setArrondissement(arrondissement);
        return iStructureService.updateStructureAttache(structureAttache);
    }
    public List<StructureAttache> findAllStructure(){
        return iStructureService.findAllStructureAttache();
    } 
}
