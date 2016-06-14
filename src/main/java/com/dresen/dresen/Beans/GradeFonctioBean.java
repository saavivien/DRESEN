/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ICadreService;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.entities.Cadre;
import com.dresen.dresen.entities.GradeFonctio;
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
public class GradeFonctioBean {
    @ManagedProperty(value = "#{IGradeFonctioService}")
    private IGradeFonctioService IGradeFonctioService;
    @ManagedProperty(value = "#ICadreService")
    private ICadreService iCadreService;
    private List<Cadre> listCadre;
    private long idCadre;
    private GradeFonctio gradeFonctio = new GradeFonctio();
    private Cadre cadre = new Cadre();
    public GradeFonctioBean() {
        idCadre = 0L;
    }

    public IGradeFonctioService getIGradeFonctioService() {
        return IGradeFonctioService;
    }

    public void setIGradeFonctioService(IGradeFonctioService IGradeFonctioService) {
        this.IGradeFonctioService = IGradeFonctioService;
    }

    public ICadreService getiCadreService() {
        return iCadreService;
    }

    public void setiCadreService(ICadreService iCadreService) {
        this.iCadreService = iCadreService;
    }

    public List<Cadre> getListCadre() {
        return iCadreService.findAllCadre();
    }

    public void setListCadre(List<Cadre> listCadre) {
        this.listCadre = listCadre;
    }

    public long getIdCadre() {
        return idCadre;
    }

    public void setIdCadre(long idCadre) {
        this.idCadre = idCadre;
    }

    public GradeFonctio getGradeFonctio() {
        return gradeFonctio;
    }

    public void setGradeFonctio(GradeFonctio gradeFonctio) {
        this.gradeFonctio = gradeFonctio;
    }
    
    public GradeFonctio createGradeFonction(){
        cadre = iCadreService.findCadreById(idCadre);
        gradeFonctio.setCadre(cadre);
        return IGradeFonctioService.createGradeFonctio(gradeFonctio);       
    }
    public GradeFonctio findGradeFonctionById(){
        return IGradeFonctioService.findGradeFonctioById(gradeFonctio.getId());       
    }
    public GradeFonctio updateGradeFonction(){
        cadre = iCadreService.findCadreById(idCadre);
        gradeFonctio.setCadre(cadre);
        return IGradeFonctioService.updateGradeFonctio(gradeFonctio);       
    }
    public List<GradeFonctio> findAllGradeFonction(){
        return IGradeFonctioService.findAllGradeFonctio();       
    }
}
