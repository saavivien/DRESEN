/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.ServiceInterface.IGradeContractService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.ServiceInterface.IRangerContractService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Affectation;
import com.dresen.dresen.entities.Contractuel;
import com.dresen.dresen.entities.GradeContract;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.Promotion;
import com.dresen.dresen.entities.RangerContract;
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
public class ContractuelBean {
    @ManagedProperty(value = "#{IContractuelService}")
    private IContractuelService iContractuelService;
    @ManagedProperty(value = "#{IGradeContractService}")
    private IGradeContractService iGradeContractService;
    @ManagedProperty(value = "#{IRangerContractService}")
    private IRangerContractService iRangerContractService;
    @ManagedProperty(value = "#{IPromotionService}")
    private IPromotionService iPromotionService;
    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    @ManagedProperty(value = "#{IAffectationService}")
    private IAffectationService iAffectationService;
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
    
    private Contractuel contratuel = new Contractuel();
    private GradeContract gradeContract = new GradeContract();
    private RangerContract rangerContract = new RangerContract();
    private Promotion promotion = new Promotion();
    private Poste poste = new Poste();
    private Affectation affectation = new Affectation();
    private StructureAttache structureAttache = new StructureAttache();

    List<GradeContract> listGradeContract;
    List<Poste> listPoste;
    List<StructureAttache> listStructureAttache;
    private long idGradeContract, idRangerContract, idStructure, idPoste;
    
    public ContractuelBean(){
        idGradeContract = 0L;
        idRangerContract = 0L;
        idStructure = 0L;
        idPoste = 0L;
    }

    public IContractuelService getiContractuelService() {
        return iContractuelService;
    }

    public void setiContractuelService(IContractuelService iContractuelService) {
        this.iContractuelService = iContractuelService;
    }

    public IGradeContractService getiGradeContractService() {
        return iGradeContractService;
    }

    public void setiGradeContractService(IGradeContractService iGradeContractService) {
        this.iGradeContractService = iGradeContractService;
    }

    public IRangerContractService getiRangerContractService() {
        return iRangerContractService;
    }

    public void setiRangerContractService(IRangerContractService iRangerContractService) {
        this.iRangerContractService = iRangerContractService;
    }

    public List<GradeContract> getListGradeContract() {
        return iGradeContractService.findAllGradeContract();
    }

    public void setListGradeContract(List<GradeContract> listGradeContract) {
        this.listGradeContract = listGradeContract;
    }

    public long getIdGradeContract() {
        return idGradeContract;
    }

    public void setIdGradeContract(long idGradeContract) {
        this.idGradeContract = idGradeContract;
    }

    public long getIdRangerContract() {
        return idRangerContract;
    }

    public void setIdRangerContract(long idRangerContract) {
        this.idRangerContract = idRangerContract;
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

    public Contractuel getContratuel() {
        return contratuel;
    }

    public void setContratuel(Contractuel contratuel) {
        this.contratuel = contratuel;
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

    public GradeContract getGradeContract() {
        return gradeContract;
    }

    public void setGradeContract(GradeContract gradeContract) {
        this.gradeContract = gradeContract;
    }

    public RangerContract getRangerContract() {
        return rangerContract;
    }

    public void setRangerContract(RangerContract rangerContract) {
        this.rangerContract = rangerContract;
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
    
    
    
    public Contractuel createContractuel(){
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        poste = iPosteService.findPosteById(idPoste);
        rangerContract.setContratuel(contratuel);
        rangerContract.setGradeContract(gradeContract);
        affectation.setAgent(contratuel);
        affectation.setStructure(structureAttache);
        promotion.setAgent(contratuel);
        promotion.setPoste(poste);
        iRangerContractService.createRangerContract(rangerContract);
        iPromotionService.createPromotion(promotion);
        iAffectationService.createAffectation(affectation);
        return iContractuelService.createContractuel(contratuel); 
    }
    public Contractuel findContractuelById(){
        return iContractuelService.findContractuelById(contratuel.getIdAgent()); 
    }
    public Contractuel updateContractuel(){
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        poste = iPosteService.findPosteById(idPoste);
        rangerContract.setContratuel(contratuel);
        rangerContract.setGradeContract(gradeContract);
        affectation.setAgent(contratuel);
        affectation.setStructure(structureAttache);
        promotion.setAgent(contratuel);
        promotion.setPoste(poste);
        iRangerContractService.createRangerContract(rangerContract);
        iPromotionService.createPromotion(promotion);
        iAffectationService.createAffectation(affectation);
        return iContractuelService.updateContractuel(contratuel); 
    }
     public List<Contractuel> findAllContractuel(){
        return iContractuelService.findAllContractuel(); 
    }
}
