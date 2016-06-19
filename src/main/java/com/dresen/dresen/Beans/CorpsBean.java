/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ICorpsService;
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
public class CorpsBean {
    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;
    
    private Corps corps = new Corps();

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public Corps getCorps() {
        return corps;
    }

    public CorpsBean() {
    }
    

    public void setCorps(Corps corps) {
        this.corps = corps;
    }
    
    public Corps createCorps(){
        return iCorpsService.createCorps(corps);
    }
    public Corps findCorpsById(){
        return iCorpsService.findCorpsById(corps.getId());
    }
    public Corps updateCorps(){
        return iCorpsService.updateCorps(corps);
    }
    public List<Corps> findAllCorps(){
        return iCorpsService.findAllCorps();
    }
}
