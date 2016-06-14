/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Test;
import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.entities.Affectation;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.CategorieStructure;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dresen.dresen.ServiceInterface.ICategorieStructureService;

/**
 *
 * @author Vivien Saa
 */
public class TestService {
//    public static void main(String[] args) {
//        System.out.println( "Hello World!" );
//        
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");  
//        IDepartementService iDepartementService = ctx.getBean("IDepartementService", IDepartementService.class);
//        Departement dep = new Departement("logone");
//        Departement dep1;
//        dep1 = iDepartementService .createDepartement(dep);    
//        System.out.println(dep1);
//    }
    
    
//    public static void main(String[] args) {
//        System.out.println( "Hello World!" );
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");  
//        IAffectationService iAffectationService = ctx.getBean("IAffectationService", IAffectationService.class);
//        Affectation aff = new Affectation();
//        aff.setAgent(null);
//        aff.setDateDebutAffect(new Date());
//        aff.setNumeroAffectation("100100");
//        aff.setStructure(null);
//        Affectation aff1;
//        aff1 = iAffectationService .createAffectation(aff);    
//        System.out.println(aff1);
//    }
    
//    public static void main(String[] args) {
//        System.out.println( "Hello World!" );
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");  
//        IAffectationService iAffectationService = ctx.getBean("IAffectationService", IAffectationService.class);
//        Affectation aff = new Affectation();
//        aff.setAgent(null);
//        aff.setDateDebutAffect(new Date());
//        aff.setNumeroAffectation("100100");
//        aff.setStructureAttache(null);
//        List<Affectation> lisAff1;
//        lisAff1 = iAffectationService.findAllPromotionOpen();
//        System.out.println(lisAff1.get(0).getDateDebutAffect());
//    }
//     public static void main(String[] args) {
//        System.out.println( "Hello World!" );
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");  
//        ICategorieStructureService iCategorieStructureService = ctx.getBean("ICategorieStructureService", ICategorieStructureService.class);
//        CategorieStructure CategorieStructure = new CategorieStructure();
//        CategorieStructure.setIntituleCategorieStructure("Collège");
//        iCategorieStructureService.createCategorieStructure(CategorieStructure);
////        IDepartementService iDepartementService = ctx.getBean("IDepartementService", IDepartementService.class);
////        Departement departement = new Departement();
////        departement.setIntituleDepartement("diamare");
////        iDepartementService.createDepartement(departement);
////               
//    }
    
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");  
        ICategorieStructureService iCategorieStructureService = ctx.getBean("ICategorieStructureService", ICategorieStructureService.class);
        List<CategorieStructure> lisAff1;
        lisAff1 = iCategorieStructureService.findAllCategorieStructure();
        System.out.println(lisAff1.get(0).getIntituleCategorieStructure());
    }
}
