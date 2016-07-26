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
import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.ServiceInterface.ICorpsService;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.ServiceInterface.IGradeContractService;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPosteStructureService;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.ServiceInterface.IRangerContractService;
import com.dresen.dresen.ServiceInterface.IRangerFonctioService;
import com.dresen.dresen.ServiceInterface.ISpecialiteService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Arrondissement;
import com.dresen.dresen.entities.Cadre;
import com.dresen.dresen.entities.CategorieStructure;
import com.dresen.dresen.entities.Contractuel;
import com.dresen.dresen.entities.Corps;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.Fonctionnaire;
import com.dresen.dresen.entities.GradeContract;
import com.dresen.dresen.entities.GradeFonctio;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.PosteStructure;
import com.dresen.dresen.entities.Specialite;
import com.dresen.dresen.entities.StructureAttache;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import jxl.*;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@ViewScoped
public class ExporterBean {

    @ManagedProperty(value = "#{IDepartementService}")
    private IDepartementService iDepartementService;
    @ManagedProperty(value = "#{IArrondissementService}")
    private IArrondissementService iArrondissementService;
    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;
    @ManagedProperty(value = "#{ICorpsService}")
    private ICorpsService iCorpsService;
    @ManagedProperty(value = "#{ICadreService}")
    private ICadreService iCadreService;
    @ManagedProperty(value = "#{IGradeFonctioService}")
    private IGradeFonctioService iGradeFonctioService;
    @ManagedProperty(value = "#{IGradeContractService}")
    private IGradeContractService iGradeContractService;
    @ManagedProperty(value = "#{ISpecialiteService}")
    private ISpecialiteService iSpecialiteService;
    @ManagedProperty(value = "#{IFonctionnaireService}")
    private IFonctionnaireService iFonctionnaireService;
    @ManagedProperty(value = "#{IContractuelService}")
    private IContractuelService iContractuelService;
    @ManagedProperty(value = "#{IAffectationService}")
    private IAffectationService iAffectationService;
    @ManagedProperty(value = "#{IPromotionService}")
    private IPromotionService iPromotionService;
    @ManagedProperty(value = "#{IRangerFonctioService}")
    private IRangerFonctioService iRangerFonctioService;
    @ManagedProperty(value = "#{IRangerContractService}")
    private IRangerContractService iRangerContractService;
    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    @ManagedProperty(value = "#{IPosteStructureService}")
    private IPosteStructureService iPosteStructureService;

    private StreamedContent prepDownload;
    private ZipOutputStream zip;
    private SimpleDateFormat simpleDateFormat;
    private String exportParentDirectoryPath;
    private String exportDirectoryPath;
    private Object event;

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

    public IStructureService getiStructureService() {
        return iStructureService;
    }

    public void setiStructureService(IStructureService iStructureService) {
        this.iStructureService = iStructureService;
    }

    public ICategorieStructureService getiCategorieStructureService() {
        return iCategorieStructureService;
    }

    public void setiCategorieStructureService(ICategorieStructureService iCategorieStructureService) {
        this.iCategorieStructureService = iCategorieStructureService;
    }

    public IGradeFonctioService getiGradeFonctioService() {
        return iGradeFonctioService;
    }

    public void setiGradeFonctioService(IGradeFonctioService iGradeFonctioService) {
        this.iGradeFonctioService = iGradeFonctioService;
    }

    public IGradeContractService getiGradeContractService() {
        return iGradeContractService;
    }

    public void setiGradeContractService(IGradeContractService iGradeContractService) {
        this.iGradeContractService = iGradeContractService;
    }

    public ISpecialiteService getiSpecialiteService() {
        return iSpecialiteService;
    }

    public void setiSpecialiteService(ISpecialiteService iSpecialiteService) {
        this.iSpecialiteService = iSpecialiteService;
    }

    public IFonctionnaireService getiFonctionnaireService() {
        return iFonctionnaireService;
    }

    public void setiFonctionnaireService(IFonctionnaireService iFonctionnaireService) {
        this.iFonctionnaireService = iFonctionnaireService;
    }

    public IContractuelService getiContractuelService() {
        return iContractuelService;
    }

    public void setiContractuelService(IContractuelService iContractuelService) {
        this.iContractuelService = iContractuelService;
    }

    public IAffectationService getiAffectationService() {
        return iAffectationService;
    }

