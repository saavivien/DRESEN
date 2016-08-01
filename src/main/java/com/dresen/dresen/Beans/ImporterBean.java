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
import com.dresen.dresen.entities.Affectation;
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
import com.dresen.dresen.entities.Promotion;
import com.dresen.dresen.entities.RangerContract;
import com.dresen.dresen.entities.RangerFonctio;
import com.dresen.dresen.entities.Sexe;
import com.dresen.dresen.entities.Specialite;
import com.dresen.dresen.entities.StructureAttache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.NativeUploadedFile;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@ViewScoped
public class ImporterBean implements Serializable {

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
    private SimpleDateFormat simpleDateFormat;
    Contractuel contractuelImport;
    Fonctionnaire fonctionnaireImport;
    NativeUploadedFile file;
    private String importDirectoryPath;
    private String importFilePath;
    private Integer progress;

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

    public SimpleDateFormat getSimpleDateFormat() {
        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
        this.simpleDateFormat = simpleDateFormat;
    }

    public Contractuel getContractuelImport() {
        return contractuelImport;
    }

    public void setContractuelImport(Contractuel contractuelImport) {
        this.contractuelImport = contractuelImport;
    }

    public Fonctionnaire getFonctionnaireImport() {
        return fonctionnaireImport;
    }

    public void setFonctionnaireImport(Fonctionnaire fonctionnaireImport) {
        this.fonctionnaireImport = fonctionnaireImport;
    }

    public NativeUploadedFile getFile() {
        return file;
    }

    public void setFile(NativeUploadedFile file) {
        this.file = file;
    }

    public String getImportDirectoryPath() {
        return importDirectoryPath;
    }

    public void setImportDirectoryPath(String exportDirectoryPath) {
        this.importDirectoryPath = exportDirectoryPath;
    }

    public String getImportFilePath() {
        return importFilePath;
    }

    public void setImportFilePath(String exportFilePath) {
        this.importFilePath = exportFilePath;
    }

    public Integer getProgress() {
        if (progress == null) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }

        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public String removeAccent(String chaine) {

        chaine = chaine.replace('â', 'a');
        chaine = chaine.replace('â', 'a');
        chaine = chaine.replace('ä', 'a');

        chaine = chaine.replace('é', 'e');
        chaine = chaine.replace('è', 'e');
        chaine = chaine.replace('ê', 'e');
        chaine = chaine.replace('ë', 'e');

        chaine = chaine.replace('ù', 'u');
        chaine = chaine.replace('û', 'u');
        chaine = chaine.replace('ü', 'u');

        chaine = chaine.replace('î', 'i');
        chaine = chaine.replace('ï', 'i');

        chaine = chaine.replace('ô', 'o');
        chaine = chaine.replace('ö', 'o');

        return chaine;
    }

