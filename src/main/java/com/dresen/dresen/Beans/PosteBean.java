/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.ICategorieStructureService;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.ServiceInterface.IPosteStructureService;
import com.dresen.dresen.entities.CategorieStructure;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.PosteStructure;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class PosteBean {

    @ManagedProperty(value = "#{IPosteService}")
    private IPosteService iPosteService;
    @ManagedProperty(value = "#{ICategorieStructureService}")
    private ICategorieStructureService iCategorieStructureService;

    @ManagedProperty(value = "#{IPosteStructureService}")
    private IPosteStructureService iPosteStructureService;

    private Poste poste = new Poste();
    private PosteStructure posteStructure;
    private CategorieStructure categorieStructure = new CategorieStructure();
    private List<PosteStructure> listPosteStructures;
    private List<CategorieStructure> listCategorieStructure;
    private List<String> listCategorieStructureSelectedString = new ArrayList<String>();

    private long idCategorieStructure;

    public PosteBean() {
        idCategorieStructure = 0L;
    }

    public ICategorieStructureService getiCategorieStructureService() {
        return iCategorieStructureService;
    }

    public void setiCategorieStructureService(ICategorieStructureService iCategorieStructureService) {
        this.iCategorieStructureService = iCategorieStructureService;
    }

    public IPosteStructureService getiPosteStructureService() {
        return iPosteStructureService;
    }

    public void setiPosteStructureService(IPosteStructureService iPosteStructureService) {
        this.iPosteStructureService = iPosteStructureService;
    }

    public List<PosteStructure> listPosteStructures(Poste p) {
        return iPosteStructureService.findPosteStructureByPoste(p.getId());
    }

    public void setListPosteStructures(List<PosteStructure> listPosteStructures) {
        this.listPosteStructures = listPosteStructures;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public PosteStructure getPosteStructure() {
        return posteStructure;
    }

    public void setPosteStructure(PosteStructure posteStructure) {
        this.posteStructure = posteStructure;
    }

    public List<CategorieStructure> getListCategorieStructure() {
        return iCategorieStructureService.findAllCategorieStructure();
    }

    public void setListCategorieStructure(List<CategorieStructure> listCategorieStructure) {
        this.listCategorieStructure = listCategorieStructure;
    }

    public long getIdCategorieStructure() {
        return idCategorieStructure;
    }

    public void setIdCategorieStructure(long idCategorieStructure) {
        this.idCategorieStructure = idCategorieStructure;
    }

    public IPosteService getiPosteService() {
        return iPosteService;
    }

    public void setiPosteService(IPosteService iPosteService) {
        this.iPosteService = iPosteService;
    }

    public CategorieStructure getCategorieStructure() {
        return categorieStructure;
    }

    public void setCategorieStructure(CategorieStructure categorieStructure) {
        this.categorieStructure = categorieStructure;
    }

    public List<String> getListCategorieStructureSelectedString() {
        return listCategorieStructureSelectedString;
    }

    public void setListCategorieStructureSelectedString(List<String> listCategorieStructureSelectedString) {
        this.listCategorieStructureSelectedString = listCategorieStructureSelectedString;
    }

    public void initPost() {
        poste = new Poste();
    }

    public Poste createPoste() {
        try {
            iPosteService.createPoste(poste);
            for (String nameCatStruct : listCategorieStructureSelectedString) {
                //récupération des structures séléctionnées dans les checkbox sous forme de chaine de caractères et conversion en objets catégorieStructure
                posteStructure = new PosteStructure();
                categorieStructure = iCategorieStructureService.findCategorieStructureByName(nameCatStruct);
                posteStructure.setCategorieStructure(categorieStructure);
                posteStructure.setPoste(poste);
                iPosteStructureService.createPosteStructure(posteStructure);
            }
            FacesMessage msg = new FacesMessage("Poste enregistré avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return poste;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de l'enregistrement du poste, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public Poste findPosteById() {
        return iPosteService.findPosteById(poste.getId());
    }

    public Poste updatePoste() {
        try {
            iPosteStructureService.deletePosteStructureByPoste(poste.getId());
            iPosteService.updatePoste(poste);
            for (String nameCatStruct : listCategorieStructureSelectedString) {
                //récupération des structures séléctionnées dans les checkbox sous forme de chaine de caractères et conversion en objets catégorieStructure
                posteStructure = new PosteStructure();
                categorieStructure = iCategorieStructureService.findCategorieStructureByName(nameCatStruct);
                posteStructure.setCategorieStructure(categorieStructure);
                posteStructure.setPoste(poste);
                iPosteStructureService.createPosteStructure(posteStructure);
            }
            FacesMessage msg = new FacesMessage("Poste modifié avec succès!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return poste;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage("Echec de la modification du poste, vérifier les informations!");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            throw e;
        }
    }

    public List<Poste> findAllPoste() {
        return iPosteService.findAllPoste();
    }

}
