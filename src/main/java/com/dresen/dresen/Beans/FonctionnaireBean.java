/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.ServiceInterface.IArrondissementService;
import com.dresen.dresen.ServiceInterface.ICadreService;
import com.dresen.dresen.ServiceInterface.ICategorieStructureService;
import com.dresen.dresen.ServiceInterface.ICorpsService;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.ServiceInterface.IRangerFonctioService;
import com.dresen.dresen.ServiceInterface.ISpecialiteService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Affectation;
import com.dresen.dresen.entities.AffectationPromotion;
import com.dresen.dresen.entities.Agentp;
import com.dresen.dresen.entities.Arrondissement;
import com.dresen.dresen.entities.Cadre;
import com.dresen.dresen.entities.CategorieStructure;
import com.dresen.dresen.entities.Corps;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.Fonctionnaire;
import com.dresen.dresen.entities.GradeFonctio;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.Promotion;
import com.dresen.dresen.entities.RangerFonctio;
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
public class FonctionnaireBean implements Serializable {

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
    @ManagedProperty(value = "#{ISpecialiteService}")
    private ISpecialiteService iSpecialiteService;
    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;
    @ManagedProperty(value = "#{ICadreService}")
    private ICadreService iCadreService;
    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService iDepartementService;
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;

    private Fonctionnaire fonctionnaire = new Fonctionnaire();
    private GradeFonctio gradeFonctio = new GradeFonctio();
    private RangerFonctio rangerFonctio = new RangerFonctio();
    private Promotion promotion = new Promotion();
    private Promotion promotionAffec;
    private Poste poste = new Poste();
    private Specialite specialite = new Specialite();

    private Affectation affectation = new Affectation();
    private Affectation affectationAffec;
    private StructureAttache structureAttache = new StructureAttache();
    private boolean selectAll;
    private static Logger logger = Logger.getLogger(FonctionnaireBean.class.getName());
    // ces variable permettent de contrôler les colonnes à afficher dans le dataTable
    private boolean boolMat, boolNom = true, boolPrenom = true, boolNomJeunFille, boolDateSortie, boolDateNaiss, boolRegionNaiss, boolAge, boolDepartNaiss, boolArrondNaiss, boolCadre, boolCorps, boolLieuNaiss, boolDiplomeEntre, boolSexe, boolCni, boolRegOri, boolDepOri, boolArrOro, boolGrade, boolSpecial, boolDateRetraite, boolDateEntreeFoncPub, boolStrucAttach, boolPoste, boolDateAffec, boolArronStruct, boolDepartStruct, boolNotif, boolLieuCni, boolDateCni, boolTel;
    private List<Corps> listCorps;
    private List<Cadre> listCadre;
    private List<Fonctionnaire> listFonctionnaires;
    private List<Fonctionnaire> listFonctioRetraiteMensuel;
    private List<GradeFonctio> listGradeFonctio;
    private List<Specialite> listSpecialite;
    private List<Departement> listDepartement;
    private List<Arrondissement> listArrondissement;
    private List<CategorieStructure> listCategorieStructure;
    private List<StructureAttache> listStructureAttache;
    private List<Poste> listPoste;
    private List<RangerFonctio> listRangerFonctios;
    private List<Promotion> listPromotions;
    private List<AffectationPromotion> listAffectationsPromotions;
    private List<Affectation> listAffectations;
    private List<String> listInformationToDisplay, listInformationToDisplay1;
    private long idGradeFonctio, idRangerFonctio, idStructure, idPoste, idSpecialite, idCorps, idCadre, idDepartement, idArrondissement, idCategorieStructure;
    private long ageFonctionnaire;
    private Cadre cadre;
    private Corps corps;
    private Arrondissement arrondissement;
    private Departement departement;
    private CategorieStructure categorieStructure;
    private SimpleDateFormat simpleDateFormat;
    private String dateNaissanceFonc, dateNaissanceFoncVers, dateEntreFoncPub, dateDebutGrade, dateDebutPoste, dateDebutPosteAffec, dateDebutAffec, dateRetraite, dateDebutGradeChangerGrade, dateCni;
    private StructureAttache structureAttacheAffec;
    private Poste posteAffec;
    private Arrondissement arrondissementAffec;
    private Departement departementAffec;
    private CategorieStructure categorieStructureAffec;
    private RangerFonctio rangerFonctioChangerGrade;
    private Corps corpsChangerGrade;
    private Cadre cadreChangerGrade;
    private GradeFonctio gradeChangerGrade;

