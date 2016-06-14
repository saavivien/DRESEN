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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;



/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class ArrondissementBean{
    @ManagedProperty(value="#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    
    @ManagedProperty(value="#{IDepartementService}")
    private IDepartementService iDepartementService;
   
    private Arrondissement arrondissement = new Arrondissement();
    private Departement departement = new Departement();
    
    private List<Departement> listDepartement;
    private Long idDepartement;
    
    public ArrondissementBean(){
        idDepartement=0L;
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
    
    
    public Arrondissement createArrondissement(){
        departement = iDepartementService.findDepartementById(idDepartement);
        arrondissement.setDepartement(departement);
        return iArrondissementService.createArrondissement(arrondissement);
    }
    public Arrondissement findArrondissementById(){
        return iArrondissementService.findArrondissementById(arrondissement.getId());
    }
    public Arrondissement updateArrondissement(){
        departement = iDepartementService.findDepartementById(idDepartement);
        arrondissement.setDepartement(departement);
        return iArrondissementService.updateArrondissement(arrondissement);
    }
    public List<Arrondissement> findAllArrondissement(){
        return iArrondissementService.findAllArrondissement();
    }
    

}
