/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@SessionScoped
public class OrientationBean implements Serializable{

    public OrientationBean() {
    }

    public String affectation() {
        return "/Parcours/Affectation";
    }

    public String arrondissement() {
        return "/Parcours/Arrondissement";
    }

    public String departement() {
        return "/Parcours/Departement";
    }

    public String cadre() {
        return "/Parcours/Cadre";
    }

    public String corps() {
        return "/Parcours/Corps";
    }

    public String specialite() {
        return "Specialite";
    }

    public String promotion() {
        return "/Parcours/Promotion";
    }

    public String poste() {
        return "/Parcours/Poste";
    }

    public String structureAttache() {
        return "/Parcours/StructureAttache";
    }

    public String categorieStructure() {
        return "/Parcours/CategorieStructure";
    }

    public String gradeFonctio() {
        return "/Parcours/GradeFonctionnaire";
    }

    public String gradeContract() {
        return "/Parcours/GradeContractuel";
    }

    //// MENU AGENT
    public String fonctionnaire() {
        return "/Fonctionnaire/Fonctionnaire";
    }

    public String retraiteMensuelFonctio() {
        return "/Fonctionnaire/FonctionnaireRetraiteMensuel";
    }

    public String retraiteFonctionnaire() {
        return "/Fonctionnaire/FonctionnairesRetraites";
    }

    public String horsRegionFonctionnaire() {
        return "/Fonctionnaire/FonctionnairesHorsRegion";
    }

    public String contractuel() {
        return "/Contractuel/Contractuel";
    }

    public String retraiteMensuelContract() {
        return "/Contractuel/ContractuelRetraiteMensuel";
    }

    public String retraiteContractuel() {
        return "/Contractuel/ContractuelsRetraites";
    }

    public String horsRegionContractuel() {
        return "/Contractuel/ContractuelsHorsRegion";
    }
    //// MENU IMPORT EXPORT

    public String importation() {
        return "/ImportExport/Importation";
    }

    public String exportation() {
        return "/ImportExport/Exportation";
    }

}