    public FonctionnaireBean() {
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
        return iGradeFonctioService.findGradeFonctioByIdCadre(idCadre);
    }

    public void setListGradeFonctio(List<GradeFonctio> listGradeFonctio) {
        this.listGradeFonctio = listGradeFonctio;
    }

    public long getIdGradeFonctio() {
        return idGradeFonctio;
    }

    public void setIdGradeFonctio(long idGradeFonctio) {
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

    public long getIdCadre() {
        return idCadre;
    }

    public void setIdCadre(long idCadre) {
        this.idCadre = idCadre;
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

    public long getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(long idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public List<StructureAttache> getListStructureAttache() {
        return iStructureService.findStructureAttacheByCategorieAndArrondissement(idArrondissement, idCategorieStructure);
    }

    public List<RangerFonctio> getListRangerFonctios() {
        return listRangerFonctios;
    }

    public void setListRangerFonctios(List<RangerFonctio> listRangerFonctios) {
        this.listRangerFonctios = listRangerFonctios;
    }

    public List<Promotion> getListPromotions() {
        return listPromotions;
    }

    public void setListPromotions(List<Promotion> listPromotions) {
        this.listPromotions = listPromotions;
    }

    public List<Affectation> getListAffectations() {
        return listAffectations;
    }

    public void setListAffectations(List<Affectation> listAffectations) {
        this.listAffectations = listAffectations;
    }

    public List<AffectationPromotion> getListAffectationsPromotions() {
        return listAffectationsPromotions;
    }

    public void setListAffectationsPromotions(List<AffectationPromotion> listAffectationsPromotions) {
        this.listAffectationsPromotions = listAffectationsPromotions;
    }

    public boolean isSelectAll() {
        return selectAll;
    }

    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        FonctionnaireBean.logger = logger;
    }

    public Cadre getCadre() {
        return cadre;
    }

    public void setCadre(Cadre cadre) {
        this.cadre = cadre;
    }

    public Corps getCorps() {
        return corps;
    }

    public void setCorps(Corps corps) {
        this.corps = corps;
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

    public Specialite getSpecialite() {
        return specialite;
    }

    public void setSpecialite(Specialite specialite) {
        this.specialite = specialite;
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

    public IDepartementService getiDepartementService() {
        return iDepartementService;
    }

    public List<Fonctionnaire> getListFonctioRetraiteMensuel() {
        return listFonctioRetraiteMensuel;
    }

    public void setListFonctioRetraiteMensuel(List<Fonctionnaire> listFonctioRetraiteMensuel) {
        this.listFonctioRetraiteMensuel = listFonctioRetraiteMensuel;
    }

    public void setiDepartementService(IDepartementService iDepartementService) {
        this.iDepartementService = iDepartementService;
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

    public long getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public long getIdCategorieStructure() {
        return idCategorieStructure;
    }

    public void setIdCategorieStructure(long idCategorieStructure) {
        this.idCategorieStructure = idCategorieStructure;
    }

    public IStructureService getiStructureService() {
        return iStructureService;
    }

    public void setiStructureService(IStructureService iStructureService) {
        this.iStructureService = iStructureService;
    }

    public ISpecialiteService getiSpecialiteService() {
        return iSpecialiteService;
    }

    public void setiSpecialiteService(ISpecialiteService iSpecialiteService) {
        this.iSpecialiteService = iSpecialiteService;
    }

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public ICadreService getiCadreService() {
        return iCadreService;
    }

    public void setiCadreService(ICadreService iCadreService) {
        this.iCadreService = iCadreService;
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

    public List<Cadre> getListCadre() {
        return iCadreService.findCadreByIdCorps(idCorps);
    }

    public void setListCadre(List<Cadre> listCadre) {
        this.listCadre = listCadre;
    }

    public long getIdPoste() {
        return idPoste;
    }

    public void setIdPoste(long idPoste) {
        this.idPoste = idPoste;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public String getDateNaissanceFonc() {
        return dateNaissanceFonc;
    }

    public void setDateNaissanceFonc(String dateNaissanceFonc) {
        this.dateNaissanceFonc = dateNaissanceFonc;
    }

    public String getDateNaissanceFoncVers() {
        return dateNaissanceFoncVers;
    }

    public void setDateNaissanceFoncVers(String dateNaissanceFoncVers) {
        this.dateNaissanceFoncVers = dateNaissanceFoncVers;
    }

    public String getDateEntreFoncPub() {
        return dateEntreFoncPub;
    }

    public void setDateEntreFoncPub(String dateEntreFoncPub) {
        this.dateEntreFoncPub = dateEntreFoncPub;
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

    public String getDateDebutAffec() {
        return dateDebutAffec;
    }

    public void setDateDebutAffec(String dateDebutAffec) {
        this.dateDebutAffec = dateDebutAffec;
    }

    public List<Fonctionnaire> getListFonctionnaires() {
        return listFonctionnaires;
    }

    public void setListFonctionnaires(List<Fonctionnaire> listFonctionnaires) {
        this.listFonctionnaires = listFonctionnaires;
    }

    public List<String> getListInformationToDisplay() {
        return listInformationToDisplay;
    }

    public void setListInformationToDisplay(List<String> listInformationToDisplay) {
        this.listInformationToDisplay = listInformationToDisplay;
    }

    public List<String> getListInformationToDisplay1() {
        return listInformationToDisplay1;
    }

    public void setListInformationToDisplay1(List<String> listInformationToDisplay1) {
        this.listInformationToDisplay1 = listInformationToDisplay1;
    }

    public Promotion getPromotionAffec() {
        return promotionAffec;
    }

    public void setPromotionAffec(Promotion promotionAffec) {
        this.promotionAffec = promotionAffec;
    }

    public Affectation getAffectationAffec() {
        return affectationAffec;
    }

    public void setAffectationAffec(Affectation affectationAffec) {
        this.affectationAffec = affectationAffec;
    }

    public String getDateDebutPosteAffec() {
        return dateDebutPosteAffec;
    }

    public void setDateDebutPosteAffec(String dateDebutPosteAffec) {
        this.dateDebutPosteAffec = dateDebutPosteAffec;
    }

    public String getDateCni() {
        return dateCni;
    }

    public void setDateCni(String dateCni) {
        this.dateCni = dateCni;
    }

    public String getDateRetraite() {
        return dateRetraite;
    }

    public void setDateRetraite(String dateRetraite) {
        this.dateRetraite = dateRetraite;
    }

    public StructureAttache getStructureAttacheAffec() {
        return structureAttacheAffec;
    }

    public void setStructureAttacheAffec(StructureAttache structureAttacheAffec) {
        this.structureAttacheAffec = structureAttacheAffec;
    }

    public Poste getPosteAffec() {
        return posteAffec;
    }

    public void setPosteAffec(Poste posteAffec) {
        this.posteAffec = posteAffec;
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

    public long getAgeFonctionnaire() {
        return ageFonctionnaire;
    }

    public void setAgeFonctionnaire(long ageFonctionnaire) {
        this.ageFonctionnaire = ageFonctionnaire;
    }

    public CategorieStructure getCategorieStructureAffec() {
        return categorieStructureAffec;
    }

    public void setCategorieStructureAffec(CategorieStructure categorieStructureAffec) {
        this.categorieStructureAffec = categorieStructureAffec;
    }

    public RangerFonctio getRangerFonctioChangerGrade() {
        return rangerFonctioChangerGrade;
    }

    public void setRangerFonctioChangerGrade(RangerFonctio rangerFonctioChangerGrade) {
        this.rangerFonctioChangerGrade = rangerFonctioChangerGrade;
    }

    public Corps getCorpsChangerGrade() {
        return corpsChangerGrade;
    }

    public void setCorpsChangerGrade(Corps corpsChangerGrade) {
        this.corpsChangerGrade = corpsChangerGrade;
    }

    public Cadre getCadreChangerGrade() {
        return cadreChangerGrade;
    }

    public void setCadreChangerGrade(Cadre cadreChangerGrade) {
        this.cadreChangerGrade = cadreChangerGrade;
    }

    public GradeFonctio getGradeChangerGrade() {
        return gradeChangerGrade;
    }

    public void setGradeChangerGrade(GradeFonctio gradeChangerGrade) {
        this.gradeChangerGrade = gradeChangerGrade;
    }

    public String getDateDebutGradeChangerGrade() {
        return dateDebutGradeChangerGrade;
    }

    public void setDateDebutGradeChangerGrade(String dateDebutGradeChangerGrade) {
        this.dateDebutGradeChangerGrade = dateDebutGradeChangerGrade;
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

    public void setBoolCni(boolean boolCni) {
        this.boolCni = boolCni;
    }

    public boolean isBoolRegOri() {
        return boolRegOri;
    }

    public void setBoolRegOri(boolean boolRegOri) {
        this.boolRegOri = boolRegOri;
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

    public boolean isBoolSpecial() {
        return boolSpecial;
    }

    public void setBoolSpecial(boolean boolSpecial) {
        this.boolSpecial = boolSpecial;
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

    public boolean isBoolDateRetraite() {
        return boolDateRetraite;
    }

    public void setBoolDateRetraite(boolean boolDateRetraite) {
        this.boolDateRetraite = boolDateRetraite;
    }

    public boolean isBoolRegionNaiss() {
        return boolRegionNaiss;
    }

    public void setBoolRegionNaiss(boolean boolRegionNaiss) {
        this.boolRegionNaiss = boolRegionNaiss;
    }

    public boolean isBoolDateSortie() {
        return boolDateSortie;
    }

    public void setBoolDateSortie(boolean boolDateSortie) {
        this.boolDateSortie = boolDateSortie;
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

    public boolean isBoolCadre() {
        return boolCadre;
    }

    public void setBoolCadre(boolean boolCadre) {
        this.boolCadre = boolCadre;
    }

    public boolean isBoolCorps() {
        return boolCorps;
    }

    public void setBoolCorps(boolean boolCorps) {
        this.boolCorps = boolCorps;
    }

    public boolean isBoolDiplomeEntre() {
        return boolDiplomeEntre;
    }

    public void setBoolDiplomeEntre(boolean boolDiplomeEntre) {
        this.boolDiplomeEntre = boolDiplomeEntre;
    }

    public boolean isBoolNotif() {
        return boolNotif;
    }

    public void setBoolNotif(boolean boolNotif) {
        this.boolNotif = boolNotif;
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

    public GradeFonctio currentGradeFonctio(Agentp agent) {
        return (iRangerFonctioService.findRangerFonctioOpenByIdAgent(agent.getId())).getGradeFonctio();
    }

    public Cadre currentCadreFonctio(Agentp agent) {
        return (iRangerFonctioService.findRangerFonctioOpenByIdAgent(agent.getId())).getGradeFonctio().getCadre();
    }

    public Corps currentCorpsFonctio(Agentp agent) {
        return (iRangerFonctioService.findRangerFonctioOpenByIdAgent(agent.getId())).getGradeFonctio().getCadre().getCorps();
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

    public int currentAgeFonctio(Agentp agent) {
        Date currentDate = new Date();
        int age = currentDate.getYear() - agent.getDateNaissance().getYear();
        if (currentDate.getMonth() < agent.getDateNaissance().getMonth() && !agent.isIsBornArround()) {
            return age - 1;
        }
        return age;
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

    public String currentDateEntreeFonctionPub(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateEntreeFonctionPub = simpleDateFormat.format(agent.getDateEntreFonctionPub());
        int nombreAnneeService = (new Date()).getYear() - agent.getDateEntreFonctionPub().getYear();
        if (agent.isIsRetraite()) {
            return dateEntreeFonctionPub;
        }
        return dateEntreeFonctionPub + "(" + nombreAnneeService + ")";
    }

    public String currentDateDepartRetraite(Fonctionnaire agent) throws Exception {
        try {
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            return simpleDateFormat.format(iAffectationService.findLastAffectationByIdAgent(agent.getId()).getDateFinAffect());
        } catch (Exception e) {
            throw e;
        }
    }

    public Arrondissement currentArrondissement(Agentp agent) {
        return (iAffectationService.findAffectationOpenByIdAgent(agent.getId())).getStructureAttache().getArrondissement();
    }

    public Departement currentDepartement(Agentp agent) {
        return (iAffectationService.findAffectationOpenByIdAgent(agent.getId())).getStructureAttache().getArrondissement().getDepartement();
    }

    /*
    fin du bloc de construction des agents dans leur situation courante. début des méthode permettant d'avoir un tableau dynamique
     */
    public void initListColumn() {
        boolMat = false;
        boolNom = false;
        boolPrenom = false;
        boolTel = false;
        boolLieuCni = false;
        boolDateCni = false;
        boolNomJeunFille = false;
        boolDateNaiss = false;
        boolLieuNaiss = false;
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
        boolCorps = false;
        boolCadre = false;
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
            listInformationToDisplay.add("numerocni");

            listInformationToDisplay1.add("sexe");
            listInformationToDisplay1.add("numerocni");
            listInformationToDisplay1.add("grade");
            listInformationToDisplay1.add("cadre");
            listInformationToDisplay1.add("corps");
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
                case "cadre":
                    boolCadre = true;
                    break;
                case "corps":
                    boolCorps = true;
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
                    break;
                default:
                    break;

            }
        }
    }

    public List<Sexe> sexes() {
        List<Sexe> listSexe = new ArrayList<>();
        listSexe.addAll(Arrays.asList(Sexe.values()));
        return listSexe;
    }

    /*
    this is to reinitialize the entity fonctionnaire before creating another
     */
    public void initFonctio() {
        idCorps = 0L;
        idDepartement = 0L;
        idSpecialite = 0L;
        idCadre = 0L;
        idGradeFonctio = 0L;
        idDepartement = 0L;
        idArrondissement = 0L;
        idCategorieStructure = 0L;
        idStructure = 0L;
        idPoste = 0L;
        promotion = new Promotion();
        affectation = new Affectation();
        rangerFonctio = new RangerFonctio();
        fonctionnaire = new Fonctionnaire();
        fonctionnaire.setIsBornArround(false);
        fonctionnaire.setIsRetraite(false);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateNaissanceFonc = "";
        dateNaissanceFoncVers = "";
        dateEntreFoncPub = "";
        dateDebutGrade = "";
        dateDebutAffec = "";
        dateDebutPoste = "";
        dateCni = "";
    }

    /*
    this is aim to initialize the oneMenu to nothing before updating
     */
    public void beforeUpdateFonctio() {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        idSpecialite = fonctionnaire.getSpecialite().getId();
        rangerFonctio = iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId());
        gradeFonctio = rangerFonctio.getGradeFonctio();
        idGradeFonctio = gradeFonctio.getId();
        cadre = gradeFonctio.getCadre();
        idCadre = cadre.getId();
        if (!fonctionnaire.isIsBornArround()) {
            dateNaissanceFonc = simpleDateFormat.format(fonctionnaire.getDateNaissance());
            dateNaissanceFoncVers = "";
        } else {
            dateNaissanceFonc = "";
            dateNaissanceFoncVers = "19" + fonctionnaire.getDateNaissance().getYear();
        }
        dateEntreFoncPub = simpleDateFormat.format(fonctionnaire.getDateEntreFonctionPub());
        dateDebutGrade = simpleDateFormat.format(rangerFonctio.getDateDebutRangerFonctio());
        affectation = iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId());
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());
        corps = cadre.getCorps();
        idCorps = corps.getId();
        structureAttache = affectation.getStructureAttache();
        idStructure = structureAttache.getId();
        arrondissement = structureAttache.getArrondissement();
        idArrondissement = arrondissement.getId();
        departement = arrondissement.getDepartement();
        idDepartement = departement.getId();
        categorieStructure = structureAttache.getCategorieStructure();
        idCategorieStructure = categorieStructure.getId();
        promotion = iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId());
        poste = promotion.getPoste();
        idPoste = poste.getId();
        dateCni = simpleDateFormat.format(fonctionnaire.getDateDelivranceCni());
    }

    //this is to initialize the various element an display them before confirmation
    public void beforeConfirm() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        specialite = iSpecialiteService.findSpecialiteById(idSpecialite);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        poste = iPosteService.findPosteById(idPoste);
        cadre = iCadreService.findCadreById(idCadre);
        corps = iCorpsService.findCorpsById(idCorps);
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        departement = iDepartementService.findDepartementById(idDepartement);
        categorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        if (!fonctionnaire.isIsBornArround()) {
            fonctionnaire.setDateNaissance(simpleDateFormat.parse(dateNaissanceFonc));
        } else {
            fonctionnaire.setDateNaissance(simpleDateFormat.parse("31/12/" + dateNaissanceFoncVers));
            dateNaissanceFonc = "vers " + dateNaissanceFoncVers;
        }
        fonctionnaire.setDateEntreFonctionPub(simpleDateFormat.parse(dateEntreFoncPub));
        promotion.setDateDebutPromo(simpleDateFormat.parse(dateDebutPoste));
        affectation.setDateDebutAffect(simpleDateFormat.parse(dateDebutPoste));
        rangerFonctio.setDateDebutRangerFonctio(simpleDateFormat.parse(dateDebutGrade));
        dateCni = simpleDateFormat.format(fonctionnaire.getDateDelivranceCni());
    }

    public void beforeConfirmAffect() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        affectation = iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId());
        structureAttache = affectation.getStructureAttache();
        arrondissement = structureAttache.getArrondissement();
        departement = arrondissement.getDepartement();
        categorieStructure = structureAttache.getCategorieStructure();
        promotion = iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId());
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

    // pour le retour d'un fonctionnaire dans la région
    public void beforeConfirmRetourFonctio() throws ParseException {
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
        rangerFonctio = iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId());
        gradeFonctio = rangerFonctio.getGradeFonctio();
        cadre = gradeFonctio.getCadre();
        corps = cadre.getCorps();
        dateDebutGrade = simpleDateFormat.format(rangerFonctio.getDateDebutRangerFonctio());

        rangerFonctioChangerGrade = new RangerFonctio();
        corpsChangerGrade = iCorpsService.findCorpsById(idCorps);
        cadreChangerGrade = iCadreService.findCadreById(idCadre);
        gradeChangerGrade = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        rangerFonctioChangerGrade.setDateDebutRangerFonctio(simpleDateFormat.parse(dateDebutGradeChangerGrade));
    }

    public void beforeChangerGrade() throws ParseException {
        rangerFonctio = null;
        gradeFonctio = null;
        cadre = null;
        corps = null;
        dateDebutGrade = "";

        idCorps = 0L;
        idCadre = 0L;
        idGradeFonctio = 0L;
    }

    public void beforeConfirmRetraite() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        affectation = iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId());
        structureAttache = affectation.getStructureAttache();
        arrondissement = structureAttache.getArrondissement();
        departement = arrondissement.getDepartement();
        promotion = iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId());
        poste = promotion.getPoste();
        affectation.setDateFinAffect(simpleDateFormat.parse(dateRetraite));
        promotion.setDateFinPromo(simpleDateFormat.parse(dateRetraite));
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());
        if (!fonctionnaire.isIsBornArround()) {
            dateNaissanceFonc = simpleDateFormat.format(fonctionnaire.getDateNaissance());
        } else {
            dateNaissanceFonc = "vers 19" + fonctionnaire.getDateNaissance().getYear();
        }

    }

    public void beforeRestauration() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        affectation = iAffectationService.findLastAffectationByIdAgent(fonctionnaire.getId());
        structureAttache = affectation.getStructureAttache();
        arrondissement = structureAttache.getArrondissement();
        departement = arrondissement.getDepartement();
        promotion = iPromotionService.findLastPromotionByIdAgent(fonctionnaire.getId());
        poste = promotion.getPoste();
        affectation.setDateFinAffect(null);
        promotion.setDateFinPromo(null);
        dateDebutPoste = simpleDateFormat.format(affectation.getDateDebutAffect());
        if (!fonctionnaire.isIsBornArround()) {
            dateNaissanceFonc = simpleDateFormat.format(fonctionnaire.getDateNaissance());
        } else {
            dateNaissanceFonc = "vers 19" + fonctionnaire.getDateNaissance().getYear();
        }

    }

    public void beforeDisplayProfil() {
        listAffectations = iAffectationService.findAffectationByIdAgent(fonctionnaire.getId());
        listPromotions = iPromotionService.findPromotionByIdAgent(fonctionnaire.getId());
        listRangerFonctios = iRangerFonctioService.findRangerFonctioByIdAgent(fonctionnaire.getId());
        listAffectationsPromotions = new ArrayList<>();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        if (!fonctionnaire.isIsBornArround()) {
            dateNaissanceFonc = simpleDateFormat.format(fonctionnaire.getDateNaissance());
        } else {
            dateNaissanceFonc = "vers 19" + fonctionnaire.getDateNaissance().getYear();
        }

        for (int i = 0; i < listPromotions.size(); i++) {
            AffectationPromotion ap = new AffectationPromotion();
            ap.setA(listAffectations.get(i));
            ap.setP(listPromotions.get(i));
            listAffectationsPromotions.add(ap);
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

    public String onFlowProcessRetourFonctio(FlowEvent event) throws ParseException {
        logger.log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        logger.log(Level.INFO, "Next step:{0}", event.getNewStep());
        //  event.setPhaseId(PhaseId.phaseIdValueOf("personnel"));

        if (event.getNewStep().equals("confirmationTabAffect")) {
            beforeConfirmRetourFonctio();
            return "confirmationTabAffect";
        } else {
            return event.getNewStep();
        }
    }

    public Fonctionnaire createFonctionnaire() {
        try {
            fonctionnaire.setSpecialite(specialite);
            iFonctionnaireService.createFonctionnaire(fonctionnaire);

            affectation.setAgent(fonctionnaire);
            affectation.setStructureAttache(structureAttache);
            iAffectationService.createAffectation(affectation);

            rangerFonctio.setFonctionnaire(fonctionnaire);
            rangerFonctio.setGradeFonctio(gradeFonctio);
            iRangerFonctioService.createRangerFonctio(rangerFonctio);

            promotion.setAgent(fonctionnaire);
            promotion.setPoste(poste);
            iPromotionService.createPromotion(promotion);

            return fonctionnaire;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec d'enregitrement vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Fonctionnaire findFonctionnaireById() {
        return iFonctionnaireService.findFonctionnaireById(fonctionnaire.getId());
    }

    public Fonctionnaire updateFonctionnaire() throws Exception {
        try {
            specialite = iSpecialiteService.findSpecialiteById(idSpecialite);
            fonctionnaire.setSpecialite(specialite);

            affectation.setStructureAttache(structureAttache);
            affectation.setDateDebutAffect(simpleDateFormat.parse(dateDebutPoste));
            iAffectationService.updateAffectation(affectation);

            rangerFonctio.setGradeFonctio(gradeFonctio);
            rangerFonctio.setDateDebutRangerFonctio(simpleDateFormat.parse(dateDebutGrade));
            iRangerFonctioService.updateRangerFonctio(rangerFonctio);

            promotion.setPoste(poste);
            promotion.setDateDebutPromo(simpleDateFormat.parse(dateDebutPoste));
            iPromotionService.updatePromotion(promotion);

            return iFonctionnaireService.updateFonctionnaire(fonctionnaire);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec de modification vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Fonctionnaire> findAllFonctionnaire() {
        return iFonctionnaireService.findAllFonctionnaire();
    }

    public List<Fonctionnaire> findFonctionnaireActif() {
        return iFonctionnaireService.findFonctionnaireActif();
    }

    public List<Fonctionnaire> findFonctionnaireRetraites() {
        return iFonctionnaireService.findFonctionnaireRetraites();
    }

    public List<Fonctionnaire> findFonctionnairesSortis() {
        List<Fonctionnaire> listAllFonctionnaires = iFonctionnaireService.findAllFonctionnaire();
        listAllFonctionnaires.removeAll(iFonctionnaireService.findFonctionnaireActif());
        listAllFonctionnaires.removeAll(iFonctionnaireService.findFonctionnaireRetraites());
        return listAllFonctionnaires;
    }

    public Fonctionnaire retraite() {
        fonctionnaire.setIsRetraite(true);
        iAffectationService.updateAffectation(affectation);
        iPromotionService.updatePromotion(promotion);
        return iFonctionnaireService.updateFonctionnaire(fonctionnaire);
    }

    public Fonctionnaire sortieRegion() {
        iAffectationService.updateAffectation(affectation);
        iPromotionService.updatePromotion(promotion);
        return iFonctionnaireService.updateFonctionnaire(fonctionnaire);
    }

    public Fonctionnaire restaureRetraite() {
        fonctionnaire.setIsRetraite(false);
        iAffectationService.updateAffectation(affectation);
        iPromotionService.updatePromotion(promotion);
        return iFonctionnaireService.updateFonctionnaire(fonctionnaire);
    }

    public void affecterFonctionnaire() {
        try {
            affectationAffec.setAgent(fonctionnaire);
            affectationAffec.setStructureAttache(structureAttacheAffec);
            promotionAffec.setAgent(fonctionnaire);
            promotionAffec.setPoste(posteAffec);
            iAffectationService.createAffectation(affectationAffec);
            iPromotionService.createPromotion(promotionAffec);
            affectation.setDateFinAffect(affectationAffec.getDateDebutAffect());
            promotion.setDateFinPromo(promotionAffec.getDateDebutPromo());
            iAffectationService.updateAffectation(affectation);
            iPromotionService.updatePromotion(promotion);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec d'affectation vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public void ChagerGradeFonctionnaire() {
        try {
            rangerFonctioChangerGrade.setFonctionnaire(fonctionnaire);
            rangerFonctioChangerGrade.setGradeFonctio(gradeChangerGrade);
            iRangerFonctioService.createRangerFonctio(rangerFonctioChangerGrade);
            rangerFonctio.setDateFinRangerFonctio(rangerFonctioChangerGrade.getDateDebutRangerFonctio());
            iRangerFonctioService.updateRangerFonctio(rangerFonctio);

        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec du changement de grade vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

    public void retourFonctionnaire() {
        try {
            affectationAffec.setAgent(fonctionnaire);
            affectationAffec.setStructureAttache(structureAttacheAffec);
            promotionAffec.setAgent(fonctionnaire);
            promotionAffec.setPoste(posteAffec);
            iAffectationService.createAffectation(affectationAffec);
            iPromotionService.createPromotion(promotionAffec);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("echec d'affectation vérifier les informations");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }
//    public void retraiteMensuelFonctio(){
//        listFonctioRetraiteMensuel = iFonctionnaireService.findFonctionnaireActif();
//        for (Fonctionnaire fonctio : listFonctioRetraiteMensuel) {
//            if(currentAgeFonctio(fonctio) < currentGradeFonctio(fonctio).getRetraite())
//                listFonctioRetraiteMensuel.remove(fonctio);
//        }
//        if(!listFonctioRetraiteMensuel.isEmpty())
//            boolNotif = true;
//    }
}
