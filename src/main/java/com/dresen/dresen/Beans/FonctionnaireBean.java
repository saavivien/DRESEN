/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.ServiceInterface.IRangerFonctioService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Affectation;
import com.dresen.dresen.entities.Fonctionnaire;
import com.dresen.dresen.entities.GradeFonctio;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.Promotion;
import com.dresen.dresen.entities.RangerFonctio;
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
public class FonctionnaireBean {
    @ManagedProperty(value = "#{IFonctionnaireService}")
    private IFonctionnaireService iFonctionnaireService;
    @ManagedProperty(value = "#{IGradeFonctioService}")
    private IGradeFonctioService iGradeFonctioService;
    @ManagedProperty(value = "#{IRangerFonctioService}")
    private IRangerFonctioService iRangerFonctioService;
    @ManagedProperty(value = "#{IPromotionService}")
    private IPromotionService iPromotionService;
    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    @ManagedProperty(value = "#{IAffectationService}")
    private IAffectationService iAffectationService;
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
    
    private Fonctionnaire fonctionnaire = new Fonctionnaire();
    private GradeFonctio gradeFonctio = new GradeFonctio();
    private RangerFonctio rangerFonctio = new RangerFonctio();
    private Promotion promotion = new Promotion();
    private Poste poste = new Poste();
    private Affectation affectation = new Affectation();
    private StructureAttache structureAttache = new StructureAttache();

    List<GradeFonctio> listGradeFonctio;
    List<Poste> listPoste;
    List<StructureAttache> listStructureAttache;
    private long idGradeFonctio, idRangerFonctio, idStructure, idPoste;
    
    public FonctionnaireBean(){
        idGradeFonctio = 0L;
        idRangerFonctio = 0L;
        idStructure = 0L;
        idPoste = 0L;
    }

    public IFonctionnaireService getiFonctionnaireService() {
        return iFonctionnaireService;
    }

    public void setiFonctionnaireService(IFonctionnaireService iFonctionnaireService) {
        this.iFonctionnaireService = iFonctionnaireService;
    }

    public IGradeFonctioService getiGradeFonctioService() {
        return iGradeFonctioService;
    }

    public void setiGradeFonctioService(IGradeFonctioService iGradeFonctioService) {
        this.iGradeFonctioService = iGradeFonctioService;
    }

    public IRangerFonctioService getiRangerFonctioService() {
        return iRangerFonctioService;
    }

    public void setiRangerFonctioService(IRangerFonctioService iRangerFonctioService) {
        this.iRangerFonctioService = iRangerFonctioService;
    }

    public List<GradeFonctio> getListGradeFonctio() {
        return iGradeFonctioService.findAllGradeFonctio();
    }

    public void setListGradeFonctio(List<GradeFonctio> listGradeFonctio) {
        this.listGradeFonctio = listGradeFonctio;
    }

    public long getIdGradeFonctio() {
        return idGradeFonctio;
    }

    public void setIdGradeFonction(long idGradeFonctio) {
        this.idGradeFonctio = idGradeFonctio;
    }

    public long getIdRangerFonctio() {
        return idRangerFonctio;
    }

    public void setIdRangerFonctio(long idRangerFonctio) {
        this.idRangerFonctio = idRangerFonctio;
    }

    public IPosteService getiPosteService() {
        return iPosteService;
    }

    public void setiPosteService(IPosteService iPosteService) {
        this.iPosteService = iPosteService;
    }

    public IStructureService getIStructureService() {
        return iStructureService;
    }

    public void setIStructureService(IStructureService IStructureService) {
        this.iStructureService = IStructureService;
    }

    public Fonctionnaire getFonctionnaire() {
        return fonctionnaire;
    }

    public void setFonctionnaire(Fonctionnaire fonctionnaire) {
        this.fonctionnaire = fonctionnaire;
    }

    public IPromotionService getiPromotionService() {
        return iPromotionService;
    }

    public void setiPromotionService(IPromotionService iPromotionService) {
        this.iPromotionService = iPromotionService;
    }

    public IAffectationService getiAffectationService() {
        return iAffectationService;
    }

    public void setiAffectationService(IAffectationService iAffectationService) {
        this.iAffectationService = iAffectationService;
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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    public StructureAttache getStructureAttache() {
        return structureAttache;
    }

    public void setStructureAttache(StructureAttache structureAttache) {
        this.structureAttache = structureAttache;
    }

    public List<Poste> getListPoste() {
        return iPosteService.findAllPoste();
    }

    public void setListPoste(List<Poste> listPoste) {
        this.listPoste = listPoste;
    }

    public List<StructureAttache> getListStructureAttache() {
        return iStructureService.findAllStructureAttache();
    }

    public void setListStructureAttache(List<StructureAttache> listStructureAttache) {
        this.listStructureAttache = listStructureAttache;
    }

    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long idStructure) {
        this.idStructure = idStructure;
    }

    public long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(long idPoste) {
        this.idPoste = idPoste;
    }
    
    
    
    public Fonctionnaire createFonctionnaire(){
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        poste = iPosteService.findPosteById(idPoste);
        rangerFonctio.setFonctionnaire(fonctionnaire);
        rangerFonctio.setGradeFonctio(gradeFonctio);
        affectation.setAgent(fonctionnaire);
        affectation.setStructureAttache(structureAttache);
        promotion.setAgent(fonctionnaire);
        promotion.setPoste(poste);
        iRangerFonctioService.createRangerFonctio(rangerFonctio);
        iPromotionService.createPromotion(promotion);
        iAffectationService.createAffectation(affectation);
        return iFonctionnaireService.createFonctionnaire(fonctionnaire); 
    }
    public Fonctionnaire findFonctionnaireById(){
        return iFonctionnaireService.findFonctionnaireById(fonctionnaire.getId()); 
    }
    public Fonctionnaire updateFonctionnaire(){
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        poste = iPosteService.findPosteById(idPoste);
        rangerFonctio.setFonctionnaire(fonctionnaire);
        rangerFonctio.setGradeFonctio(gradeFonctio);
        affectation.setAgent(fonctionnaire);
        affectation.setStructureAttache(structureAttache);
        promotion.setAgent(fonctionnaire);
        promotion.setPoste(poste);
        iRangerFonctioService.createRangerFonctio(rangerFonctio);
        iPromotionService.createPromotion(promotion);
        iAffectationService.createAffectation(affectation);
        return iFonctionnaireService.updateFonctionnaire(fonctionnaire); 
    }
     public List<Fonctionnaire> findAllFonctionnaire(){
        return iFonctionnaireService.findAllFonctionnaire(); 
    }
}
