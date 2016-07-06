/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class OrientationBean {
     
    public OrientationBean() {
    }
    public String affectation(){
        return "Affectation";
    }
    public String arrondissement(){
        return "Arrondissement";
    }
    public String departement(){
        return "Departement";
    }
    public String cadre(){
        return "Cadre";
    }
    public String contractuel(){
        return "Contractuel";
    }
    public String corps(){
        return "Corps";
    }
    public String fonctionnaire(){
        return "Fonctionnaire";
    }
    public String specialite(){
        return "Specialite";
    }
    public String promotion(){
        return "Promotion";
    }
     public String poste(){
        return "Poste";
    }
    public String structureAttache(){
        return "StructureAttache";
    }
    public String categorieStructure(){
        return "CategorieStructure";
    }
    public String gradeFonctio(){
        return "GradeFonctionnaire";
    }
    public String gradeContract(){
        return "GradeContractuel";
    }
    
    
    //// MENU AGENT
    
    public String ajouterFonctionnaire(){
        return "Fonctionnaire";
    }
}
