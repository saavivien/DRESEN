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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class CadreBean{
    @ManagedProperty(value = "#{ICadreService}")
    private ICadreService iCadreService;
    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;
    
    private long idCorps;
    private List<Corps> listCorps;
    private Cadre cadre = new Cadre();

    public ICadreService getiCadreService() {
        return iCadreService;
    }

    public void setiCadreService(ICadreService iCadreService) {
        this.iCadreService = iCadreService;
    }

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public long getIdCorps() {
        return idCorps;
    }

    public void setIdCorps(long idCorps) {
        this.idCorps = idCorps;
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

    public CadreBean() {
        idCorps = 0L;
    }
    
    
    public Cadre createCadre(){
        Corps corps = new Corps();
        corps = iCorpsService.findCorpsById(idCorps);
        cadre.setCorps(corps);
        return iCadreService.createCadre(cadre);
    }
    public Cadre findCadrebyId(){
        return iCadreService.findCadreById(cadre.getId());
    }
    public Cadre updateCadre(){
        Corps corps = new Corps();
        corps = iCorpsService.findCorpsById(idCorps);
        cadre.setCorps(corps);
        return iCadreService.updateCadre(cadre);
    }
     public List<Cadre> findAllCadre(){
        return iCadreService.findAllCadre();
    }
    
    
}
