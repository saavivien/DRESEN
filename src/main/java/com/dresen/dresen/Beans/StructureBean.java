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
public class StructureBean {
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
    
    @ManagedProperty(value = "#IArrondissementService")
    private IArrondissementService iArrondissementService;
    
    private long idArrondissement;
    private StructureAttache structureAttache = new StructureAttache();
    private List<Arrondissement> listArrondissement;
    private Arrondissement arrondissement = new Arrondissement();

    public StructureBean() {
        idArrondissement = 0L;
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
        return listArrondissement;
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
    
    public StructureAttache createStructure(){
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        structureAttache.setArrondissement(arrondissement);
        return iStructureService.createStructureAttache(structureAttache);
    }
    public StructureAttache findStructureById(){
        return iStructureService.findStructureAttacheById(structureAttache.getIdStructure());
    } 
    public StructureAttache updateStructure(){
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        structureAttache.setArrondissement(arrondissement);
        return iStructureService.updateStructureAttache(structureAttache);
    }
    public List<StructureAttache> findAllStructure(){
        return iStructureService.findAllStructureAttache();
    } 
}
