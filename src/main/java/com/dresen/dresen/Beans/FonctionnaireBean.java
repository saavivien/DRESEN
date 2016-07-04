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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
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
    private Poste poste = new Poste();
    private Specialite specialite = new Specialite();

    private Affectation affectation = new Affectation();
    private StructureAttache structureAttache = new StructureAttache();
    private boolean skip;
    private static Logger logger = Logger.getLogger(FonctionnaireBean.class.getName());

    private List<Corps> listCorps;
    private List<Cadre> listCadre;
    private List<Fonctionnaire> listFonctionnaires;
    private List<GradeFonctio> listGradeFonctio;
    private List<Specialite> listSpecialite;
    private List<Departement> listDepartement;
    private List<Arrondissement> listArrondissement;
    private List<CategorieStructure> listCategorieStructure;
    private List<StructureAttache> listStructureAttache;
    private List<Poste> listPoste;
    private long idGradeFonctio, idRangerFonctio, idStructure, idPoste, idSpecialite, idCorps, idCadre, idDepartement, idArrondissement, idCategorieStructure;
    private Cadre cadre;
    private Corps corps;
    private Arrondissement arrondissement;
    private Departement departement;
    private CategorieStructure categorieStructure;
    private SimpleDateFormat simpleDateFormat;
    private String dateNaissanceFonc, dateEntreFoncPub, dateDebutGrade, dateDebutPoste, dateDebutAffec;

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

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
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
    
    
    /*
    ces méthodes ont pour rôle de construire tous les agents dans leur situation courrante ie. avec leur poste courrant leur structure d'attache courrante le grade courant.
    */
    public String currentPoste(Agentp agent) {
        return (iPromotionService.findPromotionOpenByIdAgent(agent.getId())).getPoste().getIntitulePoste();
    }

    public String currentStructureAttache(Agentp agent) {
        return (iAffectationService.findAffectationOpenByIdAgent(agent.getId())).getStructureAttache().getCodeStructure();
    }

    public String currentGradeFonctio(Agentp agent) {
        return (iRangerFonctioService.findRangerFonctioOpenByIdAgent(agent.getId())).getGradeFonctio().getIntituleGradeFonctio();
    }
    
    public String currentDateNaissance(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateNaissance = simpleDateFormat.format(agent.getDateNaissance());
        int age = (new Date()).getYear() - agent.getDateNaissance().getYear();
        return dateNaissance + "(" + age + ")";
    }
    
    public String currentDateAffect(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Affectation affect = iAffectationService.findAffectationOpenByIdAgent(agent.getId());
        String dateEntreePoste = simpleDateFormat.format((affect).getDateDebutAffect());
        int anciennetePoste = (new Date()).getYear() - (affect).getDateDebutAffect().getYear();
        return dateEntreePoste + "(" + anciennetePoste + ")";
    }
    
    public String currentDateEntreeFonctionPub(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateEntreeFonctionPub = simpleDateFormat.format(agent.getDateEntreFonctionPub());
        int nombreAnneeService = (new Date()).getYear() - agent.getDateEntreFonctionPub().getYear();
        return dateEntreeFonctionPub + "(" + nombreAnneeService + ")";
    }

    /*
    fin du bloc de construction des agents dans leur situation courante
    */
    
   
    public List<Sexe> sexes() {
        List<Sexe> listSexe = new ArrayList<Sexe>();
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
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateNaissanceFonc = "";
        dateEntreFoncPub = "";
        dateDebutGrade = "";
        dateDebutAffec = "";
    }

    /*
    this is aim to initialize the oneMenu to nothing before updating
     */
    public void beforeUpdateFonctio() {
//        if (fonctionnaire == null) {
//            idCorps = 0L;
//            idDepartement = 0L;
//            idSpecialite = 0L;
//            idCadre = 0L;
//            idGradeFonctio = 0L;
//            idDepartement = 0L;
//            idArrondissement = 0L;
//            idCategorieStructure = 0L;
//            idStructure = 0L;
//            idPoste = 0L;
//            fonctionnaire = new Fonctionnaire();
//            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        } else {
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            idSpecialite = fonctionnaire.getSpecialite().getId();
            gradeFonctio = (iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId())).getGradeFonctio();
            idGradeFonctio = gradeFonctio.getId();
            cadre = gradeFonctio.getCadre();
            dateNaissanceFonc = simpleDateFormat.format(fonctionnaire.getDateNaissance());
            dateEntreFoncPub = simpleDateFormat.format(fonctionnaire.getDateEntreFonctionPub());
            dateDebutGrade = simpleDateFormat.format((iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId())).getDateDebutRangerFonctio());
            dateDebutPoste = simpleDateFormat.format((iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId())).getDateDebutAffect());
            idCadre = cadre.getId();
            corps = cadre.getCorps();
            idCorps = corps.getId();
            structureAttache = (iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId())).getStructureAttache();
            arrondissement = structureAttache.getArrondissement();
            idArrondissement = arrondissement.getId();
            departement = arrondissement.getDepartement();
            idDepartement = departement.getId();
            categorieStructure = structureAttache.getCategorieStructure();
            idCategorieStructure = categorieStructure.getId();
            idStructure = structureAttache.getId();
            poste = (iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId())).getPoste();
            idPoste = poste.getId();
//        }
    }

    //this is to initialize the various element an display them before confirmation
    public void beforeConfirm() throws ParseException {
        
        specialite = iSpecialiteService.findSpecialiteById(idSpecialite);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        gradeFonctio = iGradeFonctioService.findGradeFonctioById(idGradeFonctio);
        poste = iPosteService.findPosteById(idPoste);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        cadre = iCadreService.findCadreById(idCadre);
        corps = iCorpsService.findCorpsById(idCorps);
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        departement = iDepartementService.findDepartementById(idDepartement);
        categorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        fonctionnaire.setDateNaissance(simpleDateFormat.parse(dateNaissanceFonc));
        fonctionnaire.setDateEntreFonctionPub(simpleDateFormat.parse(dateEntreFoncPub));
        promotion.setDateDebutPromo(simpleDateFormat.parse(dateDebutPoste));
        affectation.setDateDebutAffect(simpleDateFormat.parse(dateDebutPoste));
        rangerFonctio.setDateDebutRangerFonctio(simpleDateFormat.parse(dateDebutGrade));
    }

    public String onFlowProcess(FlowEvent event) throws ParseException {
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

    public Fonctionnaire createFonctionnaire() throws Exception {
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
            System.out.println("erreur d'enregistrement du fonctionnaire" + e);
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

            affectation = iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId());
            affectation.setStructureAttache(structureAttache);
            iAffectationService.updateAffectation(affectation);

            rangerFonctio = iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId());
            rangerFonctio.setGradeFonctio(gradeFonctio);
            iRangerFonctioService.updateRangerFonctio(rangerFonctio);

            promotion = iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId());
            promotion.setPoste(poste);
            iPromotionService.updatePromotion(promotion);

            return iFonctionnaireService.updateFonctionnaire(fonctionnaire);
        } catch (Exception e) {
            System.out.println("erreur d'enregistrement du fonctionnaire" + e);
            throw e;
        }
    }

    public List<Fonctionnaire> findAllFonctionnaire() {
        return iFonctionnaireService.findAllFonctionnaire();
    }
}
