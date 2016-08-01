/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.ServiceInterface.IRangerFonctioService;
import com.dresen.dresen.entities.Fonctionnaire;
import com.dresen.dresen.entities.GradeFonctio;
import com.dresen.dresen.entities.RangerFonctio;
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
public class RangerFonctioBean {

    @ManagedProperty(value = "#{IRangerFonctioService}")
    private IRangerFonctioService iRangerFonctioService;

    @ManagedProperty(value = "#{IGradeFonctioService}")
    private IGradeFonctioService iGradeFonctioService;

    @ManagedProperty(value = "#IFonctionnaireService")
    private IFonctionnaireService iFonctionnaireService;

    private long idGradeFonctio;
    private long idFonctionnaire;
    private List<Fonctionnaire> listFonctionnaire;
    private List<GradeFonctio> listGradeFonctio;

    private Fonctionnaire fonctionnaire = new Fonctionnaire();
    private GradeFonctio gradeFonctio = new GradeFonctio();
    private RangerFonctio rangerFonctio = new RangerFonctio();

    public RangerFonctioBean() {
        idGradeFonctio = 0L;
        idFonctionnaire = 0L;
    }

    public IRangerFonctioService getiRangerFonctioService() {
        return iRangerFonctioService;
    }

    public void setiRangerFonctioService(IRangerFonctioService iRangerFonctioService) {
        this.iRangerFonctioService = iRangerFonctioService;
    }

    public IGradeFonctioService getiGradeFonctioService() {
        return iGradeFonctioService;
    }

    public void setiGradeFonctioService(IGradeFonctioService iGradeFonctioService) {
        this.iGradeFonctioService = iGradeFonctioService;
    }

    public IFonctionnaireService getiFonctionnaireService() {
        return iFonctionnaireService;
    }

    public void setiFonctionnaireService(IFonctionnaireService iFonctionnaireService) {
        this.iFonctionnaireService = iFonctionnaireService;
    }

    public long getIdGradeFonctio() {
        return idGradeFonctio;
    }

    public void setIdGradeFonctio(long idGradeFonctio) {
        this.idGradeFonctio = idGradeFonctio;
    }

    public long getIdFonctionnaire() {
        return idFonctionnaire;
    }

    public void setIdFonctionnaire(long idFonctionnaire) {
        this.idFonctionnaire = idFonctionnaire;
    }

    public List<Fonctionnaire> getListFonctionnaire() {
        return iFonctionnaireService.findAllFonctionnaire();
    }

    public void setListFonctionnaire(List<Fonctionnaire> listFonctionnaire) {
        this.listFonctionnaire = listFonctionnaire;
    }

    public List<GradeFonctio> getListGradeFonctio() {
        return iGradeFonctioService.findAllGradeFonctio();
    }

    public void setListGradeFonctio(List<GradeFonctio> listGradeFonctio) {
        this.listGradeFonctio = listGradeFonctio;
    }

    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(Fonctionnaire fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public GradeFonctio getGradeFonctio() {
        return gradeFonctio;
    }

    public void setGradeFonctio(GradeFonctio gradeFonctio) {
        this.gradeFonctio = gradeFonctio;
    }

    public RangerFonctio getRangerFonctio() {
        return rangerFonctio;
    }

    public void setRangerFonctio(RangerFonctio rangerFonctio) {
        this.rangerFonctio = rangerFonctio;
    }

    public RangerFonctio createRangerFonctio() {
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        fonctionnaire = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        rangerFonctio.setFonctionnaire(fonctionnaire);
        rangerFonctio.setGradeFonctio(gradeFonctio);
        return iRangerFonctioService.createRangerFonctio(rangerFonctio);
    }

    public RangerFonctio findRangerFonctioById() {
        return iRangerFonctioService.findRangerFonctioById(rangerFonctio.getId());
    }

    public RangerFonctio updateRangerFonctio() {
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        fonctionnaire = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        rangerFonctio.setFonctionnaire(fonctionnaire);
        rangerFonctio.setGradeFonctio(gradeFonctio);
        return iRangerFonctioService.updateRangerFonctio(rangerFonctio);
    }

    public List<RangerFonctio> findAllRangerFonctio() {
        return iRangerFonctioService.findAllRangerFonctio();
    }

    public RangerFonctio findRangerFonctioOpenByIdAgent() {
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        fonctionnaire = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        rangerFonctio.setFonctionnaire(fonctionnaire);
        rangerFonctio.setGradeFonctio(gradeFonctio);
        return iRangerFonctioService.findRangerFonctioOpenByIdAgent(rangerFonctio.getFonctionnaire().getId());
    }

    public List<RangerFonctio> findAllRangerFonctioOpen() {
        return iRangerFonctioService.findAllRangerFonctioOpen();
    }

    public List<RangerFonctio> findRangerFonctioByIdAgent() {
        return iRangerFonctioService.findRangerFonctioByIdAgent(rangerFonctio.getFonctionnaire().getId());
    }

}
