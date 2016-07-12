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
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Affectation;
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
import com.dresen.dresen.entities.StructureAttache;
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
    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService iDepartementService;
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;

    private static Logger logger = Logger.getLogger(FonctionnaireBean.class.getName());
    private Contractuel contractuel = new Contractuel();
    private GradeContract gradeContract;
    private RangerContract rangerContract;
    private Promotion promotion;
    private Poste poste;
    private Arrondissement arrondissement;
    private Departement departement;
    private CategorieStructure categorieStructure;
    private SimpleDateFormat simpleDateFormat;
    private Affectation affectation;
    private StructureAttache structureAttache;
    private List<Departement> listDepartement;
    private List<Arrondissement> listArrondissement;
    private List<CategorieStructure> listCategorieStructure;
    private List<StructureAttache> listStructureAttache;
    private List<Poste> listPoste;
    private List<RangerContract> listrangerContracts;
    private List<GradeContract> listGradeContract;
    private List<String> listInformationToDisplay;
    private String dateNaissanceContract, dateEntreFoncPub, dateDebutGrade, dateDebutPoste, dateDebutPosteAffec, dateDebutAffec, dateRetraite;
    private long idGradeContract, idRangerContract, idStructure, idPoste, idRangerFonctio, idDepartement, idArrondissement, idCategorieStructure;
    // ces variable permettent de contrôler les colonnes à afficher dans le dataTable
    private boolean boolMat, boolNom = true, boolPrenom = true, boolNomJeunFille, boolDateNaiss, boolLieuNaiss, boolSexe, boolCni, boolRegOri, boolDepOri, boolArrOro, boolGrade, boolDateRetraite, boolDateEntreeFoncPub, boolStrucAttach, boolPoste, boolDateAffec, boolArronStruct, boolDepartStruct;

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

    public long getIdRangerFonctio() {
        return idRangerFonctio;
    }

    public void setIdRangerFonctio(long idRangerFonctio) {
        this.idRangerFonctio = idRangerFonctio;
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

    public List<RangerContract> getListrangerContracts() {
        return listrangerContracts;
    }

    public void setListrangerContracts(List<RangerContract> listrangerContracts) {
        this.listrangerContracts = listrangerContracts;
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
    

    /*
    ces méthodes ont pour rôle de construire tous les agents dans leur situation courrante ie. avec leur poste courrant leur structure d'attache courrante le grade courant.
     */
    public Poste currentPoste(Agentp agent) {
        return (iPromotionService.findPromotionOpenByIdAgent(agent.getId())).getPoste();
    }

    public StructureAttache currentStructureAttache(Agentp agent) {
        return (iAffectationService.findAffectationOpenByIdAgent(agent.getId())).getStructureAttache();
    }

    public GradeContract currentGradeContract(Agentp agent) {
        return (iRangerContractService.findRangerContractOpenByIdAgent(agent.getId())).getGradeContract();
    }

    public String currentDateNaissance(Agentp agent) {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateNaissance = simpleDateFormat.format(agent.getDateNaissance());
        int age = (new Date()).getYear() - agent.getDateNaissance().getYear();
        return dateNaissance + "(" + age + ")";
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
        boolSexe = false;
        boolCni = false;
        boolRegOri = false;
        boolDepOri = false;
        boolArrOro = false;
        boolGrade = false;
        boolDateRetraite = false;
        boolDateEntreeFoncPub = false;
        boolStrucAttach = false;
        boolPoste = false;
        boolDateAffec = false;
        boolArronStruct = false;
        boolDepartStruct = false;
        listInformationToDisplay = new ArrayList<>();
    }

    public void createDynamicColumns() {
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
                case "dateentreefoncpub":
                    boolDateEntreeFoncPub = true;
                    break;
                case "dateretraite":
                    boolDateRetraite = true;
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
                default:
                    break;

            }
        }
    }

    //this is to initialize the various element an display them before confirmation
    public void beforeConfirm() throws ParseException {
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        poste = iPosteService.findPosteById(idPoste);
        arrondissement = iArrondissementService.findArrondissementById(idArrondissement);
        departement = iDepartementService.findDepartementById(idDepartement);
        categorieStructure = iCategorieStructureService.findCategorieStructureById(idCategorieStructure);
        contractuel.setDateNaissance(simpleDateFormat.parse(dateNaissanceContract));
        contractuel.setDateEntreFonctionPub(simpleDateFormat.parse(dateEntreFoncPub));
        promotion.setDateDebutPromo(simpleDateFormat.parse(dateDebutPoste));
        affectation.setDateDebutAffect(simpleDateFormat.parse(dateDebutPoste));
        rangerContract.setDateDebutRangerContract(simpleDateFormat.parse(dateDebutGrade));
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

    public List<Sexe> sexes() {
        List<Sexe> listSexe = new ArrayList<>();
        listSexe.addAll(Arrays.asList(Sexe.values()));
        return listSexe;
    }

    public void initContract() {
        idDepartement = 0L;
        idGradeContract = 0L;
        idDepartement = 0L;
        idArrondissement = 0L;
        idCategorieStructure = 0L;
        idStructure = 0L;
        idPoste = 0L;
        promotion = new Promotion();
        affectation = new Affectation();
        rangerContract = new RangerContract();
        contractuel = new Contractuel();
        contractuel.setIsRetraite(false);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateNaissanceContract = "";
        dateEntreFoncPub = "";
        dateDebutGrade = "";
        dateDebutAffec = "";
    }

    public Contractuel createContractuel() {
        try {
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

    public Contractuel updateContractuel() {
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        poste = iPosteService.findPosteById(idPoste);
        rangerContract.setContratuel(contractuel);
        rangerContract.setGradeContract(gradeContract);
        affectation.setAgent(contractuel);
        affectation.setStructureAttache(structureAttache);
        promotion.setAgent(contractuel);
        promotion.setPoste(poste);
        iRangerContractService.createRangerContract(rangerContract);
        iPromotionService.createPromotion(promotion);
        iAffectationService.createAffectation(affectation);
        return iContractuelService.updateContractuel(contractuel);
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

}
