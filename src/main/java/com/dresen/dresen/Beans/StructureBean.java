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
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@ViewScoped
public class StructureBean implements Serializable{
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
  
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    private List<Arrondissement> listArrondissement;
    private Arrondissement arrondissement;
    
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;
    private List<CategorieStructure> listCategorieStructure;
    private CategorieStructure categorieStructure;
    
    @ManagedProperty(value  ="#{IDepartementService}")
    private IDepartementService iDepartementService;
    private List<Departement> listDepartement;
    private String intituleStructure;
    private String codeStructure;
    private long idDepartement;
    private long idArrondissement;
    private long idCategorieStructure;
    private StructureAttache structureAttache;
   
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

    public StructureAttache getStructureAttache() {
        return structureAttache;
    }

    public void setStructureAttache(StructureAttache structureAttache) {
        this.structureAttache = structureAttache;
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

    public String getIntituleStructure() {
        return intituleStructure;
    }

    public void setIntituleStructure(String intituleStructure) {
        this.intituleStructure = intituleStructure;
    }

    public String getCodeStructure() {
        return codeStructure;
    }

    public void setCodeStructure(String codeStructure) {
        this.codeStructure = codeStructure;
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
        return categorieStructure;
    }

    public void setCategorieStructure(CategorieStructure categorieStructure) {
        this.categorieStructure = categorieStructure;
    }
    /*
    this is to initialize the entity structureAttache before creating another
    */
    public void initStruct(){
        idDepartement = 0L;
        idCategorieStructure = 0L;
        arrondissement = null;
        structureAttache = new StructureAttache();   
    }
    /*
    this is aim to initialize the oneMenu to nothing before updating
    */
    public void updateStruct(){
        if (structureAttache==null) {
            idDepartement = 0L;
            idCategorieStructure = 0L;
            arrondissement = null;
        } else {
            arrondissement = structureAttache.getArrondissement();
            idDepartement = arrondissement.getDepartement().getId();
            idCategorieStructure = structureAttache.getCategorieStructure().getId();
        }
    }

    public StructureAttache createStructure()throws Exception{
        try {
            arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
            categorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
            structureAttache.setCategorieStructure(categorieStructure);
            structureAttache.setArrondissement(arrondissement);
            iStructureService.createStructureAttache(structureAttache);
            FacesMessage msg = new FacesMessage("Structure enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return structureAttache;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement de la structure, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }
    public StructureAttache findStructureById(){
        return iStructureService.findStructureAttacheById(structureAttache.getId());
    } 
    public StructureAttache updateStructure()throws Exception{
        try {
            arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
            categorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
            structureAttache.setCategorieStructure(categorieStructure);
            structureAttache.setArrondissement(arrondissement);
            iStructureService.updateStructureAttache(structureAttache);
            FacesMessage msg = new FacesMessage("Structure modifiée avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return structureAttache;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification de la structure, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }
    public List<StructureAttache> findAllStructure(){
        return iStructureService.findAllStructureAttache();
    } 
}