    public void setiAffectationService(IAffectationService iAffectationService) {
        this.iAffectationService = iAffectationService;
    }

    public IPromotionService getiPromotionService() {
        return iPromotionService;
    }

    public void setiPromotionService(IPromotionService iPromotionService) {
        this.iPromotionService = iPromotionService;
    }

    public IRangerFonctioService getiRangerFonctioService() {
        return iRangerFonctioService;
    }

    public void setiRangerFonctioService(IRangerFonctioService iRangerFonctioService) {
        this.iRangerFonctioService = iRangerFonctioService;
    }

    public IRangerContractService getiRangerContractService() {
        return iRangerContractService;
    }

    public void setiRangerContractService(IRangerContractService iRangerContractService) {
        this.iRangerContractService = iRangerContractService;
    }

    public IPosteService getiPosteService() {
        return iPosteService;
    }

    public void setiPosteService(IPosteService iPosteService) {
        this.iPosteService = iPosteService;
    }

    public IPosteStructureService getiPosteStructureService() {
        return iPosteStructureService;
    }

    public void setiPosteStructureService(IPosteStructureService iPosteStructureService) {
        this.iPosteStructureService = iPosteStructureService;
    }

    public ICadreService getiCadreService() {
        return iCadreService;
    }

    public void setiCadreService(ICadreService iCadreService) {
        this.iCadreService = iCadreService;
    }

    public ICorpsService getiCorpsService() {
        return iCorpsService;
    }

    public void setiCorpsService(ICorpsService iCorpsService) {
        this.iCorpsService = iCorpsService;
    }

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public ZipOutputStream getZip() {
        return zip;
    }

    public void setZip(ZipOutputStream zip) {
        this.zip = zip;
    }

    public String getExportParentDirectoryPath() {
        return exportParentDirectoryPath;
    }

    public void setExportParentDirectoryPath(String exportParentDirectoryPath) {
        this.exportParentDirectoryPath = exportParentDirectoryPath;
    }

    public String getExportDirectoryPath() {
        return exportDirectoryPath;
    }

    public void setExportDirectoryPath(String exportDirectoryPath) {
        this.exportDirectoryPath = exportDirectoryPath;
    }

    public Object getEvent() {
        return event;
    }

    public void setEvent(Object event) {
        this.event = event;
    }

