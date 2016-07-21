/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.ServiceInterface.IArrondissementService;
import com.dresen.dresen.ServiceInterface.ICategorieStructureService;
import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.ServiceInterface.IGradeContractService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.ServiceInterface.IRangerContractService;
import com.dresen.dresen.ServiceInterface.ISpecialiteService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Affectation;
import com.dresen.dresen.entities.AffectationPromotion;
import com.dresen.dresen.entities.Agentp;
import com.dresen.dresen.entities.Arrondissement;
import com.dresen.dresen.entities.CategorieStructure;
import com.dresen.dresen.entities.Contractuel;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.GradeContract;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.Promotion;
import com.dresen.dresen.entities.RangerContract;
import com.dresen.dresen.entities.Sexe;
import com.dresen.dresen.entities.Specialite;
import com.dresen.dresen.entities.StructureAttache;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@ViewScoped
public class ContractuelBean implements Serializable{

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
    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService iDepartementService;
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;
    @ManagedProperty(value = "#{ISpecialiteService}")
    private ISpecialiteService iSpecialiteService;

    private static Logger logger = Logger.getLogger(ContractuelBean.class.getName());
    private Contractuel contractuel = new Contractuel();
    private GradeContract gradeContract = new GradeContract();
    private GradeContract gradeChangerGrade;
    private RangerContract rangerContract = new RangerContract();
    private RangerContract rangerContractChangerGrade;
    private Promotion promotion = new Promotion();
    private Promotion promotionAffec;
    private Poste poste = new Poste(), posteAffec;
    private Specialite specialite = new Specialite();
//    private GradeContract gradeContract;
//    private RangerContract rangerContract;
//    private Promotion promotion;
//    private Poste poste;
    private Arrondissement arrondissement, arrondissementAffec;
    private Departement departement, departementAffec;
    private CategorieStructure categorieStructure, categorieStructureAffec;
    private SimpleDateFormat simpleDateFormat;
    private Affectation affectation, affectationAffec;
    private StructureAttache structureAttache, structureAttacheAffec;
    private List<Departement> listDepartement;
    private List<Arrondissement> listArrondissement;
    private List<Specialite> listSpecialite;
    private List<CategorieStructure> listCategorieStructure;
    private List<StructureAttache> listStructureAttache;
    private List<Poste> listPoste;
    private List<Affectation> listAffectations;
    private List<Promotion> listPromotions;
    private List<RangerContract> listRangerContracts;
    private List<GradeContract> listGradeContract;
    private List<AffectationPromotion> listAffectationsPromotions;
    private List<String> listInformationToDisplay, listInformationToDisplay1;
    private String dateNaissanceContract, dateNaissanceContractVers, dateEntreFoncPub, dateDebutGrade, dateDebutPoste, dateDebutPosteAffec, dateDebutAffec, dateRetraite, dateDebutGradeChangerGrade, dateCni;
    ;
    private long idGradeContract, idRangerContract, idStructure, idPoste, idDepartement, idArrondissement, idCategorieStructure, idSpecialite;
    // ces variable permettent de contrôler les colonnes à afficher dans le dataTable
    private boolean boolMat, boolNom = true, boolPrenom = true, boolNomJeunFille, boolDateSortie, boolDateNaiss, boolRegionNaiss, boolAge, boolDepartNaiss, boolArrondNaiss, boolLieuNaiss, boolDiplomeEntre, boolSexe, boolCni, boolRegOri, boolDepOri, boolArrOro, boolGrade, boolSpecial, boolDateRetraite, boolDateEntreeFoncPub, boolStrucAttach, boolPoste, boolDateAffec, boolArronStruct, boolDepartStruct, boolLieuCni, boolDateCni, boolTel;
    private boolean selectAll;

