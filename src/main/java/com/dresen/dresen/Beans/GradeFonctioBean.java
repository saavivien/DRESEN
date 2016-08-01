/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ICadreService;
import com.dresen.dresen.ServiceInterface.ICorpsService;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.entities.Cadre;
import com.dresen.dresen.entities.Categorie;
import com.dresen.dresen.entities.Corps;
import com.dresen.dresen.entities.GradeFonctio;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@ViewScoped
public class GradeFonctioBean {

    @ManagedProperty(value = "#{IGradeFonctioService}")
    private IGradeFonctioService IGradeFonctioService;

    @ManagedProperty(value = "#{ICadreService}")
    private ICadreService iCadreService;

    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;

    private List<Corps> listCorps;
    private List<Cadre> listCadre;
    private List<Cadre> listAge;
    private long idCadre;
    private long idCorps;
    private GradeFonctio gradeFonctio = new GradeFonctio();
    private Cadre cadre = new Cadre();

    public GradeFonctioBean() {
        idCadre = 0L;
        idCorps = 0L;
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
        return iCadreService.findCadreByIdCorps(idCorps);
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

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public List<Corps> getListCorps() {
        return iCorpsService.findAllCorps();
    }

    public void setListCorps(List<Corps> listCorps) {
        this.listCorps = listCorps;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public long getIdCorps() {
        return idCorps;
    }

    public void setIdCorps(long idCorps) {
        this.idCorps = idCorps;
    }

    public List ages() {
        List listAges = new ArrayList();
        listAges.add(45);
        listAges.add(50);
        listAges.add(55);
        listAges.add(60);
        listAges.add(65);
        return listAges;
    }

    public List<Categorie> categories() {
        List<Categorie> listCategorie = new ArrayList<Categorie>();
        listCategorie.addAll(Arrays.asList(Categorie.values()));
        return listCategorie;
    }

    /*
    this is to reinitialize/reinitialize the entity gradeFonctio before creating another
     */
    public void initGradeFonc() {
        idCorps = 0L;
        cadre = null;
        gradeFonctio = new GradeFonctio();
    }

    /*
    this is aim to initialize the oneMenu to nothing before updating
     */
    public void updateGradeFonc() {
        if (gradeFonctio == null) {
            idCorps = 0L;
            cadre = null;
        } else {
            cadre = gradeFonctio.getCadre();
            idCorps = cadre.getCorps().getId();
        }
    }

    public GradeFonctio createGradeFonction() throws Exception {
        try {
            cadre = iCadreService.findCadreById(idCadre);
            gradeFonctio.setCadre(cadre);
            IGradeFonctioService.createGradeFonctio(gradeFonctio);
            FacesMessage msg = new FacesMessage("Grade enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return gradeFonctio;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement du grade, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public GradeFonctio findGradeFonctionById() {
        return IGradeFonctioService.findGradeFonctioById(gradeFonctio.getId());
    }

    public GradeFonctio updateGradeFonction() throws Exception {
        try {
            cadre = iCadreService.findCadreById(idCadre);
            gradeFonctio.setCadre(cadre);
            IGradeFonctioService.updateGradeFonctio(gradeFonctio);
            FacesMessage msg = new FacesMessage("Grade modifié avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return gradeFonctio;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification du grade, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<GradeFonctio> findAllGradeFonction() {
        return IGradeFonctioService.findAllGradeFonctio();
    }
}
