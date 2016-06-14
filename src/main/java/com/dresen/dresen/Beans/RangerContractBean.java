/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.ServiceInterface.IGradeContractService;
import com.dresen.dresen.ServiceInterface.IRangerContractService;
import com.dresen.dresen.entities.Contractuel;
import com.dresen.dresen.entities.GradeContract;
import com.dresen.dresen.entities.RangerContract;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Vivien Saa
 */
@ManagedBean
@RequestScoped
public class RangerContractBean {
    @ManagedProperty(value = "#{IRangerContractService}")
    private IRangerContractService iRangerContractService;
    
    @ManagedProperty(value = "#{IGradeContractService}")
    private IGradeContractService iGradeContractService;   
    
    @ManagedProperty(value = "#IContractuelService")
    private IContractuelService iContractuelService;
   
    private long idGradeContract;
    private long idContractuel;
    private List<Contractuel> listContractuel;
    private List<GradeContract> listGradeContract;
    
    private Contractuel contractuel = new Contractuel();
    private GradeContract gradeContract= new GradeContract();
    private RangerContract rangerContract = new RangerContract();

    public RangerContractBean() {
        idGradeContract = 0L;
        idContractuel = 0L;
    }

    public IRangerContractService getiRangerContractService() {
        return iRangerContractService;
    }

    public void setiRangerContractService(IRangerContractService iRangerContractService) {
        this.iRangerContractService = iRangerContractService;
    }

    public IGradeContractService getiGradeContractService() {
        return iGradeContractService;
    }

    public void setiGradeContractService(IGradeContractService iGradeContractService) {
        this.iGradeContractService = iGradeContractService;
    }

    public IContractuelService getiContractuelService() {
        return iContractuelService;
    }

    public void setiContractuelService(IContractuelService iContractuelService) {
        this.iContractuelService = iContractuelService;
    }

    public long getIdGradeContract() {
        return idGradeContract;
    }

    public void setIdGradeContract(long idGradeContract) {
        this.idGradeContract = idGradeContract;
    }

    public long getIdContractuel() {
        return idContractuel;
    }

    public void setIdContractuel(long idContractuel) {
        this.idContractuel = idContractuel;
    }

    public List<Contractuel> getListContractuel() {
        return iContractuelService.findAllContractuel();
    }

    public void setListContractuel(List<Contractuel> listContractuel) {
        this.listContractuel = listContractuel;
    }

    public List<GradeContract> getListGradeContract() {
        return iGradeContractService.findAllGradeContract();
    }

    public void setListGradeContract(List<GradeContract> listGradeContract) {
        this.listGradeContract = listGradeContract;
    }

    public Contractuel getContractuel() {
        return contractuel;
    }

    public void setContractuel(Contractuel contractuel) {
        this.contractuel = contractuel;
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
    
    
    public RangerContract createRangerContract(){
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        contractuel = iContractuelService.findContractuelById(idContractuel);
        rangerContract.setContratuel(contractuel);
        rangerContract.setGradeContract(gradeContract);
        return iRangerContractService.createRangerContract(rangerContract);
    }
    public RangerContract findRangerContractById(){
        return iRangerContractService.findRangerContractById(rangerContract.getId());
    }
    public RangerContract updateRangerContract(){
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        contractuel = iContractuelService.findContractuelById(idContractuel);
        rangerContract.setContratuel(contractuel);
        rangerContract.setGradeContract(gradeContract);
        return iRangerContractService.updateRangerContract(rangerContract);
    }
    public List<RangerContract> findAllRangerContract(){
        return iRangerContractService.findAllRangerContract();
    }
    public RangerContract findRangerContractOpenByIdAgent(){
        gradeContract = iGradeContractService.findGradeContractById(idGradeContract);
        contractuel = iContractuelService.findContractuelById(idContractuel);
        rangerContract.setContratuel(contractuel);
        rangerContract.setGradeContract(gradeContract);
        return iRangerContractService.findRangerContractOpenByIdAgent(rangerContract.getContratuel().getId());
    }
    public List<RangerContract> findAllRangerContractOpen(){
        return iRangerContractService.findAllRangerContractOpen();
    }
    public List<RangerContract> findRangerContractByIdAgent(){
        return iRangerContractService.findRangerContractByIdAgent(rangerContract.getContratuel().getId());
    }
    
}