    public ContractuelBean() {
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

    public Promotion getPromotionAffec() {
        return promotionAffec;
    }

    public void setPromotionAffec(Promotion promotionAffec) {
        this.promotionAffec = promotionAffec;
    }

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
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

    public Contractuel getContractuel() {
        return contractuel;
    }

    public void setContractuel(Contractuel contractuel) {
        this.contractuel = contractuel;
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
        return iPosteService.findPosteByCategorieStructure(idCategorieStructure);
    }

    public void setListPoste(List<Poste> listPoste) {
        this.listPoste = listPoste;
    }

    public List<StructureAttache> getListStructureAttache() {
        return iStructureService.findStructureAttacheByCategorieAndArrondissement(idArrondissement, idCategorieStructure);
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

    public IStructureService getiStructureService() {
        return iStructureService;
    }

    public void setiStructureService(IStructureService iStructureService) {
        this.iStructureService = iStructureService;
    }

    public String getDateNaissanceContract() {
        return dateNaissanceContract;
    }

    public void setDateNaissanceContract(String dateNaissanceContract) {
        this.dateNaissanceContract = dateNaissanceContract;
    }

    public String getDateEntreFoncPub() {
        return dateEntreFoncPub;
    }

    public void setDateEntreFoncPub(String dateEntreFoncPub) {
        this.dateEntreFoncPub = dateEntreFoncPub;
    }

    public String getDateNaissanceContractVers() {
        return dateNaissanceContractVers;
    }

    public void setDateNaissanceContractVers(String dateNaissanceContractVers) {
        this.dateNaissanceContractVers = dateNaissanceContractVers;
    }

    public String getDateDebutGrade() {
        return dateDebutGrade;
    }

    public void setDateDebutGrade(String dateDebutGrade) {
        this.dateDebutGrade = dateDebutGrade;
    }

    public String getDateDebutPoste() {
        return dateDebutPoste;
    }

    public void setDateDebutPoste(String dateDebutPoste) {
        this.dateDebutPoste = dateDebutPoste;
    }

    public String getDateDebutPosteAffec() {
        return dateDebutPosteAffec;
    }

    public void setDateDebutPosteAffec(String dateDebutPosteAffec) {
        this.dateDebutPosteAffec = dateDebutPosteAffec;
    }

    public String getDateDebutAffec() {
        return dateDebutAffec;
    }

    public void setDateDebutAffec(String dateDebutAffec) {
        this.dateDebutAffec = dateDebutAffec;
    }

    public String getDateRetraite() {
        return dateRetraite;
    }

    public void setDateRetraite(String dateRetraite) {
        this.dateRetraite = dateRetraite;
    }
    
    public long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public long getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(long idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public long getIdCategorieStructure() {
        return idCategorieStructure;
    }

    public void setIdCategorieStructure(long idCategorieStructure) {
        this.idCategorieStructure = idCategorieStructure;
    }

    public List<Departement> getListDepartement() {
        return iDepartementService.findAllDepartement();
    }

    public void setListDepartement(List<Departement> listDepartement) {
        this.listDepartement = listDepartement;
    }

    public List<Arrondissement> getListArrondissement() {
        return iArrondissementService.findArrondissementByIdDepart(idDepartement);
    }

    public void setListArrondissement(List<Arrondissement> listArrondissement) {
        this.listArrondissement = listArrondissement;
    }

    public List<CategorieStructure> getListCategorieStructure() {
        return iCategorieStructureService.findAllCategorieStructure();
    }

    public void setListCategorieStructure(List<CategorieStructure> listCategorieStructure) {
        this.listCategorieStructure = listCategorieStructure;
    }

    public GradeContract getGradeChangerGrade() {
        return gradeChangerGrade;
    }

    public void setGradeChangerGrade(GradeContract gradeChangerGrade) {
        this.gradeChangerGrade = gradeChangerGrade;
    }

    public RangerContract getRangerContractChangerGrade() {
        return rangerContractChangerGrade;
    }

    public void setRangerContractChangerGrade(RangerContract rangerContractChangerGrade) {
        this.rangerContractChangerGrade = rangerContractChangerGrade;
    }

    public Affectation getAffectationAffec() {
        return affectationAffec;
    }

    public void setAffectationAffec(Affectation affectationAffec) {
        this.affectationAffec = affectationAffec;
    }

    public List<AffectationPromotion> getListAffectationsPromotions() {
        return listAffectationsPromotions;
    }

    public void setListAffectationsPromotions(List<AffectationPromotion> listAffectationsPromotions) {
        this.listAffectationsPromotions = listAffectationsPromotions;
    }

    public String getDateDebutGradeChangerGrade() {
        return dateDebutGradeChangerGrade;
    }

    public void setDateDebutGradeChangerGrade(String dateDebutGradeChangerGrade) {
        this.dateDebutGradeChangerGrade = dateDebutGradeChangerGrade;
    }

    public ISpecialiteService getiSpecialiteService() {
        return iSpecialiteService;
    }

    public void setiSpecialiteService(ISpecialiteService iSpecialiteService) {
        this.iSpecialiteService = iSpecialiteService;
    }

    public List<RangerContract> getListRangerContracts() {
        return listRangerContracts;
    }

    public void setListRangerContracts(List<RangerContract> listRangerContracts) {
        this.listRangerContracts = listRangerContracts;
    }

    public IDepartementService getiDepartementService() {
        return iDepartementService;
    }

    public void setiDepartementService(IDepartementService iDepartementService) {
        this.iDepartementService = iDepartementService;
    }

    public List<Specialite> getListSpecialite() {
        return iSpecialiteService.findAllSpecialite();
    }

    public void setListSpecialite(List<Specialite> listSpecialite) {
        this.listSpecialite = listSpecialite;
    }

    public long getIdSpecialite() {
        return idSpecialite;
    }

    public void setIdSpecialite(long idSpecialite) {
        this.idSpecialite = idSpecialite;
    }

    public IArrondissementService getiArrondissementService() {
        return iArrondissementService;
    }

    public void setiArrondissementService(IArrondissementService iArrondissementService) {
        this.iArrondissementService = iArrondissementService;
    }

    public ICategorieStructureService getiCategorieStructureService() {
        return iCategorieStructureService;
    }

    public void setiCategorieStructureService(ICategorieStructureService iCategorieStructureService) {
        this.iCategorieStructureService = iCategorieStructureService;
    }

    public Arrondissement getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(Arrondissement arrondissement) {
        this.arrondissement = arrondissement;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public CategorieStructure getCategorieStructure() {
        return categorieStructure;
    }

    public void setCategorieStructure(CategorieStructure categorieStructure) {
        this.categorieStructure = categorieStructure;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        ContractuelBean.logger = logger;
    }

    public String getDateCni() {
        return dateCni;
    }

    public void setDateCni(String dateCni) {
        this.dateCni = dateCni;
    }

    public boolean isBoolLieuCni() {
        return boolLieuCni;
    }

    public void setBoolLieuCni(boolean boolLieuCni) {
        this.boolLieuCni = boolLieuCni;
    }

    public boolean isBoolDateCni() {
        return boolDateCni;
    }

    public void setBoolDateCni(boolean boolDateCni) {
        this.boolDateCni = boolDateCni;
    }

    public boolean isBoolTel() {
        return boolTel;
    }

    public void setBoolTel(boolean boolTel) {
        this.boolTel = boolTel;
    }

    
    public boolean isBoolMat() {
        return boolMat;
    }

    public void setBoolMat(boolean boolMat) {
        this.boolMat = boolMat;
    }

    public boolean isBoolNom() {
        return boolNom;
    }

    public void setBoolNom(boolean boolNom) {
        this.boolNom = boolNom;
    }

    public boolean isBoolPrenom() {
        return boolPrenom;
    }

    public void setBoolPrenom(boolean boolPrenom) {
        this.boolPrenom = boolPrenom;
    }

    public boolean isBoolNomJeunFille() {
        return boolNomJeunFille;
    }

    public void setBoolNomJeunFille(boolean boolNomJeunFille) {
        this.boolNomJeunFille = boolNomJeunFille;
    }

    public boolean isBoolDateNaiss() {
        return boolDateNaiss;
    }

    public void setBoolDateNaiss(boolean boolDateNaiss) {
        this.boolDateNaiss = boolDateNaiss;
    }

    public boolean isBoolLieuNaiss() {
        return boolLieuNaiss;
    }

    public void setBoolLieuNaiss(boolean boolLieuNaiss) {
        this.boolLieuNaiss = boolLieuNaiss;
    }

    public boolean isBoolSexe() {
        return boolSexe;
    }

    public void setBoolSexe(boolean boolSexe) {
        this.boolSexe = boolSexe;
    }

    public boolean isBoolCni() {
        return boolCni;
    }

    public void setBoolCni(boolean boolCni) {
        this.boolCni = boolCni;
    }

    public boolean isBoolRegOri() {
        return boolRegOri;
    }

    public void setBoolRegOri(boolean boolRegOri) {
        this.boolRegOri = boolRegOri;
    }

    public boolean isBoolDateSortie() {
        return boolDateSortie;
    }

    public void setBoolDateSortie(boolean boolDateSortie) {
        this.boolDateSortie = boolDateSortie;
    }

    public boolean isBoolRegionNaiss() {
        return boolRegionNaiss;
    }

    public void setBoolRegionNaiss(boolean boolRegionNaiss) {
        this.boolRegionNaiss = boolRegionNaiss;
    }

    public boolean isBoolAge() {
        return boolAge;
    }

    public void setBoolAge(boolean boolAge) {
        this.boolAge = boolAge;
    }

    public boolean isBoolDepartNaiss() {
        return boolDepartNaiss;
    }

    public void setBoolDepartNaiss(boolean boolDepartNaiss) {
        this.boolDepartNaiss = boolDepartNaiss;
    }

    public boolean isBoolArrondNaiss() {
        return boolArrondNaiss;
    }

    public void setBoolArrondNaiss(boolean boolArrondNaiss) {
        this.boolArrondNaiss = boolArrondNaiss;
    }

    public boolean isBoolDiplomeEntre() {
        return boolDiplomeEntre;
    }

    public void setBoolDiplomeEntre(boolean boolDiplomeEntre) {
        this.boolDiplomeEntre = boolDiplomeEntre;
    }

    public boolean isBoolSpecial() {
        return boolSpecial;
    }

    public void setBoolSpecial(boolean boolSpecial) {
        this.boolSpecial = boolSpecial;
    }

    public boolean isBoolDepOri() {
        return boolDepOri;
    }

    public void setBoolDepOri(boolean boolDepOri) {
        this.boolDepOri = boolDepOri;
    }

    public boolean isBoolArrOro() {
        return boolArrOro;
    }

    public void setBoolArrOro(boolean boolArrOro) {
        this.boolArrOro = boolArrOro;
    }

    public boolean isBoolGrade() {
        return boolGrade;
    }

    public void setBoolGrade(boolean boolGrade) {
        this.boolGrade = boolGrade;
    }

    public boolean isBoolDateRetraite() {
        return boolDateRetraite;
    }

    public List<String> getListInformationToDisplay1() {
        return listInformationToDisplay1;
    }

    public void setListInformationToDisplay1(List<String> listInformationToDisplay1) {
        this.listInformationToDisplay1 = listInformationToDisplay1;
    }

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public void setBoolDateRetraite(boolean boolDateRetraite) {
        this.boolDateRetraite = boolDateRetraite;
    }

    public boolean isBoolDateEntreeFoncPub() {
        return boolDateEntreeFoncPub;
    }

    public void setBoolDateEntreeFoncPub(boolean boolDateEntreeFoncPub) {
        this.boolDateEntreeFoncPub = boolDateEntreeFoncPub;
    }

    public boolean isBoolStrucAttach() {
        return boolStrucAttach;
    }

    public void setBoolStrucAttach(boolean boolStrucAttach) {
        this.boolStrucAttach = boolStrucAttach;
    }

    public boolean isBoolPoste() {
        return boolPoste;
    }

    public void setBoolPoste(boolean boolPoste) {
        this.boolPoste = boolPoste;
    }

    public boolean isBoolDateAffec() {
        return boolDateAffec;
    }

    public void setBoolDateAffec(boolean boolDateAffec) {
        this.boolDateAffec = boolDateAffec;
    }

    public boolean isBoolArronStruct() {
        return boolArronStruct;
    }

    public void setBoolArronStruct(boolean boolArronStruct) {
        this.boolArronStruct = boolArronStruct;
    }

    public boolean isBoolDepartStruct() {
        return boolDepartStruct;
    }

    public void setBoolDepartStruct(boolean boolDepartStruct) {
        this.boolDepartStruct = boolDepartStruct;
    }

    public List<String> getListInformationToDisplay() {
        return listInformationToDisplay;
    }

    public void setListInformationToDisplay(List<String> listInformationToDisplay) {
        this.listInformationToDisplay = listInformationToDisplay;
    }

    public Poste getPosteAffec() {
        return posteAffec;
    }

    public void setPosteAffec(Poste posteAffec) {
        this.posteAffec = posteAffec;
    }

    public List<Affectation> getListAffectations() {
        return listAffectations;
    }

    public void setListAffectations(List<Affectation> listAffectations) {
        this.listAffectations = listAffectations;
    }

    public List<Promotion> getListPromotions() {
        return listPromotions;
    }

    public void setListPromotions(List<Promotion> listPromotions) {
        this.listPromotions = listPromotions;
    }

    public Arrondissement getArrondissementAffec() {
        return arrondissementAffec;
    }

    public void setArrondissementAffec(Arrondissement arrondissementAffec) {
        this.arrondissementAffec = arrondissementAffec;
    }

    public Departement getDepartementAffec() {
        return departementAffec;
    }

    public void setDepartementAffec(Departement departementAffec) {
        this.departementAffec = departementAffec;
    }

    public CategorieStructure getCategorieStructureAffec() {
        return categorieStructureAffec;
    }

    public void setCategorieStructureAffec(CategorieStructure categorieStructureAffec) {
        this.categorieStructureAffec = categorieStructureAffec;
    }

    public StructureAttache getStructureAttacheAffec() {
        return structureAttacheAffec;
    }

    public void setStructureAttacheAffec(StructureAttache structureAttacheAffec) {
        this.structureAttacheAffec = structureAttacheAffec;
    }


    /*
    ces méthodes ont pour rôle de construire tous les agents dans leur situation courrante ie. avec leur poste courrant leur structure d'attache courrante le grade courant.
     */
    public Poste currentPoste(Agentp agent) {
        return (iPromotionService.findPromotionOpenByIdAgent(agent.getId())).getPoste();
    }

    public StructureAttache currentStructureAttache(Agentp agent) {
        return (iAffectationService.findAffectationOpenByIdAgent(agent.getId())).getStructureAttache();
    }

    public String currentGradeContract(Agentp agent) {
        return (iRangerContractService.findRangerContractOpenByIdAgent(agent.getId())).getGradeContract().getIntituleGradeContract();
    }

    public String currentDateNaissance(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (!agent.isIsBornArround()) {
            String dateNaissance = simpleDateFormat.format(agent.getDateNaissance());
            return dateNaissance;
        } else {
            int annee = agent.getDateNaissance().getYear();
            return "vers 19" + annee;
        }
    }

    public int currentAgeContract(Agentp agent) {
        Date currentDate = new Date();
        int age = currentDate.getYear() - agent.getDateNaissance().getYear();
        if (currentDate.getMonth() < agent.getDateNaissance().getMonth() && !agent.isIsBornArround()) {
            return age - 1;
        }
        return age;
    }

    public String currentDateEntreeFonctionPub(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateEntreeFonctionPub = simpleDateFormat.format(agent.getDateEntreFonctionPub());
        int nombreAnneeService = (new Date()).getYear() - agent.getDateEntreFonctionPub().getYear();
        if (agent.isIsRetraite()) {
            return dateEntreeFonctionPub;
        }
        return dateEntreeFonctionPub + "(" + nombreAnneeService + ")";
    }

    public String currentDateAffect(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Affectation affect = iAffectationService.findAffectationOpenByIdAgent(agent.getId());
        String dateEntreePoste = simpleDateFormat.format((affect).getDateDebutAffect());
        int anciennetePoste = (new Date()).getYear() - (affect).getDateDebutAffect().getYear();
        return dateEntreePoste + "(" + anciennetePoste + ")";
    }
    public String currentDateCni(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(agent.getDateDelivranceCni());
    }

    public String currentDateDepartRetraite(Contractuel agent) throws Exception {
        try {
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDateFormat.format(iAffectationService.findLastAffectationByIdAgent(agent.getId()).getDateFinAffect());
        } catch (Exception e) {
            throw e;
        }
    }

    public Arrondissement currentArrondissement(Agentp agent) {
        return currentStructureAttache(agent).getArrondissement();
    }

    public Departement currentDepartement(Agentp agent) {
        return currentArrondissement(agent).getDepartement();
    }

    /*
    fin du bloc de construction des agents dans leur situation courante. début des méthode permettant d'avoir un tableau dynamique
     */
    public void initListColumn() {
        boolMat = false;
        boolNom = false;
        boolPrenom = false;
        boolNomJeunFille = false;
        boolDateNaiss = false;
        boolDateNaiss = false;
        boolLieuNaiss = false;
        boolTel = false;
        boolLieuCni = false;
        boolDateCni = false;
        boolSexe = false;
        boolCni = false;
        boolRegOri = false;
        boolDepOri = false;
        boolArrOro = false;
        boolGrade = false;
        boolSpecial = false;
        boolDateRetraite = false;
        boolDateSortie = false;
        boolDateEntreeFoncPub = false;
        boolStrucAttach = false;
        boolPoste = false;
        boolDateAffec = false;
        boolArronStruct = false;
        boolDepartStruct = false;
        boolArrondNaiss = false;
        boolDepartNaiss = false;
        boolRegionNaiss = false;
        boolAge = false;
        boolDiplomeEntre = false;
        listInformationToDisplay = new ArrayList<>();
        listInformationToDisplay1 = new ArrayList<>();
    }

    public void selectAllMethod() {
        if (selectAll) {
            listInformationToDisplay.add("matricule");
            listInformationToDisplay.add("nom");
            listInformationToDisplay.add("prenom");
            listInformationToDisplay.add("nomjeunefille");
            listInformationToDisplay.add("datenaissance");
            listInformationToDisplay.add("lieunaissance");
            listInformationToDisplay.add("regionnaissance");
            listInformationToDisplay.add("departnaissance");
            listInformationToDisplay.add("arrondnaissance");
            listInformationToDisplay.add("regionorigine");
            listInformationToDisplay.add("departementorigine");
            listInformationToDisplay.add("arrondissementorigine");
            listInformationToDisplay.add("age");
            listInformationToDisplay.add("sexe");
            
            listInformationToDisplay1.add("sexe");
            listInformationToDisplay1.add("numerocni");
            listInformationToDisplay1.add("grade");
            listInformationToDisplay1.add("specialite");
            listInformationToDisplay1.add("diplomefoncpub");
            listInformationToDisplay1.add("dateentreefoncpub");
            listInformationToDisplay1.add("structureattache");
            listInformationToDisplay1.add("poste");
            listInformationToDisplay1.add("ancienneteposte");
            listInformationToDisplay1.add("departstructureattache");
            listInformationToDisplay1.add("arrondstructureattache");
            listInformationToDisplay1.add("dateretraite");
            listInformationToDisplay1.add("datesortieregion");
            listInformationToDisplay1.add("numtel");
            listInformationToDisplay1.add("datecni");
            listInformationToDisplay1.add("lieucni");
        } else {
            listInformationToDisplay.clear();
            listInformationToDisplay1.clear();
        }
    }

    public void selectAllCancel() {
        selectAll = false;
    }

    public void createDynamicColumns() {
        listInformationToDisplay.addAll(listInformationToDisplay1);
        for (String column : listInformationToDisplay) {
            switch (column) {
                case "matricule":
                    boolMat = true;
                    break;
                case "nom":
                    boolNom = true;
                    break;
                case "prenom":
                    boolPrenom = true;
                    break;
                case "nomjeunefille":
                    boolNomJeunFille = true;
                    break;
                case "datenaissance":
                    boolDateNaiss = true;
                    break;
                case "lieunaissance":
                    boolLieuNaiss = true;
                    break;
                case "sexe":
                    boolSexe = true;
                    break;
                case "numerocni":
                    boolCni = true;
                    break;
                case "regionorigine":
                    boolRegOri = true;
                    break;
                case "departementorigine":
                    boolDepOri = true;
                    break;
                case "arrondissementorigine":
                    boolArrOro = true;
                    break;
                case "grade":
                    boolGrade = true;
                    break;
                case "specialite":
                    boolSpecial = true;
                    break;
                case "dateentreefoncpub":
                    boolDateEntreeFoncPub = true;
                    break;
                case "dateretraite":
                    boolDateRetraite = true;
                    break;
                case "datesortieregion":
                    boolDateSortie = true;
                    break;
                case "structureattache":
                    boolStrucAttach = true;
                    break;
                case "poste":
                    boolPoste = true;
                    break;
                case "ancienneteposte":
                    boolDateAffec = true;
                    break;
                case "arrondstructureattache":
                    boolArronStruct = true;
                    break;
                case "departstructureattache":
                    boolDepartStruct = true;
                    break;
                case "regionnaissance":
                    boolRegionNaiss = true;
                    break;
                case "departnaissance":
                    boolDepartNaiss = true;
                    break;
                case "arrondnaissance":
                    boolArrondNaiss = true;
                    break;
                case "diplomefoncpub":
                    boolDiplomeEntre = true;
                    break;
                case "age":
                    boolAge = true;
                    break;
                case "numtel":
                    boolTel = true;
                    break;
                case "datecni":
                    boolDateCni = true;
                    break;
                case "lieucni":
                    boolLieuCni = true;
                default:
                    break;

            }
        }
    }

    //this is to initialize the various element an display them before confirmation
    public void beforeConfirm() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        specialite = iSpecialiteService.findSpecialiteById(idSpecialite);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        poste = iPosteService.findPosteById(idPoste);
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        departement = iDepartementService.findDepartementById(idDepartement);
        categorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        if (!contractuel.isIsBornArround()) {
            contractuel.setDateNaissance(simpleDateFormat.parse(dateNaissanceContract));
        } else {
            contractuel.setDateNaissance(simpleDateFormat.parse("31/12/" + dateNaissanceContractVers));
            dateNaissanceContract = "vers " + dateNaissanceContractVers;
        }
        contractuel.setDateEntreFonctionPub(simpleDateFormat.parse(dateEntreFoncPub));
        promotion.setDateDebutPromo(simpleDateFormat.parse(dateDebutPoste));
        affectation.setDateDebutAffect(simpleDateFormat.parse(dateDebutPoste));
        rangerContract.setDateDebutRangerContract(simpleDateFormat.parse(dateDebutGrade));
        dateCni = simpleDateFormat.format(contractuel.getDateDelivranceCni());
    }

    /*
    this is aim to initialize the oneMenu to nothing before updating
     */
    public void beforeUpdateContract() {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        idSpecialite = contractuel.getSpecialite().getId();
        rangerContract = iRangerContractService.findRangerContractOpenByIdAgent(contractuel.getId());
        gradeContract = rangerContract.getGradeContract();
        idGradeContract = gradeContract.getId();
        if (!contractuel.isIsBornArround()) {
            dateNaissanceContract = simpleDateFormat.format(contractuel.getDateNaissance());
            dateNaissanceContractVers = "";
        } else {
            dateNaissanceContract = "";
            dateNaissanceContractVers = "19" + contractuel.getDateNaissance().getYear();
        }
        dateEntreFoncPub = simpleDateFormat.format(contractuel.getDateEntreFonctionPub());
        dateDebutGrade = simpleDateFormat.format(rangerContract.getDateDebutRangerContract());
        affectation = iAffectationService.findAffectationOpenByIdAgent(contractuel.getId());
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());
        structureAttache = affectation.getStructureAttache();
        idStructure = structureAttache.getId();
        arrondissement = structureAttache.getArrondissement();
        idArrondissement = arrondissement.getId();
        departement = arrondissement.getDepartement();
        idDepartement = departement.getId();
        categorieStructure = structureAttache.getCategorieStructure();
        idCategorieStructure = categorieStructure.getId();
        promotion = iPromotionService.findPromotionOpenByIdAgent(contractuel.getId());
        poste = promotion.getPoste();
        idPoste = poste.getId();
        dateCni = simpleDateFormat.format(contractuel.getDateDelivranceCni());
    }

    public void beforeConfirmAffect() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        affectation = iAffectationService.findAffectationOpenByIdAgent(contractuel.getId());
        structureAttache = affectation.getStructureAttache();
        arrondissement = structureAttache.getArrondissement();
        departement = arrondissement.getDepartement();
        categorieStructure = structureAttache.getCategorieStructure();
        promotion = iPromotionService.findPromotionOpenByIdAgent(contractuel.getId());
        poste = promotion.getPoste();
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());

        promotionAffec = new Promotion();
        affectationAffec = new Affectation();
        structureAttacheAffec = iStructureService.findStructureAttacheById(idStructure);
        posteAffec = iPosteService.findPosteById(idPoste);
        arrondissementAffec = iArrondissementService.findArrondissementById(idArrondissement);
        departementAffec = iDepartementService.findDepartementById(idDepartement);
        categorieStructureAffec = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        promotionAffec.setDateDebutPromo(simpleDateFormat.parse(dateDebutPosteAffec));
        affectationAffec.setDateDebutAffect(simpleDateFormat.parse(dateDebutPosteAffec));
    }

