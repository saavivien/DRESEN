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
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:Spring-Config.xml");  
        IAffectationService iAffectationService = ctx.getBean("IAffectationService", IAffectationService.class);
        Affectation aff = new Affectation();
        aff.setAgent(null);
        aff.setDateDebutAffect(new Date());
        aff.setNumeroAffectation("100100");
        aff.setStructure(null);
        List<Affectation> lisAff1;
        lisAff1 = iAffectationService.findAllPromotionOpen();
        System.out.println(lisAff1.get(0).getDateDebutAffect());
    }
}
