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
import com.dresen.dresen.ServiceInterface.ICategorieStructureService;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.entities.Departement;
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
    
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;
    
    @ManagedProperty(value  ="#{IDepartementService}")
    private IDepartementService iDepartementService;
    
    private long idDepartement;
    private long idArrondissement;
    private long idCategorieStructure;
    private StructureAttache structureAttache = new StructureAttache();
    private List<Arrondissement> listArrondissement;
    private List<Departement> listDepartement;
    private List<CategorieStructure> listCategorieStructure;
    private Arrondissement arrondissement = new Arrondissement();
    private CategorieStructure CategorieStructure = new CategorieStructure();

    public StructureBean() {
        idDepartement = 0L;
        idArrondissement = 0L;
        idCategorieStructure = 0L;
    }

    public ICategorieStructureService getiCategorieStructureService() {
        return iCategorieStructureService;
    }

    public void setiCategorieStructureService(ICategorieStructureService iCategorieStructureService) {
        this.iCategorieStructureService = iCategorieStructureService;
    }

    public long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public IDepartementService getiDepartementService() {
        return iDepartementService;
    }

    public void setiDepartementService(IDepartementService iDepartementService) {
        this.iDepartementService = iDepartementService;
    }

    public List<Departement> getListDepartement() {
        return iDepartementService.findAllDepartement();
    }

    public void setListDepartement(List<Departement> listDepartement) {
        this.listDepartement = listDepartement;
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
        return iArrondissementService.findArrondissementByIdDepart(idDepartement);
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
    public void changeListArr(){
        listArrondissement=iArrondissementService.findArrondissementByIdDepart(idDepartement);
    }
    
    public StructureAttache createStructure(){
        System.out.println("vvsssssssssvsssssssssssssssssssssssvv why don't you work");
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
