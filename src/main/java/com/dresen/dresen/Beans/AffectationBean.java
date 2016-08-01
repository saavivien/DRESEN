/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.Affectation;
import com.dresen.dresen.entities.Agentp;
import com.dresen.dresen.entities.Contractuel;
import com.dresen.dresen.entities.Fonctionnaire;
import com.dresen.dresen.entities.StructureAttache;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.hibernate.service.spi.ServiceException;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class AffectationBean {

    @ManagedProperty(value = "#{IAffectationService}")
    private IAffectationService iAffectationService;

    @ManagedProperty(value = "#{IFonctionnaireService}")
    private IFonctionnaireService iFonctionnaireService;

    @ManagedProperty(value = "#{IContractuelService}")
    private IContractuelService iContractuelService;

    @ManagedProperty(value = "#{IStructureService}")
    private IStructureService iStructureService;

    Affectation affectation = new Affectation();

    List<Fonctionnaire> listFonctionnaire;
    List<Contractuel> listContractuel;
    List<StructureAttache> listStructure;

    private long idFonctionnaire;
    private long idContractuel;
    private long idService;
    private long idStructure;

    public AffectationBean() {
        idFonctionnaire = 0L;
        idContractuel = 0L;
        idService = 0L;
        idStructure = 0L;
    }

    public IAffectationService getiAffectationService() {
        return iAffectationService;
    }

    public void setiAffectationService(IAffectationService iAffectationService) {
        this.iAffectationService = iAffectationService;
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

    public IStructureService getiStructureService() {
        return iStructureService;
    }

    public void setiStructureService(IStructureService iStructureService) {
        this.iStructureService = iStructureService;
    }

    public Affectation getAffectation() {
        return affectation;
    }

    public void setAffectation(Affectation affectation) {
        this.affectation = affectation;
    }

    public List<Fonctionnaire> getListFonctionnaire() {
        return iFonctionnaireService.findAllFonctionnaire();
    }

    public void setListFonctionnaire(List<Fonctionnaire> listFonctionnaire) {
        this.listFonctionnaire = listFonctionnaire;
    }

    public List<Contractuel> getListContractuel() {
        return iContractuelService.findAllContractuel();
    }

    public void setListContractuel(List<Contractuel> listContractuel) {
        this.listContractuel = listContractuel;
    }

    public List<StructureAttache> getListStructure() {
        return iStructureService.findAllStructureAttache();
    }

    public void setListStructure(List<StructureAttache> listStructure) {
        this.listStructure = listStructure;
    }

    public long getIdFonctionnaire() {
        return idFonctionnaire;
    }

    public void setIdFonctionnaire(long idFonctionnaire) {
        this.idFonctionnaire = idFonctionnaire;
    }

    public long getIdContractuel() {
        return idContractuel;
    }

    public void setIdContractuel(long idContractuel) {
        this.idContractuel = idContractuel;
    }

    public long getIdService() {
        return idService;
    }

    public void setIdService(long idService) {
        this.idService = idService;
    }

    public long getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(long idStructure) {
        this.idStructure = idStructure;
    }

    public Affectation creAffectation() throws ServiceException {
        Agentp agent = new Agentp();
        StructureAttache structureAttache = new StructureAttache();
        agent = iContractuelService.findContractuelById(idContractuel);
        if (agent == null) {
            agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        }
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        affectation.setAgent(agent);
        affectation.setStructureAttache(structureAttache);
        Affectation affectationOpened = this.findAffectationOpenByIdAgent();
        if (affectationOpened != null) {
            affectationOpened.setDateFinAffect(affectation.getDateDebutAffect());
        }
        return iAffectationService.createAffectation(affectation);

    }

    public Affectation findAffectationById() {
        return iAffectationService.findAffectationById(affectation.getId());
    }

    public Affectation updateAffectation() {
        Agentp agent = new Agentp();
        StructureAttache structureAttache = new StructureAttache();
        agent = iContractuelService.findContractuelById(idContractuel);
        if (agent == null) {
            agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        }
        structureAttache = iStructureService.findStructureAttacheById(idStructure);
        affectation.setAgent(agent);
        affectation.setStructureAttache(structureAttache);
        return iAffectationService.updateAffectation(affectation);
    }

    public List<Affectation> finAllAffectations() {
        return iAffectationService.findAllAffectation();
    }

    public List<Affectation> findAffectationByIdAgent() {
        Agentp agent = new Agentp();
        agent = iContractuelService.findContractuelById(idContractuel);
        if (agent == null) {
            agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        }
        return iAffectationService.findAffectationByIdAgent(agent.getId());
    }

    public Affectation findAffectationOpenByIdAgent() {
        Agentp agent = new Agentp();
        agent = iContractuelService.findContractuelById(idContractuel);
        if (agent == null) {
            agent = iFonctionnaireService.findFonctionnaireById(idFonctionnaire);
        }
        return iAffectationService.findAffectationOpenByIdAgent(agent.getId());
    }

    public List<Affectation> findAllAffectationOpened() {
        return iAffectationService.findAllAffectationOpen();
    }
}