    public void setPrepDownload(StreamedContent prepDownload) {
        this.prepDownload = prepDownload;
    }
    

//        IStructureService iStructureService = ctx.getBean("IStructureService", IStructureService.class);
//        List<StructureAttache> listStructureAttache = iStructureService.findStructureAttacheByCategorieAndArrondissement(1, 5);
    /*
    exportation of table département
     */
    public void buildDepartFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/departement.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<Departement> it = iDepartementService.findAllDepartement().iterator(); it.hasNext();) {
            Departement departement = it.next();
            Label label = new Label(0, i, departement.getIntituleDepartement());
            sheet.addCell(label);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table arrondissement
     */
    public void buildArrondFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/arrondissement.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<Arrondissement> it = iArrondissementService.findAllArrondissement().iterator(); it.hasNext();) {
            Arrondissement arrondissement = it.next();
            Label label1 = new Label(0, i, arrondissement.getIntituleArrondissement());
            Label label2 = new Label(1, i, arrondissement.getDepartement().getIntituleDepartement());
            sheet.addCell(label1);
            sheet.addCell(label2);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table structureAttache
     */
    public void buildStructFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/structure.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<StructureAttache> it = iStructureService.findAllStructureAttache().iterator(); it.hasNext();) {
            StructureAttache structureAttache = it.next();
            Label label1 = new Label(0, i, structureAttache.getIntituleStructure());
            Label label2 = new Label(1, i, structureAttache.getCodeStructure());
            Label label3 = new Label(2, i, structureAttache.getArrondissement().getIntituleArrondissement());
            Label label4 = new Label(3, i, structureAttache.getCategorieStructure().getIntituleCategorieStructure());
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table CatégorieStructure
     */
    public void buildCategorieStructureFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/categorieStructure.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<CategorieStructure> it = iCategorieStructureService.findAllCategorieStructure().iterator(); it.hasNext();) {
            CategorieStructure categorieStructure = it.next();
            Label label = new Label(0, i, categorieStructure.getIntituleCategorieStructure());
            sheet.addCell(label);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table Corps
     */
    public void buildCorpsFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/corps.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<Corps> it = iCorpsService.findAllCorps().iterator(); it.hasNext();) {
            Corps corps = it.next();
            Label label = new Label(0, i, corps.getIntituleCorps());
            sheet.addCell(label);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table Cadre
     */
    public void buildCadreFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/cadre.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<Cadre> it = iCadreService.findAllCadre().iterator(); it.hasNext();) {
            Cadre cadre = it.next();
            Label label1 = new Label(0, i, cadre.getIntituleCadre());
            Label label2 = new Label(1, i, cadre.getCorps().getIntituleCorps());
            sheet.addCell(label1);
            sheet.addCell(label2);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table gradeFonctio
     */
    public void buildGradeFonctioFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/gradeFonctio.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<GradeFonctio> it = iGradeFonctioService.findAllGradeFonctio().iterator(); it.hasNext();) {
            GradeFonctio gradeFonctio = it.next();
            Label label0 = new Label(0, i, gradeFonctio.getIntituleGradeFonctio());
            Label label1 = new Label(1, i, gradeFonctio.getCodeGradeFonctio());
            Label label2 = new Label(2, i, gradeFonctio.getCadre().getIntituleCadre());
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table gradeContract
     */
    public void buildGradeContractFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/gradeContract.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<GradeContract> it = iGradeContractService.findAllGradeContract().iterator(); it.hasNext();) {
            GradeContract gradeContract = it.next();
            Label label = new Label(0, i, gradeContract.getIntituleGradeContract());
            sheet.addCell(label);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table Specialite
     */
    public void buildSpecialiteFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/specialite.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<Specialite> it = iSpecialiteService.findAllSpecialite().iterator(); it.hasNext();) {
            Specialite specialite = it.next();
            Label label = new Label(0, i, specialite.getIntituleSpecialite());
            sheet.addCell(label);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table poste
     */
    public void buildPosteFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/poste.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        int i = 0;
        for (Iterator<Poste> it = iPosteService.findAllPoste().iterator(); it.hasNext();) {
            Poste poste = it.next();
            List<PosteStructure> listPosteStructures = iPosteStructureService.findPosteStructureByPoste(poste.getId());
            for (PosteStructure ps : listPosteStructures) {
                Label label1 = new Label(0, i, poste.getIntitulePoste());
                Label label2 = new Label(1, i, poste.getCode());
                Label label3 = new Label(2, i, ps.getCategorieStructure().getIntituleCategorieStructure());
                sheet.addCell(label1);
                sheet.addCell(label2);
                sheet.addCell(label3);
                i++;
            }
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table fonctionnaire
     */
    public void buildFonctionnaireFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/fonctionnaire.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        for (Iterator<Fonctionnaire> it = iFonctionnaireService.findFonctionnaireActif().iterator(); it.hasNext();) {
            Fonctionnaire fonctionnaire = it.next();
            Label label0 = new Label(0, i, fonctionnaire.getMatricule());
            Label label1 = new Label(1, i, fonctionnaire.getNom());
            Label label2 = new Label(2, i, fonctionnaire.getPrenom());
            Label label3 = new Label(3, i, fonctionnaire.getNomJeuneFille());
            Label label4 = new Label(4, i, String.valueOf(fonctionnaire.getCni()));
            Label label5 = new Label(5, i, simpleDateFormat.format(fonctionnaire.getDateNaissance()));
            Label label6 = new Label(6, i, fonctionnaire.getLieuNaissance());
            Label label7 = new Label(7, i, fonctionnaire.getArrondNaissance());
            Label label8 = new Label(8, i, fonctionnaire.getDepartNaissance());
            Label label9 = new Label(9, i, fonctionnaire.getRegionNaissance());
            Label label10 = new Label(10, i, fonctionnaire.getArrondissementOrigine());
            Label label11 = new Label(11, i, fonctionnaire.getDepartementOrigine());
            Label label12 = new Label(12, i, fonctionnaire.getRegionOrigine());
            Label label13 = new Label(13, i, fonctionnaire.getDiplomeEntreeFoncPub());
            Label label14 = new Label(14, i, simpleDateFormat.format(fonctionnaire.getDateEntreFonctionPub()));
            Label label15 = new Label(15, i, fonctionnaire.getSexe().name());
            Label label16 = new Label(16, i, String.valueOf(fonctionnaire.isIsBornArround()));
            Label label17;
            if (fonctionnaire.getSpecialite() == null) {
                label17 = new Label(17, i, "");
            } else {
                label17 = new Label(17, i, fonctionnaire.getSpecialite().getIntituleSpecialite());
            }
            Label label18 = new Label(18, i, iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId()).getGradeFonctio().getCodeGradeFonctio());
            Label label19 = new Label(19, i, simpleDateFormat.format(iRangerFonctioService.findRangerFonctioOpenByIdAgent(fonctionnaire.getId()).getDateDebutRangerFonctio()));
            Label label20 = new Label(20, i, iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId()).getPoste().getIntitulePoste());
            Label label21 = new Label(21, i, iAffectationService.findAffectationOpenByIdAgent(fonctionnaire.getId()).getStructureAttache().getIntituleStructure());
            Label label22 = new Label(22, i, simpleDateFormat.format(iPromotionService.findPromotionOpenByIdAgent(fonctionnaire.getId()).getDateDebutPromo()));
            Label label23 = new Label(23, i, simpleDateFormat.format(fonctionnaire.getDateDelivranceCni()));
            Label label24 = new Label(24, i, fonctionnaire.getLieuDelivranceCni());
            Label label25 = new Label(25, i, fonctionnaire.getNumeroTel());
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);
            sheet.addCell(label15);
            sheet.addCell(label16);
            sheet.addCell(label17);
            sheet.addCell(label18);
            sheet.addCell(label19);
            sheet.addCell(label20);
            sheet.addCell(label21);
            sheet.addCell(label22);
            sheet.addCell(label23);
            sheet.addCell(label24);
            sheet.addCell(label25);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /*
    exportation of table contractuel
     */
    public void buildContractuelFile(String path) throws IOException, WriteException {
        // Créer un fichier excel
        File inputWorkBook = new File(path + "/contractuel.vvs");
        WritableWorkbook workbook = Workbook.createWorkbook(inputWorkBook);
        // Créer un classeur dans le fichier
        WritableSheet sheet = workbook.createSheet("Avocatic", 0);
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        int i = 0;
        for (Iterator<Contractuel> it = iContractuelService.findContractuelActif().iterator(); it.hasNext();) {
            Contractuel contractuel = it.next();
            Label label0 = new Label(0, i, contractuel.getMatricule());
            Label label1 = new Label(1, i, contractuel.getNom());
            Label label2 = new Label(2, i, contractuel.getPrenom());
            Label label3 = new Label(3, i, contractuel.getNomJeuneFille());
            Label label4 = new Label(4, i, String.valueOf(contractuel.getCni()));
            Label label5 = new Label(5, i, simpleDateFormat.format(contractuel.getDateNaissance()));
            Label label6 = new Label(6, i, contractuel.getLieuNaissance());
            Label label7 = new Label(7, i, contractuel.getArrondNaissance());
            Label label8 = new Label(8, i, contractuel.getDepartNaissance());
            Label label9 = new Label(9, i, contractuel.getRegionNaissance());
            Label label10 = new Label(10, i, contractuel.getArrondissementOrigine());
            Label label11 = new Label(11, i, contractuel.getDepartementOrigine());
            Label label12 = new Label(12, i, contractuel.getRegionOrigine());
            Label label13 = new Label(13, i, contractuel.getDiplomeEntreeFoncPub());
            Label label14 = new Label(14, i, simpleDateFormat.format(contractuel.getDateEntreFonctionPub()));
            Label label15 = new Label(15, i, contractuel.getSexe().name());
            Label label16 = new Label(16, i, String.valueOf(contractuel.isIsBornArround()));
            Label label17;
            if (contractuel.getSpecialite() == null) {
                label17 = new Label(17, i, "");
            } else {
                label17 = new Label(17, i, contractuel.getSpecialite().getIntituleSpecialite());
            }
            Label label18 = new Label(18, i, iRangerContractService.findRangerContractOpenByIdAgent(contractuel.getId()).getGradeContract().getIntituleGradeContract());
            Label label19 = new Label(19, i, simpleDateFormat.format(iRangerContractService.findRangerContractOpenByIdAgent(contractuel.getId()).getDateDebutRangerContract()));
            Label label20 = new Label(20, i, iPromotionService.findPromotionOpenByIdAgent(contractuel.getId()).getPoste().getIntitulePoste());
            Label label21 = new Label(21, i, iAffectationService.findAffectationOpenByIdAgent(contractuel.getId()).getStructureAttache().getIntituleStructure());
            Label label22 = new Label(22, i, simpleDateFormat.format(iPromotionService.findPromotionOpenByIdAgent(contractuel.getId()).getDateDebutPromo()));
            Label label23 = new Label(23, i, simpleDateFormat.format(contractuel.getDateDelivranceCni()));
            Label label24 = new Label(24, i, contractuel.getLieuDelivranceCni());
            Label label25 = new Label(25, i, contractuel.getNumeroTel());
            sheet.addCell(label0);
            sheet.addCell(label1);
            sheet.addCell(label2);
            sheet.addCell(label3);
            sheet.addCell(label4);
            sheet.addCell(label5);
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);
            sheet.addCell(label12);
            sheet.addCell(label13);
            sheet.addCell(label14);
            sheet.addCell(label15);
            sheet.addCell(label16);
            sheet.addCell(label17);
            sheet.addCell(label18);
            sheet.addCell(label19);
            sheet.addCell(label20);
            sheet.addCell(label21);
            sheet.addCell(label22);
            sheet.addCell(label23);
            sheet.addCell(label24);
            sheet.addCell(label25);
            i++;
        }
        workbook.write();
        workbook.close();
    }

    /**
     *
     * @param nomFichier nom du fichier à compresser
     * @throws java.io.FileNotFoundException
     */
    public void compresser(String nomFichier) throws FileNotFoundException, IOException {
        try {
            // lecture du fichier
            File fichier = new File(exportDirectoryPath + nomFichier);
            FileInputStream fis = new FileInputStream(fichier);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            // ajout d'une nouvelle entree dans l'archive contenant le fichier
            ZipEntry entry = new ZipEntry(nomFichier);
            entry.setTime(fichier.lastModified());
            zip.putNextEntry(entry);
            zip.write(bytes);
            // fermeture des flux
            zip.closeEntry();
            fis.close();

        } catch (FileNotFoundException fnfe) {
            throw fnfe;
        } catch (IOException ioe) {
            throw ioe;
        }
    }

    public StreamedContent getPrepDownload() throws Exception {
        exportation();
        StreamedContent download = new DefaultStreamedContent();
        File file = new File(exportParentDirectoryPath + "Fichier personnel.zip");
        InputStream input = new FileInputStream(file);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        download = new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName());
        System.out.println("PREP = " + download.getName());
        return download;
    }

    public void exportation() throws WriteException, IOException {
        try {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            File file1 = (new File(servletContext.getRealPath(""))).getParentFile();
            File file2 = new File(file1.getAbsolutePath() + "/Export/");
            file2.mkdir();
            exportParentDirectoryPath = file1.getAbsolutePath() + "/";
            exportDirectoryPath = file2.getAbsolutePath() + "/";

            //Construction des fichiers
            buildDepartFile(exportDirectoryPath);
            buildArrondFile(exportDirectoryPath);
            buildStructFile(exportDirectoryPath);
            buildSpecialiteFile(exportDirectoryPath);
            buildCadreFile(exportDirectoryPath);
            buildCategorieStructureFile(exportDirectoryPath);
            buildPosteFile(exportDirectoryPath);
            buildGradeContractFile(exportDirectoryPath);
            buildGradeFonctioFile(exportDirectoryPath);
            buildCorpsFile(exportDirectoryPath);
            buildFonctionnaireFile(exportDirectoryPath);
            buildContractuelFile(exportDirectoryPath);
        } catch (IOException | WriteException ioe) {
            throw ioe;
        }

        //création de l'archive
        zip = new ZipOutputStream(new FileOutputStream(exportParentDirectoryPath + "Fichier personnel.zip"));
        zip.setMethod(ZipOutputStream.DEFLATED);
        zip.setLevel(Deflater.BEST_COMPRESSION);

        //compression des fichier  
        File fichier = new File(exportDirectoryPath);
        for (File file : fichier.listFiles()) {
            compresser(file.getName());
        }
        //fermeture de l'archive
        zip.close();
        //suppression des fichiers déja archivés
        for (File fil : fichier.listFiles()) {
            fil.delete();
        }
        FacesMessage msg = new FacesMessage("Exportation effectuée avec succès!");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
