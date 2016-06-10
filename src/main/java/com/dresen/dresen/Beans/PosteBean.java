/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Poste;
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
public class PosteBean {
    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
    private Poste poste = new Poste();
    
    private List<StructureAttache> listeStructure;
    private List<StructureAttache> listeStructurePoste;
    
    private long idStructureAttache;
    
    public PosteBean(){
        idStructureAttache = 0L;
    }

    public IPosteService getiPosteService() {
        return iPosteService;
    }

    public void setiPosteService(IPosteService iPosteService) {
        this.iPosteService = iPosteService;
    }

    public IStructureService getiStructureService() {
        return iStructureService;
    }

    public void setiStructureService(IStructureService iStructureService) {
        this.iStructureService = iStructureService;
    }

    public List<StructureAttache> getListeStructure() {
        return iStructureService.findAllStructureAttache();
    }

    public void setListeStructure(List<StructureAttache> listeStructure) {
        this.listeStructure = listeStructure;
    }

    public List<StructureAttache> getListeStructurePoste() {
        return listeStructurePoste;
    }

    public void setListeStructurePoste(List<StructureAttache> listeStructurePoste) {
        this.listeStructurePoste = listeStructurePoste;
    }

    public long getIdStructureAttache() {
        return idStructureAttache;
    }

    public void setIdStructureAttache(long idStructureAttache) {
        this.idStructureAttache = idStructureAttache;
    }
    
    public Poste createPoste(){
        return iPosteService.createPoste(poste);     
    }
    public Poste findPosteById(){
        return iPosteService.findPosteById(poste.getIdPoste());     
    }
    public Poste updatePoste(){
        return iPosteService.updatePoste(poste);     
    }
    public List<Poste> findAllPoste(){
        return iPosteService.findAllPoste();     
    }
    
}