    public void beforeConfirmChangeGrade() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        rangerContract = iRangerContractService.findRangerContractOpenByIdAgent(contractuel.getId());
        gradeContract = rangerContract.getGradeContract();
        dateDebutGrade = simpleDateFormat.format(rangerContract.getDateDebutRangerContract());

        rangerContractChangerGrade = new RangerContract();
        gradeChangerGrade = iGradeContractService.findGradeContractById(idGradeContract);
        rangerContractChangerGrade.setDateDebutRangerContract(simpleDateFormat.parse(dateDebutGradeChangerGrade));
    }

    public void beforeChangerGrade() throws ParseException {
        rangerContract = null;
        gradeContract = null;
        dateDebutGrade = "";

        idGradeContract = 0L;
    }

    // pour le retour d'un contractuel dans la région
    public void beforeConfirmRetourContract() throws ParseException {
        promotionAffec = new Promotion();
        affectationAffec = new Affectation();
        structureAttacheAffec = iStructureService.findStructureAttacheById(idStructure);
        posteAffec = iPosteService.findPosteById(idPoste);
        arrondissementAffec = iArrondissementService.findArrondissementById(idArrondissement);
        departementAffec = iDepartementService.findDepartementById(idDepartement);
        categorieStructureAffec = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        promotionAffec.setDateDebutPromo(simpleDateFormat.parse(dateDebutPosteAffec));
        affectationAffec.setDateDebutAffect(simpleDateFormat.parse(dateDebutPosteAffec));
    }

    public void beforeConfirmRetraite() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        affectation = iAffectationService.findAffectationOpenByIdAgent(contractuel.getId());
        structureAttache = affectation.getStructureAttache();
        arrondissement = structureAttache.getArrondissement();
        departement = arrondissement.getDepartement();
        promotion = iPromotionService.findPromotionOpenByIdAgent(contractuel.getId());
        poste = promotion.getPoste();
        affectation.setDateFinAffect(simpleDateFormat.parse(dateRetraite));
        promotion.setDateFinPromo(simpleDateFormat.parse(dateRetraite));
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());
        if (!contractuel.isIsBornArround()) {
            dateNaissanceContract = simpleDateFormat.format(contractuel.getDateNaissance());
        } else {
            dateNaissanceContract = "vers 19" + contractuel.getDateNaissance().getYear();
        }

    }

    public void beforeDisplayProfil() {
        listAffectations = iAffectationService.findAffectationByIdAgent(contractuel.getId());
        listPromotions = iPromotionService.findPromotionByIdAgent(contractuel.getId());
        listRangerContracts = iRangerContractService.findRangerContractByIdAgent(contractuel.getId());
        listAffectationsPromotions = new ArrayList<>();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (!contractuel.isIsBornArround()) {
            dateNaissanceContract = simpleDateFormat.format(contractuel.getDateNaissance());
        } else {
            dateNaissanceContract = "vers 19" + contractuel.getDateNaissance().getYear();
        }

        for (int i = 0; i < listPromotions.size(); i++) {
            AffectationPromotion ap = new AffectationPromotion();
            ap.setA(listAffectations.get(i));
            ap.setP(listPromotions.get(i));
            listAffectationsPromotions.add(ap);
        }
    }
    

    public void beforeRestauration() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        affectation = iAffectationService.findLastAffectationByIdAgent(contractuel.getId());
        structureAttache = affectation.getStructureAttache();
        arrondissement = structureAttache.getArrondissement();
        departement = arrondissement.getDepartement();
        promotion = iPromotionService.findLastPromotionByIdAgent(contractuel.getId());
        poste = promotion.getPoste();
        affectation.setDateFinAffect(null);
        promotion.setDateFinPromo(null);
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());
        if (!contractuel.isIsBornArround()) {
            dateNaissanceContract = simpleDateFormat.format(contractuel.getDateNaissance());
        } else {
            dateNaissanceContract = "vers 19" + contractuel.getDateNaissance().getYear();
        }

    }

    public String onFlowProcessAjouter(FlowEvent event) throws ParseException {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        //  event.setPhaseId(PhaseId.phaseIdValueOf("personnel"));

        if (event.getNewStep().equals("confirmationTab")) {
            beforeConfirm();
            return "confirmationTab";
        } else {
            return event.getNewStep();
        }
    }

    public String onFlowProcessAffectation(FlowEvent event) throws ParseException {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        //  event.setPhaseId(PhaseId.phaseIdValueOf("personnel"));

        if (event.getNewStep().equals("confirmationTabAffect")) {
            beforeConfirmAffect();
            return "confirmationTabAffect";
        } else {
            return event.getNewStep();
        }
    }

    public String onFlowProcessChangerGrade(FlowEvent event) throws ParseException {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        //  event.setPhaseId(PhaseId.phaseIdValueOf("personnel"));

        if (event.getNewStep().equals("confirmationTabChangerGrade")) {
            beforeConfirmChangeGrade();
            return "confirmationTabChangerGrade";
        } else {
            return event.getNewStep();
        }
    }

    public String onFlowProcessRetraite(FlowEvent event) throws ParseException {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        //  event.setPhaseId(PhaseId.phaseIdValueOf("personnel"));

        if (event.getNewStep().equals("confirmationRetraite")) {
            beforeConfirmRetraite();
            return "confirmationRetraite";
        } else {
            return event.getNewStep();
        }
    }

    public String onFlowProcessRetourContract(FlowEvent event) throws ParseException {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        //  event.setPhaseId(PhaseId.phaseIdValueOf("personnel"));

        if (event.getNewStep().equals("confirmationTabAffect")) {
            beforeConfirmRetourContract();
            return "confirmationTabAffect";
        } else {
            return event.getNewStep();
        }
    }

    public List<Sexe> sexes() {
        List<Sexe> listSexe = new ArrayList<>();
        listSexe.addAll(Arrays.asList(Sexe.values()));
        return listSexe;
    }
 public List ages(){
        List listAges = new ArrayList();
        listAges.add(45);
        listAges.add(50);
        listAges.add(55);
        listAges.add(60);
        listAges.add(65);
        return listAges;
    }
    /*
    fin du bloc de construction des agents dans leur situation courante. début des méthode permettant d'avoir un tableau dynamique
     */
 /*
    this is to reinitialize the entity contractuel before creating another
     */
    public void initContract() {
        idDepartement = 0L;
        idGradeContract = 0L;
        idDepartement = 0L;
        idArrondissement = 0L;
        idCategorieStructure = 0L;
        idStructure = 0L;
        idSpecialite = 0L;
        idPoste = 0L;
        promotion = new Promotion();
        affectation = new Affectation();
        rangerContract = new RangerContract();
        contractuel = null;
        contractuel = new Contractuel();
        contractuel.setIsRetraite(false);
        contractuel.setIsBornArround(false);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateNaissanceContract = "";
        dateNaissanceContractVers = "";
        dateEntreFoncPub = "";
        dateDebutGrade = "";
        dateDebutAffec = "";
        dateDebutPoste = "";
        dateCni = "";
    }

    public Contractuel createContractuel() {
        try {
            contractuel.setSpecialite(specialite);
            iContractuelService.createContractuel(contractuel);

            affectation.setAgent(contractuel);
            affectation.setStructureAttache(structureAttache);
            iAffectationService.createAffectation(affectation);

            promotion.setAgent(contractuel);
            promotion.setPoste(poste);
            iPromotionService.createPromotion(promotion);

            rangerContract.setContratuel(contractuel);
            rangerContract.setGradeContract(gradeContract);
            iRangerContractService.createRangerContract(rangerContract);

            return contractuel;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec d'enregitrement vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Contractuel findContractuelById() {
        return iContractuelService.findContractuelById(contractuel.getId());
    }

    public Contractuel updateContractuel() throws Exception {
        try {
            specialite = iSpecialiteService.findSpecialiteById(idSpecialite);
            contractuel.setSpecialite(specialite);

            affectation.setStructureAttache(structureAttache);
            affectation.setDateDebutAffect(simpleDateFormat.parse(dateDebutPoste));
            iAffectationService.updateAffectation(affectation);

            rangerContract.setGradeContract(gradeContract);
            rangerContract.setDateDebutRangerContract(simpleDateFormat.parse(dateDebutGrade));
            iRangerContractService.updateRangerContract(rangerContract);

            promotion.setPoste(poste);
            promotion.setDateDebutPromo(simpleDateFormat.parse(dateDebutPoste));
            iPromotionService.updatePromotion(promotion);

            return iContractuelService.updateContractuel(contractuel);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec de modification vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Contractuel> findAllContractuel() {
        return iContractuelService.findAllContractuel();
    }

    public List<Contractuel> findContractuelsActifs() {
        return iContractuelService.findContractuelActif();
    }

    public List<Contractuel> findContractuelsRetraites() {
        return iContractuelService.findContractuelRetraites();
    }

    public List<Contractuel> findContractuelsSortis() {
        List<Contractuel> listAllContractuels = iContractuelService.findAllContractuel();
        listAllContractuels.removeAll(iContractuelService.findContractuelActif());
        listAllContractuels.removeAll(iContractuelService.findContractuelRetraites());
        return listAllContractuels;
    }

    public Contractuel retraite() {
        contractuel.setIsRetraite(true);
        iAffectationService.updateAffectation(affectation);
        iPromotionService.updatePromotion(promotion);
        return iContractuelService.updateContractuel(contractuel);
    }

    public Contractuel sortieRegion() {
        iAffectationService.updateAffectation(affectation);
        iPromotionService.updatePromotion(promotion);
        return iContractuelService.updateContractuel(contractuel);
    }

    public Contractuel restaureRetraite() {
        contractuel.setIsRetraite(false);
        iAffectationService.updateAffectation(affectation);
        iPromotionService.updatePromotion(promotion);
        return iContractuelService.updateContractuel(contractuel);
    }

    public void affecterContractuel() {
        try {
            affectationAffec.setAgent(contractuel);
            affectationAffec.setStructureAttache(structureAttacheAffec);
            promotionAffec.setAgent(contractuel);
            promotionAffec.setPoste(posteAffec);
            iAffectationService.createAffectation(affectationAffec);
            iPromotionService.createPromotion(promotionAffec);
            affectation.setDateFinAffect(affectationAffec.getDateDebutAffect());
            promotion.setDateFinPromo(promotionAffec.getDateDebutPromo());
            iAffectationService.updateAffectation(affectation);
            iPromotionService.updatePromotion(promotion);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec d'affectation, vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }
    public void retourContractuel() {
        try {
            affectationAffec.setAgent(contractuel);
            affectationAffec.setStructureAttache(structureAttacheAffec);
            promotionAffec.setAgent(contractuel);
            promotionAffec.setPoste(posteAffec);
            iAffectationService.createAffectation(affectationAffec);
            iPromotionService.createPromotion(promotionAffec);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec d'affectation vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }
}