    public void upload(FileUploadEvent event) {
        progress = 0;
        // Do what you want with the file        
        try {
            //looking for target directory and create Export directory the copy the file imported 
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            File file1 = (new File(servletContext.getRealPath(""))).getParentFile();
            File file2 = new File(file1.getAbsolutePath() + "/Import/");
            file2.mkdir();
            importDirectoryPath = file2.getAbsolutePath() + "/";
            importFilePath = importDirectoryPath + event.getFile().getFileName();
            copyFile(event.getFile().getInputstream());
            progress = progress + 3;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(InputStream in) {
        try {

            try ( // write the inputStream to a FileOutputStream
                    OutputStream out = new FileOutputStream(new File(importFilePath))) {
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                in.close();
                out.flush();
            }
            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //décompression de l'archive importée
    public void decompresser(String nomArchive) throws FileNotFoundException, IOException {
        try {
            ZipFile zipFile = new ZipFile(nomArchive);
            Enumeration entries = zipFile.entries();
            ZipEntry entry;
            File fichier;
            while (entries.hasMoreElements()) {
                entry = (ZipEntry) entries.nextElement();
                if (!entry.isDirectory()) {
                    System.out.println("Extraction du fichier " + entry.getName());
                    fichier = new File(importDirectoryPath + entry.getName());
                    int i = 0;
                    byte[] bytes = new byte[1024 * 2];
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichier));
                    BufferedInputStream in = new BufferedInputStream(zipFile.getInputStream(entry));
                    while ((i = in.read(bytes)) != -1) {
                        out.write(
                                bytes,
                                0,
                                i);
                    }
                    in.close();
                    out.flush();
                    out.close();
                }
            }
            zipFile.close();
            progress = progress + 12;
        } catch (FileNotFoundException fnfe) {
            throw fnfe;
        } catch (IOException ioe) {
            throw ioe;
        }
    }
//importation des départements pour les départements inexistants

    public void importDepart() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "departement.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Departement> listDeparts = iDepartementService.findAllDepartement();
            List<String> listIntituleDeparts = new ArrayList<>();
            for (Departement departement : listDeparts) {
                listIntituleDeparts.add(removeAccent(departement.getIntituleDepartement().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleDepart = sheet.getCell(0, i).getContents();
                if (!listIntituleDeparts.contains(removeAccent(intituleDepart.toLowerCase()))) {
                    Departement departementImport = new Departement();
                    departementImport.setIntituleDepartement(intituleDepart);
                    iDepartementService.createDepartement(departementImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des arrondissements pour les arrondissements inexistants
    public void importArrond() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "arrondissement.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Arrondissement> listArronds = iArrondissementService.findAllArrondissement();
            List<Departement> listDeparts = iDepartementService.findAllDepartement();
            List<String> listIntituleArronds = new ArrayList<>();
            for (Arrondissement arrondissement : listArronds) {
                listIntituleArronds.add(removeAccent(arrondissement.getIntituleArrondissement().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleArrond = sheet.getCell(0, i).getContents();
                if (!listIntituleArronds.contains(removeAccent(intituleArrond.toLowerCase()))) {
                    Arrondissement arrondissementImport = new Arrondissement();
                    arrondissementImport.setIntituleArrondissement(intituleArrond);
                    for (Departement departement : listDeparts) {
                        if ((removeAccent(departement.getIntituleDepartement().toLowerCase())).equals(removeAccent(sheet.getCell(1, i).getContents().toLowerCase()))) {
                            Departement departImport = departement;
                            arrondissementImport.setDepartement(departImport);
                            iArrondissementService.createArrondissement(arrondissementImport);
                            break;
                        }
                    }
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des types de structures pour les types de structures inexistants inexistants
    public void importCategorieStructure() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "categorieStructure.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<CategorieStructure> listCategorieStructures = iCategorieStructureService.findAllCategorieStructure();
            List<String> listIntituleCategorieStructures = new ArrayList<>();
            for (CategorieStructure categorieStructure : listCategorieStructures) {
                listIntituleCategorieStructures.add(removeAccent(categorieStructure.getIntituleCategorieStructure().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleCategorieStructure = sheet.getCell(0, i).getContents();
                if (!listIntituleCategorieStructures.contains(removeAccent(intituleCategorieStructure.toLowerCase()))) {
                    CategorieStructure categorieStructureImport = new CategorieStructure();
                    categorieStructureImport.setIntituleCategorieStructure(intituleCategorieStructure);
                    iCategorieStructureService.createCategorieStructure(categorieStructureImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des cadres pour les cadres inexistants
    public void importPoste() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "poste.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Poste> listPostes = iPosteService.findAllPoste();
            List<String> listIntitulePostes = new ArrayList<>();

            List<PosteStructure> listPosteStructures = iPosteStructureService.findAllPosteStructure();
            PosteStructure ps;
            CategorieStructure cs = null;

            for (Poste poste : listPostes) {
                listIntitulePostes.add(removeAccent(poste.getIntitulePoste().toLowerCase()));
            }

            for (int i = 0; i < sheet.getRows(); i++) {
                //On cré les postes inexistants
                String intitulePoste = sheet.getCell(0, i).getContents();
                if (!listIntitulePostes.contains(removeAccent(intitulePoste.toLowerCase()))) {
                    Poste posteImport = new Poste();
                    posteImport.setIntitulePoste(intitulePoste);
                    posteImport.setCode(sheet.getCell(1, i).getContents());
                    iPosteService.createPoste(posteImport);
                    listPostes = iPosteService.findAllPoste();
                }
                //On cré le lien entre les postes et les types(CategorieStructure) de structures concernés avec éventuellement des mises à jour pour les postes qui n'étaient pas liés à toutes leurs catégories de structures
                List<String> listIntitulePostesByCategorieSturctures = new ArrayList<>();
                for (PosteStructure posteStructure : listPosteStructures) {
                    if (removeAccent(posteStructure.getCategorieStructure().getIntituleCategorieStructure().toLowerCase()).equals(removeAccent(sheet.getCell(2, i).getContents().toLowerCase()))) {
                        listIntitulePostesByCategorieSturctures.add(removeAccent(posteStructure.getPoste().getIntitulePoste().toLowerCase()));
                        cs = posteStructure.getCategorieStructure();
                    }
                }
                if (!listIntitulePostesByCategorieSturctures.contains(removeAccent(sheet.getCell(0, i).getContents().toLowerCase()))) {
                    for (Poste poste : listPostes) {
                        if (removeAccent(poste.getIntitulePoste().toLowerCase()).equals(removeAccent(sheet.getCell(0, i).getContents().toLowerCase()))) {
                            ps = new PosteStructure();
                            ps.setPoste(poste);
                            ps.setCategorieStructure(cs);
                            iPosteStructureService.createPosteStructure(ps);
                            break;
                        }
                    }
                }

            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des structures pour les structures inexistantes inexistants
    public void importStructureAttache() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "structure.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<StructureAttache> listStructureAttaches = iStructureService.findAllStructureAttache();
            List<Arrondissement> listArrondissements = iArrondissementService.findAllArrondissement();
            List<CategorieStructure> listCategorieStructures = iCategorieStructureService.findAllCategorieStructure();
            List<String> listIntituleStructureAttaches = new ArrayList<>();
            for (StructureAttache structureAttache : listStructureAttaches) {
                listIntituleStructureAttaches.add(removeAccent(structureAttache.getIntituleStructure().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intitulestructureAttache = sheet.getCell(0, i).getContents();
                String codeStructureImport = sheet.getCell(1, i).getContents();
                if (!listIntituleStructureAttaches.contains(removeAccent(intitulestructureAttache.toLowerCase()))) {
                    StructureAttache structureAttacheImport = new StructureAttache();
                    structureAttacheImport.setIntituleStructure(intitulestructureAttache);
                    structureAttacheImport.setCodeStructure(codeStructureImport);
                    for (Arrondissement arrondissement : listArrondissements) {
                        if ((removeAccent(arrondissement.getIntituleArrondissement().toLowerCase())).equals(removeAccent(sheet.getCell(2, i).getContents().toLowerCase()))) {
                            Arrondissement arrondissementImport = arrondissement;
                            structureAttacheImport.setArrondissement(arrondissementImport);
                            break;
                        }
                    }
                    for (CategorieStructure categorieStructure : listCategorieStructures) {
                        if ((removeAccent(categorieStructure.getIntituleCategorieStructure().toLowerCase())).equals(removeAccent(sheet.getCell(3, i).getContents().toLowerCase()))) {
                            CategorieStructure categorieStructureImport = categorieStructure;
                            structureAttacheImport.setCategorieStructure(categorieStructureImport);
                            break;
                        }
                    }
                    iStructureService.createStructureAttache(structureAttacheImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des spécialités pour les Spécialités inexistantes
    public void importSpecialite() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "specialite.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Specialite> listSpecialites = iSpecialiteService.findAllSpecialite();
            List<String> listIntituleSpecialites = new ArrayList<>();
            for (Specialite specialite : listSpecialites) {
                listIntituleSpecialites.add(removeAccent(specialite.getIntituleSpecialite().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleSpecialite = sheet.getCell(0, i).getContents();
                if (!listIntituleSpecialites.contains(removeAccent(intituleSpecialite.toLowerCase()))) {
                    Specialite specialiteImport = new Specialite();
                    specialiteImport.setIntituleSpecialite(intituleSpecialite);
                    iSpecialiteService.createSpecialite(specialiteImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des corps pour les corps inexistants
    public void importCorps() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "gradeContract.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Corps> listCorpss = iCorpsService.findAllCorps();
            List<String> listIntituleCorpss = new ArrayList<>();
            for (Corps corps : listCorpss) {
                listIntituleCorpss.add(removeAccent(corps.getIntituleCorps().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleCorps = sheet.getCell(0, i).getContents();
                if (!listIntituleCorpss.contains(removeAccent(intituleCorps.toLowerCase()))) {
                    Corps corpsImport = new Corps();
                    corpsImport.setIntituleCorps(intituleCorps);
                    iCorpsService.createCorps(corpsImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des cadres pour les cadres inexistants
    public void importCadre() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "cadre.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Cadre> listCadres = iCadreService.findAllCadre();
            List<Corps> listCorps = iCorpsService.findAllCorps();
            List<String> listIntituleCadres = new ArrayList<>();
            for (Cadre cadre : listCadres) {
                listIntituleCadres.add(removeAccent(cadre.getIntituleCadre().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleCadre = sheet.getCell(0, i).getContents();
                if (!listIntituleCadres.contains(removeAccent(intituleCadre.toLowerCase()))) {
                    Cadre cadreImport = new Cadre();
                    cadreImport.setIntituleCadre(intituleCadre);
                    for (Corps corps : listCorps) {
                        if ((removeAccent(corps.getIntituleCorps().toLowerCase())).equals(removeAccent(sheet.getCell(1, i).getContents().toLowerCase()))) {
                            Corps corpsImport = corps;
                            cadreImport.setCorps(corpsImport);
                            break;
                        }
                    }
                    iCadreService.createCadre(cadreImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des gradeFonctios pour les gradeFonctios inexistants
    public void importGradeFonctio() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "gradeFonctio.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<GradeFonctio> listGradeFonctios = iGradeFonctioService.findAllGradeFonctio();
            List<Cadre> listCadres = iCadreService.findAllCadre();
            List<String> listIntituleGradeFonctios = new ArrayList<>();
            for (GradeFonctio gradeFonctio : listGradeFonctios) {
                listIntituleGradeFonctios.add(removeAccent(gradeFonctio.getCodeGradeFonctio().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleGradeFonctio = sheet.getCell(1, i).getContents();
                if (!listIntituleGradeFonctios.contains(removeAccent(intituleGradeFonctio.toLowerCase()))) {
                    GradeFonctio gradeFonctioImport = new GradeFonctio();
                    gradeFonctioImport.setCodeGradeFonctio(intituleGradeFonctio);
                    gradeFonctioImport.setIntituleGradeFonctio(sheet.getCell(0, i).getContents());
                    for (Cadre cadre : listCadres) {
                        if ((removeAccent(cadre.getIntituleCadre().toLowerCase())).equals(removeAccent(sheet.getCell(2, i).getContents().toLowerCase()))) {
                            Cadre cadreImport = cadre;
                            gradeFonctioImport.setCadre(cadreImport);
                            break;
                        }
                    }
                    iGradeFonctioService.createGradeFonctio(gradeFonctioImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des gradeContracts pour les gradeContracts inexistantes
    public void importGradeContract() throws IOException, BiffException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "gradeContract.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<GradeContract> listGradeContracts = iGradeContractService.findAllGradeContract();
            List<String> listIntituleGradeContracts = new ArrayList<>();
            for (GradeContract gradeContract : listGradeContracts) {
                listIntituleGradeContracts.add(removeAccent(gradeContract.getIntituleGradeContract().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleGradeContract = sheet.getCell(0, i).getContents();
                if (!listIntituleGradeContracts.contains(removeAccent(intituleGradeContract.toLowerCase()))) {
                    GradeContract gradeContractImport = new GradeContract();
                    gradeContractImport.setIntituleGradeContract(intituleGradeContract);
                    iGradeContractService.createGradeContract(gradeContractImport);
                }
            }
            progress = progress + 5;
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    //importation des fonctionnaires pour des fonctionnaires
    public void importFonctionnaire(int typeImport) throws IOException, BiffException, ParseException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "fonctionnaire.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Fonctionnaire> listAllFonctionnaires;
            if (typeImport == 1) {
                for (Fonctionnaire fonc : iFonctionnaireService.findFonctionnaireActif()) {
                    Promotion prom = iPromotionService.findPromotionOpenByIdAgent(fonc.getId());
                    Affectation affec = iAffectationService.findAffectationOpenByIdAgent(fonc.getId());
                    Date date = new Date();
                    prom.setDateFinPromo(date);
                    affec.setDateFinAffect(date);
                    iPromotionService.updatePromotion(prom);
                    iAffectationService.updateAffectation(affec);
                }
                listAllFonctionnaires = iFonctionnaireService.findAllFonctionnaire();
                listAllFonctionnaires.removeAll(iFonctionnaireService.findFonctionnaireRetraites());
            } else {
                listAllFonctionnaires = iFonctionnaireService.findFonctionnaireActif();
            }

            List<Specialite> listSpecialites = iSpecialiteService.findAllSpecialite();
            List<GradeFonctio> listGradeFonctios = iGradeFonctioService.findAllGradeFonctio();
            List<StructureAttache> listStructureAttaches = iStructureService.findAllStructureAttache();
            List<Poste> listPostes = iPosteService.findAllPoste();

            RangerFonctio rangerFonctio = new RangerFonctio();
            Affectation affectation = new Affectation();
            Promotion promotion = new Promotion();
            RangerFonctio rangerFonctioImport;
            Affectation affectationImport;
            Promotion promotionImport;

            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            List<String> listMatricules = new ArrayList<>();
            List<Integer> listNumCnis = new ArrayList<>();
            for (Fonctionnaire fonctionnaire : listAllFonctionnaires) {
                listMatricules.add(fonctionnaire.getMatricule().trim().toUpperCase());
                listNumCnis.add(fonctionnaire.getCni());
            }

            for (int i = 0; i < sheet.getRows(); i++) {
                String matricule = sheet.getCell(0, i).getContents();
                int numCni = Integer.parseInt(sheet.getCell(4, i).getContents());
                /**
                 * si le fonctionnaire n'avait jamais été importé ou crée (si
                 * son matricule n'est pas enregistré) ou s'il existe et est
                 * court(ECI ou autre sigle pour les agents en cours
                 * d'intégration) et que son numéro de cni est inesistant
                 *
                 */
                if ((!listMatricules.contains(matricule.trim().toUpperCase())) || ((matricule.trim().length() < 4) && (!listNumCnis.contains(numCni)))) {
                    fonctionnaireImport = new Fonctionnaire();
                    fonctionnaireImport.setMatricule(matricule);
                    fonctionnaireImport.setNom(sheet.getCell(1, i).getContents());
                    fonctionnaireImport.setPrenom(sheet.getCell(2, i).getContents());
                    fonctionnaireImport.setNomJeuneFille(sheet.getCell(3, i).getContents());
                    fonctionnaireImport.setCni(numCni);
                    fonctionnaireImport.setDateNaissance(simpleDateFormat.parse(sheet.getCell(5, i).getContents()));
                    fonctionnaireImport.setLieuNaissance(sheet.getCell(6, i).getContents());
                    fonctionnaireImport.setArrondNaissance(sheet.getCell(7, i).getContents());
                    fonctionnaireImport.setDepartNaissance(sheet.getCell(8, i).getContents());
                    fonctionnaireImport.setRegionNaissance(sheet.getCell(9, i).getContents());
                    fonctionnaireImport.setArrondissementOrigine(sheet.getCell(10, i).getContents());
                    fonctionnaireImport.setDepartementOrigine(sheet.getCell(11, i).getContents());
                    fonctionnaireImport.setRegionOrigine(sheet.getCell(12, i).getContents());
                    fonctionnaireImport.setDiplomeEntreeFoncPub(sheet.getCell(13, i).getContents());
                    fonctionnaireImport.setDateEntreFonctionPub(simpleDateFormat.parse(sheet.getCell(14, i).getContents()));
                    fonctionnaireImport.setSexe(Sexe.valueOf(sheet.getCell(15, i).getContents()));
                    fonctionnaireImport.setIsBornArround(Boolean.valueOf(sheet.getCell(16, i).getContents()));
                    fonctionnaireImport.setDateDelivranceCni(simpleDateFormat.parse(sheet.getCell(23, i).getContents()));
                    fonctionnaireImport.setLieuDelivranceCni(sheet.getCell(24, i).getContents());
                    fonctionnaireImport.setNumeroTel(sheet.getCell(25, i).getContents());
                    iFonctionnaireService.createFonctionnaire(fonctionnaireImport);

                    for (Specialite specialite : listSpecialites) {
                        if (removeAccent(specialite.getIntituleSpecialite().toLowerCase()).equals(removeAccent(sheet.getCell(17, i).getContents().toLowerCase()))) {
                            fonctionnaireImport.setSpecialite(specialite);
                            iFonctionnaireService.updateFonctionnaire(fonctionnaireImport);
                        }
                    }
                    for (GradeFonctio gradeFonctio : listGradeFonctios) {
                        if (removeAccent(gradeFonctio.getCodeGradeFonctio().toLowerCase()).equals(removeAccent(sheet.getCell(18, i).getContents().toLowerCase()))) {
                            rangerFonctioImport = new RangerFonctio();
                            rangerFonctioImport.setFonctionnaire(fonctionnaireImport);
                            rangerFonctioImport.setGradeFonctio(gradeFonctio);
                            rangerFonctioImport.setDateDebutRangerFonctio(simpleDateFormat.parse(sheet.getCell(19, i).getContents()));
                            iRangerFonctioService.createRangerFonctio(rangerFonctioImport);
                            break;
                        }
                    }
                    for (Poste poste : listPostes) {
                        if (removeAccent(poste.getIntitulePoste().toLowerCase()).equals(removeAccent(sheet.getCell(20, i).getContents().toLowerCase()))) {
                            promotionImport = new Promotion();
                            promotionImport.setAgent(fonctionnaireImport);
                            promotionImport.setPoste(poste);
                            promotionImport.setDateDebutPromo(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                            iPromotionService.createPromotion(promotionImport);
                            break;
                        }
                    }
                    for (StructureAttache structureAttache : listStructureAttaches) {
                        if (removeAccent(structureAttache.getIntituleStructure().toLowerCase()).equals(removeAccent(sheet.getCell(21, i).getContents().toLowerCase()))) {
                            affectationImport = new Affectation();
                            affectationImport.setAgent(fonctionnaireImport);
                            affectationImport.setStructureAttache(structureAttache);
                            affectationImport.setDateDebutAffect(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                            iAffectationService.createAffectation(affectationImport);
                            break;
                        }
                    }

                } // si le fonctionnaire exite, ses données sont mise à jours
                else {
                    fonctionnaireImport = null;
                    if ((matricule.trim().length() > 4)) {

                        for (Fonctionnaire fonctionnaire : listAllFonctionnaires) {
                            if ((fonctionnaire.getMatricule().trim().replace('-', ' ').toUpperCase()).equals(matricule.trim().replace('-', ' ').toUpperCase())) {
                                promotion = iPromotionService.findLastPromotionByIdAgent(fonctionnaire.getId());
                                affectation = iAffectationService.findLastAffectationByIdAgent(fonctionnaire.getId());
                                rangerFonctio = iRangerFonctioService.findLastRangerFonctioByIdAgent(fonctionnaire.getId());
                                break;
                            }
                        }
                    } else {
                        for (Fonctionnaire fonctionnaire : listAllFonctionnaires) {
                            if (fonctionnaire.getCni() == numCni) {
                                promotion = iPromotionService.findLastPromotionByIdAgent(fonctionnaire.getId());
                                affectation = iAffectationService.findLastAffectationByIdAgent(fonctionnaire.getId());
                                rangerFonctio = iRangerFonctioService.findLastRangerFonctioByIdAgent(fonctionnaire.getId());
                                break;
                            }
                        }
                    }
                    //mise à jour du poste/fonction et de la structure d'attache                    
                    if ((removeAccent(promotion.getPoste().getIntitulePoste().toLowerCase())).equals(removeAccent(sheet.getCell(20, i).getContents().toLowerCase()))
                            && (removeAccent(affectation.getStructureAttache().getIntituleStructure().toLowerCase())).equals(removeAccent(sheet.getCell(21, i).getContents().toLowerCase()))) {
                        promotion.setDateFinPromo(null);
                        affectation.setDateFinAffect(null);
                        iPromotionService.updatePromotion(promotion);
                        iAffectationService.updateAffectation(affectation);
                    } else {
                        for (Poste poste : listPostes) {
                            if (removeAccent(poste.getIntitulePoste().toLowerCase()).equals(removeAccent(sheet.getCell(20, i).getContents().toLowerCase()))) {
                                promotionImport = new Promotion();
                                promotionImport.setAgent(fonctionnaireImport);
                                promotionImport.setPoste(poste);
                                promotionImport.setDateDebutPromo(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                                promotion.setDateFinPromo(promotionImport.getDateDebutPromo());
                                iPromotionService.createPromotion(promotionImport);
                                iPromotionService.updatePromotion(promotion);
                                break;
                            }
                        }
                        for (StructureAttache structureAttache : listStructureAttaches) {
                            if (removeAccent(structureAttache.getIntituleStructure().toLowerCase()).equals(removeAccent(sheet.getCell(21, i).getContents().toLowerCase()))) {
                                affectationImport = new Affectation();
                                affectationImport.setAgent(fonctionnaireImport);
                                affectationImport.setStructureAttache(structureAttache);
                                affectationImport.setDateDebutAffect(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                                affectation.setDateFinAffect(affectationImport.getDateDebutAffect());
                                iAffectationService.createAffectation(affectationImport);
                                iAffectationService.updateAffectation(affectation);
                                break;
                            }
                        }

                    }

                    //mise à jour du grade et de la structure d'attache
                    if (!(removeAccent(rangerFonctio.getGradeFonctio().getCodeGradeFonctio().toLowerCase())).equals(removeAccent(sheet.getCell(18, i).getContents().toLowerCase()))) {
                        for (GradeFonctio gradeFonctio : listGradeFonctios) {
                            if (removeAccent(gradeFonctio.getCodeGradeFonctio().toLowerCase()).equals(removeAccent(sheet.getCell(18, i).getContents().toLowerCase()))) {
                                rangerFonctioImport = new RangerFonctio();
                                rangerFonctioImport.setFonctionnaire(fonctionnaireImport);
                                rangerFonctioImport.setGradeFonctio(gradeFonctio);
                                rangerFonctioImport.setDateDebutRangerFonctio(simpleDateFormat.parse(sheet.getCell(19, i).getContents()));
                                rangerFonctio.setDateFinRangerFonctio(rangerFonctioImport.getDateDebutRangerFonctio());
                                iRangerFonctioService.createRangerFonctio(rangerFonctioImport);
                                iRangerFonctioService.updateRangerFonctio(rangerFonctio);
                                break;
                            }
                        }

                    }

                }
            }
            progress = progress + 25;
        } catch (IOException | BiffException | ParseException ioe) {
            throw ioe;
        }
    }

    //importation des contractuels pour des contractuels
    public void importContractuel(int typeImport) throws IOException, BiffException, ParseException {

        try {
            Workbook workbook = Workbook.getWorkbook(new File(importDirectoryPath + "contractuel.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Contractuel> listAllContractuels;
            if (typeImport == 1) {
                for (Contractuel contract : iContractuelService.findContractuelActif()) {
                    Promotion prom = iPromotionService.findPromotionOpenByIdAgent(contract.getId());
                    Affectation affect = iAffectationService.findAffectationOpenByIdAgent(contract.getId());
                    Date date = new Date();
                    prom.setDateFinPromo(date);
                    affect.setDateFinAffect(date);
                    iPromotionService.updatePromotion(prom);
                    iAffectationService.updateAffectation(affect);
                }
                listAllContractuels = iContractuelService.findAllContractuel();
                listAllContractuels.removeAll(iContractuelService.findContractuelRetraites());
            } else {
                listAllContractuels = iContractuelService.findContractuelActif();
            }
            List<Specialite> listSpecialites = iSpecialiteService.findAllSpecialite();
            List<GradeContract> listGradeContracts = iGradeContractService.findAllGradeContract();
            List<StructureAttache> listStructureAttaches = iStructureService.findAllStructureAttache();
            List<Poste> listPostes = iPosteService.findAllPoste();

            RangerContract rangerContract = new RangerContract();
            Affectation affectation = new Affectation();
            Promotion promotion = new Promotion();
            RangerContract rangerContractImport;
            Affectation affectationImport;
            Promotion promotionImport;

            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            List<String> listMatricules = new ArrayList<>();
            List<Integer> listNumCnis = new ArrayList<>();
            for (Contractuel contractuel : listAllContractuels) {
                listMatricules.add(contractuel.getMatricule().trim().toUpperCase());
                listNumCnis.add(contractuel.getCni());
            }

            for (int i = 0; i < sheet.getRows(); i++) {
                String matricule = sheet.getCell(0, i).getContents();
                int numCni = Integer.parseInt(sheet.getCell(4, i).getContents());
                /**
                 * si le contractuel n'avait jamais été importé ou crée (si son
                 * matricule n'est pas enregistré) ou s'il existe et est
                 * court(ECI ou autre sigle pour les agents en cours
                 * d'intégration) et que son numéro de cni est inesistant
                 *
                 */
                if (!listMatricules.contains(matricule.trim().toUpperCase()) || ((matricule.trim().length() < 4) && (!listNumCnis.contains(numCni)))) {
                    contractuelImport = new Contractuel();
                    contractuelImport.setMatricule(matricule);
                    contractuelImport.setNom(sheet.getCell(1, i).getContents());
                    contractuelImport.setPrenom(sheet.getCell(2, i).getContents());
                    contractuelImport.setNomJeuneFille(sheet.getCell(3, i).getContents());
                    contractuelImport.setCni(numCni);
                    contractuelImport.setDateNaissance(simpleDateFormat.parse(sheet.getCell(5, i).getContents()));
                    contractuelImport.setLieuNaissance(sheet.getCell(6, i).getContents());
                    contractuelImport.setArrondNaissance(sheet.getCell(7, i).getContents());
                    contractuelImport.setDepartNaissance(sheet.getCell(8, i).getContents());
                    contractuelImport.setRegionNaissance(sheet.getCell(9, i).getContents());
                    contractuelImport.setArrondissementOrigine(sheet.getCell(10, i).getContents());
                    contractuelImport.setDepartementOrigine(sheet.getCell(11, i).getContents());
                    contractuelImport.setRegionOrigine(sheet.getCell(12, i).getContents());
                    contractuelImport.setDiplomeEntreeFoncPub(sheet.getCell(13, i).getContents());
                    contractuelImport.setDateEntreFonctionPub(simpleDateFormat.parse(sheet.getCell(14, i).getContents()));
                    contractuelImport.setSexe(Sexe.valueOf(sheet.getCell(15, i).getContents()));
                    contractuelImport.setIsBornArround(Boolean.valueOf(sheet.getCell(16, i).getContents()));
                    contractuelImport.setDateDelivranceCni(simpleDateFormat.parse(sheet.getCell(23, i).getContents()));
                    contractuelImport.setLieuDelivranceCni(sheet.getCell(24, i).getContents());
                    contractuelImport.setNumeroTel(sheet.getCell(25, i).getContents());
                    iContractuelService.createContractuel(contractuelImport);

                    for (Specialite specialite : listSpecialites) {
                        if (removeAccent(specialite.getIntituleSpecialite().toLowerCase()).equals(removeAccent(sheet.getCell(17, i).getContents().toLowerCase()))) {
                            contractuelImport.setSpecialite(specialite);
                            iContractuelService.updateContractuel(contractuelImport);
                        }
                    }
                    for (GradeContract gradeContract : listGradeContracts) {
                        if (removeAccent(gradeContract.getIntituleGradeContract().toLowerCase()).equals(removeAccent(sheet.getCell(18, i).getContents().toLowerCase()))) {
                            rangerContractImport = new RangerContract();
                            rangerContractImport.setContractuel(contractuelImport);
                            rangerContractImport.setGradeContract(gradeContract);
                            rangerContractImport.setDateDebutRangerContract(simpleDateFormat.parse(sheet.getCell(19, i).getContents()));
                            iRangerContractService.createRangerContract(rangerContractImport);
                            break;
                        }
                    }
                    for (Poste poste : listPostes) {
                        if (removeAccent(poste.getIntitulePoste().toLowerCase()).equals(removeAccent(sheet.getCell(20, i).getContents().toLowerCase()))) {
                            promotionImport = new Promotion();
                            promotionImport.setAgent(contractuelImport);
                            promotionImport.setPoste(poste);
                            promotionImport.setDateDebutPromo(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                            iPromotionService.createPromotion(promotionImport);
                            break;
                        }
                    }
                    for (StructureAttache structureAttache : listStructureAttaches) {
                        if (removeAccent(structureAttache.getIntituleStructure().toLowerCase()).equals(removeAccent(sheet.getCell(21, i).getContents().toLowerCase()))) {
                            affectationImport = new Affectation();
                            affectationImport.setAgent(contractuelImport);
                            affectationImport.setStructureAttache(structureAttache);
                            affectationImport.setDateDebutAffect(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                            iAffectationService.createAffectation(affectationImport);
                            break;
                        }
                    }

                } // si le contractuel exite, ses données sont mise à jours
                else {
                    contractuelImport = null;
                    if ((matricule.trim().length() > 4)) {

                        for (Contractuel contractuel : listAllContractuels) {
                            if ((contractuel.getMatricule().trim().replace('-', ' ').toUpperCase()).equals(matricule.trim().replace('-', ' ').toUpperCase())) {
                                promotion = iPromotionService.findLastPromotionByIdAgent(contractuel.getId());
                                affectation = iAffectationService.findLastAffectationByIdAgent(contractuel.getId());
                                rangerContract = iRangerContractService.findLastRangerContractByIdAgent(contractuel.getId());
                                break;
                            }
                        }
                    } else {
                        for (Contractuel contractuel : listAllContractuels) {
                            if (contractuel.getCni() == numCni) {
                                promotion = iPromotionService.findLastPromotionByIdAgent(contractuel.getId());
                                affectation = iAffectationService.findLastAffectationByIdAgent(contractuel.getId());
                                rangerContract = iRangerContractService.findLastRangerContractByIdAgent(contractuel.getId());
                                break;
                            }
                        }
                    }
                    //mise à jour du poste/fonction et de la structure d'attache

                    if ((removeAccent(promotion.getPoste().getIntitulePoste().toLowerCase())).equals(removeAccent(sheet.getCell(20, i).getContents().toLowerCase()))
                            && (removeAccent(affectation.getStructureAttache().getIntituleStructure().toLowerCase())).equals(removeAccent(sheet.getCell(21, i).getContents().toLowerCase()))) {
                        promotion.setDateFinPromo(null);
                        affectation.setDateFinAffect(null);
                        iPromotionService.updatePromotion(promotion);
                        iAffectationService.updateAffectation(affectation);
                    } else {
                        for (Poste poste : listPostes) {
                            if (removeAccent(poste.getIntitulePoste().toLowerCase()).equals(removeAccent(sheet.getCell(20, i).getContents().toLowerCase()))) {
                                promotionImport = new Promotion();
                                promotionImport.setAgent(contractuelImport);
                                promotionImport.setPoste(poste);
                                promotionImport.setDateDebutPromo(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                                promotion.setDateFinPromo(promotionImport.getDateDebutPromo());
                                iPromotionService.createPromotion(promotionImport);
                                iPromotionService.updatePromotion(promotion);
                                break;
                            }
                        }
                        for (StructureAttache structureAttache : listStructureAttaches) {
                            if (removeAccent(structureAttache.getIntituleStructure().toLowerCase()).equals(removeAccent(sheet.getCell(21, i).getContents().toLowerCase()))) {
                                affectationImport = new Affectation();
                                affectationImport.setAgent(contractuelImport);
                                affectationImport.setStructureAttache(structureAttache);
                                affectationImport.setDateDebutAffect(simpleDateFormat.parse(sheet.getCell(22, i).getContents()));
                                affectation.setDateFinAffect(affectationImport.getDateDebutAffect());
                                iAffectationService.createAffectation(affectationImport);
                                iAffectationService.updateAffectation(affectation);
                                break;
                            }
                        }
                    }

                    //mise à jour du grade et de la structure d'attache
                    if (!(removeAccent(rangerContract.getGradeContract().getIntituleGradeContract().toLowerCase())).equals(removeAccent(sheet.getCell(18, i).getContents().toLowerCase()))) {
                        for (GradeContract gradeContract : listGradeContracts) {
                            if (removeAccent(gradeContract.getIntituleGradeContract().toLowerCase()).equals(removeAccent(sheet.getCell(18, i).getContents().toLowerCase()))) {
                                rangerContractImport = new RangerContract();
                                rangerContractImport.setContractuel(contractuelImport);
                                rangerContractImport.setGradeContract(gradeContract);
                                rangerContractImport.setDateDebutRangerContract(simpleDateFormat.parse(sheet.getCell(19, i).getContents()));
                                rangerContract.setDateFinRangerContract(rangerContractImport.getDateDebutRangerContract());
                                iRangerContractService.createRangerContract(rangerContractImport);
                                iRangerContractService.updateRangerContract(rangerContract);
                                break;
                            }
                        }

                    }

                }
            }
            progress = progress + 10;
        } catch (IOException | BiffException | ParseException ioe) {
            throw ioe;
        }
    }

    public void importation1(FileUploadEvent event) throws IOException, BiffException, ParseException {
        try {
            upload(event);
            decompresser(importFilePath);
            importDepart();
            importArrond();
            importCategorieStructure();
            importCorps();
            importCadre();
            importGradeFonctio();
            importGradeContract();
            importSpecialite();
            importStructureAttache();
            importPoste();
            importFonctionnaire(1);
            importContractuel(1);
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    public void importation2(FileUploadEvent event) throws IOException, BiffException, ParseException {
        try {
            upload(event);
            decompresser(importFilePath);
            importDepart();
            importArrond();
            importCategorieStructure();
            importCorps();
            importCadre();
            importGradeFonctio();
            importGradeContract();
            importSpecialite();
            importStructureAttache();
            importPoste();
            importFonctionnaire(2);
            importContractuel(2);
        } catch (IOException | BiffException ioe) {
            throw ioe;
        }
    }

    public void onComplete() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Importation terminé"));
    }

    public void cancel() {
        progress = null;
    }

//    public static void main(String[] args) throws IOException, BiffException, ParseException {
//        ImporterBean importerBean = new ImporterBean();
//        importerBean.importation("H:/Dark blue/s2/FichierExporté.zip");
//    }
}
