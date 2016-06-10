/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.entities.Agentp;
import com.dresen.dresen.entities.Contractuel;
import com.dresen.dresen.entities.Fonctionnaire;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.Promotion;
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
public class PromotionBean {
    @ManagedProperty(value = "#{IPromotionService}")
    private IPromotionService iPromotionService;
    
    @ManagedProperty(value = "#{IContractuelService}")
    private IContractuelService iContractuelService;
    
    @ManagedProperty(value = "#{IFonctionnaireService}")
    private IFonctionnaireService iFonctionnaireService;
    
    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    
    private long idFonctionnaire;
    private long idContractuel;
    private long idPoste;
     
    private Promotion promotion = new Promotion();
     
    private List<Poste> listPoste;
    private List<Contractuel> listContractuel;
    private List<Fonctionnaire> listFonctionnaire;
    
    private Agentp agent;
    private Poste poste;
            
     public PromotionBean() {
        idFonctionnaire = 0L;
        idContractuel = 0L;
        idPoste = 0L;
    }

    public Agentp getAgent() {
        return agent;
    }

    public void setAgent(Agentp agent) {
        this.agent = agent;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

     
    public IPromotionService getiPromotionService() {
        return iPromotionService;
    }

    public void setiPromotionService(IPromotionService iPromotionService) {
        this.iPromotionService = iPromotionService;
    }

    public IContractuelService getiContractuelService() {
        return iContractuelService;
    }

    public void setiContractuelService(IContractuelService iContractuelService) {
        this.iContractuelService = iContractuelService;
    }

    public IFonctionnaireService getiFonctionnaireService() {
        return iFonctionnaireService;
    }

    public void setiFonctionnaireService(IFonctionnaireService iFonctionnaireService) {
        this.iFonctionnaireService = iFonctionnaireService;
    }

    public IPosteService getiPosteService() {
        return iPosteService;
    }

    public void setiPosteService(IPosteService iPosteService) {
        this.iPosteService = iPosteService;
    }

    public long getIdFonctionnaire() {
        return idFonctionnaire;
    }

    public void setIdFonctionnaire(long idFonctionnaire) {
        this.idFonctionnaire = idFonctionnaire;
    }

    public long getIdContractuel() {
        return idContractuel;
    }

    public void setIdContractuel(long idContractuel) {
        this.idContractuel = idContractuel;
    }

    public long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(long idPoste) {
        this.idPoste = idPoste;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
    

    public List<Poste> getListPoste() {
        return iPosteService.findAllPoste();
    }

    public void setListPoste(List<Poste> listPoste) {
        this.listPoste = listPoste;
    }

    public List<Contractuel> getListContractuel() {
        return iContractuelService.findAllContractuel();
    }

    public void setListContractuel(List<Contractuel> listContractuel) {
        this.listContractuel = listContractuel;
    }

    public List<Fonctionnaire> getListFonctionnaire() {
        return iFonctionnaireService.findAllFonctionnaire();
    }

    public void setListFonctionnaire(List<Fonctionnaire> listFonctionnaire) {
        this.listFonctionnaire = listFonctionnaire;
    }
    
    public Promotion createPromotion(){
        agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        if (agent == null)
            agent = iContractuelService.findContractuelById(idContractuel);
        poste = iPosteService.findPosteById(idPoste);
        promotion.setAgent(agent);
        promotion.setPoste(poste);
        return iPromotionService.createPromotion(promotion);
    }
    public Promotion findPromotionById(){
        return iPromotionService.findPromotionById(promotion.getIdPromotion());
    }
    public Promotion updatePromotion(){
        agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        if (agent == null)
            agent = iContractuelService.findContractuelById(idContractuel);
        poste = iPosteService.findPosteById(idPoste);
        promotion.setAgent(agent);
        promotion.setPoste(poste);
        return iPromotionService.updatePromotion(promotion);
    }
    public List<Promotion> findAllPromotion(){
        return iPromotionService.findAllPromotion();
    } 
    public Promotion findPromotionOpenByIdAgent(){
        agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        if (agent == null)
            agent = iContractuelService.findContractuelById(idContractuel);
        poste = iPosteService.findPosteById(idPoste);
        promotion.setAgent(agent);
        promotion.setPoste(poste);
        return iPromotionService.findPromotionOpenByIdAgent(promotion.getIdPromotion());
    }
     public List<Promotion> findAllPromotionOpen(){
        return iPromotionService.findAllPromotionOpen();
    } 
    
}
