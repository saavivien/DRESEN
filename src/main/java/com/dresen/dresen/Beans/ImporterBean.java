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
import com.dresen.dresen.entities.Corps;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.GradeContract;
import com.dresen.dresen.entities.GradeFonctio;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.PosteStructure;
import com.dresen.dresen.entities.Specialite;
import com.dresen.dresen.entities.StructureAttache;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@ViewScoped
public class ImporterBean {

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
    @ManagedProperty(value = "IFonctionnaireService")
    private IFonctionnaireService iFonctionnaireService;
    @ManagedProperty(value = "#{IContractuelService}")
    private IContractuelService iContractuelService;
    @ManagedProperty(value = "IAffectationService")
    private IAffectationService iAffectationService;
    @ManagedProperty(value = "IPromotionService")
    private IPromotionService iPromotionService;
    @ManagedProperty(value = "#{IRangerFonctioService}")
    private IRangerFonctioService iRangerFonctioService;
    @ManagedProperty(value = "#{IRangerContractService}")
    private IRangerContractService iRangerContractService;
    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    @ManagedProperty(value = "#{IPosteStructureService}")
    private IPosteStructureService iPosteStructureService;

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

    //décompression de l'archive importée
    public void decompresser(String nomArchive) {
        try {
            File export = new File("Export");
            export.mkdir();
            ZipFile zipFile = new ZipFile(nomArchive);
            Enumeration entries = zipFile.entries();
            ZipEntry entry;
            File fichier;
            while (entries.hasMoreElements()) {
                entry = (ZipEntry) entries.nextElement();
                if (!entry.isDirectory()) {
                    System.out.println("Extraction du fichier " + entry.getName());
                    fichier = new File(entry.getName());
                    int i = 0;
                    byte[] bytes = new byte[1024];
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichier));
                    BufferedInputStream in = new BufferedInputStream(zipFile
                            .getInputStream(entry));
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
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
//importation des départements pour les départements inexistants

    public void importDepart() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iDepartementService = ctx.getBean("IDepartementService", IDepartementService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/departement.vvs"));
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

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des arrondissements pour les arrondissements inexistants
    public void importArrond() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iArrondissementService = ctx.getBean("IArrondissementService", IArrondissementService.class);
        iDepartementService = ctx.getBean("IDepartementService", IDepartementService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/arrondissement.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Arrondissement> listArronds = iArrondissementService.findAllArrondissement();
            List<String> listIntituleArronds = new ArrayList<>();
            for (Arrondissement arrondissement : listArronds) {
                System.out.println(removeAccent(arrondissement.getIntituleArrondissement().toLowerCase()));
                listIntituleArronds.add(removeAccent(arrondissement.getIntituleArrondissement().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleArrond = sheet.getCell(0, i).getContents();
                if (!listIntituleArronds.contains(removeAccent(intituleArrond.toLowerCase()))) {
                    Arrondissement arrondissementImport = new Arrondissement();
                    arrondissementImport.setIntituleArrondissement(intituleArrond);
                    Departement departOfArrond = iDepartementService.findDepartementByIntitule(sheet.getCell(1, i).getContents());
                    arrondissementImport.setDepartement(departOfArrond);
                    iArrondissementService.createArrondissement(arrondissementImport);
                }
            }

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des types de structures pour les types de structures inexistants inexistants
    public void importCategorieStructure() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iCategorieStructureService = ctx.getBean("ICategorieStructureService", ICategorieStructureService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/categorieStructure.vvs"));
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

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des cadres pour les cadres inexistants
    public void importPoste() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iPosteService = ctx.getBean("IPosteService", IPosteService.class);
        iPosteStructureService = ctx.getBean("IPosteStructureService", IPosteStructureService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/poste.vvs"));
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
                        }
                    }
                }

            }

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des structures pour les structures inexistantes inexistants
    public void importStructureAttache() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iCategorieStructureService = ctx.getBean("ICategorieStructureService", ICategorieStructureService.class);
        iArrondissementService = ctx.getBean("IArrondissementService", IArrondissementService.class);
        iStructureService = ctx.getBean("IStructureService", IStructureService.class);

        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/structure.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<StructureAttache> listStructureAttaches = iStructureService.findAllStructureAttache();
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
                    Arrondissement arrondissementImport = iArrondissementService.findArrondissementByIntitule(sheet.getCell(2, i).getContents());
                    structureAttacheImport.setArrondissement(arrondissementImport);
                    CategorieStructure categorieStructure = iCategorieStructureService.findCategorieStructureByName(sheet.getCell(3, i).getContents());
                    structureAttacheImport.setCategorieStructure(categorieStructure);
                    iStructureService.createStructureAttache(structureAttacheImport);
                }
            }

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des spécialités pour les Spécialités inexistantes
    public void importSpecialite() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iSpecialiteService = ctx.getBean("ISpecialiteService", ISpecialiteService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/specialite.vvs"));
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

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des corps pour les corps inexistants
    public void importCorps() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iCorpsService = ctx.getBean("ICorpsService", ICorpsService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/gradeContract.vvs"));
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

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des cadres pour les cadres inexistants
    public void importCadre() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iCadreService = ctx.getBean("ICadreService", ICadreService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/cadre.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<Cadre> listCadres = iCadreService.findAllCadre();
            List<String> listIntituleCadres = new ArrayList<>();
            for (Cadre cadre : listCadres) {
                listIntituleCadres.add(removeAccent(cadre.getIntituleCadre().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleCadre = sheet.getCell(0, i).getContents();
                if (!listIntituleCadres.contains(removeAccent(intituleCadre.toLowerCase()))) {
                    Cadre cadreImport = new Cadre();
                    cadreImport.setIntituleCadre(intituleCadre);
                    Corps corpsImport = iCorpsService.findCorpsByIntitule(sheet.getCell(1, i).getContents());
                    cadreImport.setCorps(corpsImport);
                    iCadreService.createCadre(cadreImport);
                }
            }

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des gradeFonctios pour les gradeFonctios inexistants
    public void importGradeFonctio() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iGradeFonctioService = ctx.getBean("IGradeFonctioService", IGradeFonctioService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/gradeFonctio.vvs"));
            Sheet sheet = workbook.getSheet(0);
            List<GradeFonctio> listGradeFonctios = iGradeFonctioService.findAllGradeFonctio();
            List<String> listIntituleGradeFonctios = new ArrayList<>();
            for (GradeFonctio gradeFonctio : listGradeFonctios) {
                listIntituleGradeFonctios.add(removeAccent(gradeFonctio.getIntituleGradeFonctio().toLowerCase()));
            }
            for (int i = 0; i < sheet.getRows(); i++) {
                String intituleGradeFonctio = sheet.getCell(0, i).getContents();
                if (!listIntituleGradeFonctios.contains(removeAccent(intituleGradeFonctio.toLowerCase()))) {
                    GradeFonctio gradeFonctioImport = new GradeFonctio();
                    gradeFonctioImport.setIntituleGradeFonctio(intituleGradeFonctio);
                    Cadre cadreImport = iCadreService.findCadreByIntitule(sheet.getCell(1, i).getContents());
                    gradeFonctioImport.setCadre(cadreImport);
                    iGradeFonctioService.createGradeFonctio(gradeFonctioImport);
                }
            }

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    //importation des gradeContracts pour les gradeContracts inexistantes
    public void importGradeContract() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iGradeContractService = ctx.getBean("IGradeContractService", IGradeContractService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/gradeContract.vvs"));
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

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }
    
    //importation des fonctionnaires pour des fonctionnaires
    public void importFonctionnaire() throws IOException, BiffException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");
        iFonctionnaireService = ctx.getBean("IFonctionnaireService", IFonctionnaireService.class);
        try {
            Workbook workbook = Workbook.getWorkbook(new File("Export/fonctionnaire.vvs"));
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

        } catch (IOException ioe) {
            throw ioe;
        } catch (BiffException be) {
            throw be;
        }
    }

    public static void main(String[] args) throws IOException, BiffException {
        ImporterBean importerBean = new ImporterBean();
        importerBean.decompresser("H:/Dark blue/s2/FichierExporté.zip");
        importerBean.importArrond();
        importerBean.importDepart();
        importerBean.importPoste();
    }
}
