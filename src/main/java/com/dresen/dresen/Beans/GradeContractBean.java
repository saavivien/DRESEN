/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Beans;

import com.dresen.dresen.ServiceInterface.IGradeContractService;
import com.dresen.dresen.entities.GradeContract;
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
public class GradeContractBean {
    @ManagedProperty(value = "#{IGradeContractService}")
    private IGradeContractService iGradeContractService;
    
    private GradeContract gradeContract = new GradeContract();
    public GradeContractBean(){
     
    }

    public IGradeContractService getiGradeContractService() {
        return iGradeContractService;
    }

    public void setiGradeContractService(IGradeContractService iGradeContractService) {
        this.iGradeContractService = iGradeContractService;
    }

    public GradeContract getGradeContract() {
        return gradeContract;
    }

    public void setGradeContract(GradeContract gradeContract) {
        this.gradeContract = gradeContract;
    }
    public GradeContract createGradeContract(){
        return iGradeContractService.createGradeContract(gradeContract);
    }
    public GradeContract findGradeContractbyId(){
        return iGradeContractService.findGradeContractById(gradeContract.getIdGradeContract());
    }
     public GradeContract updateGradeContract(){
        return iGradeContractService.updateGradeContract(gradeContract);
    }
      public List<GradeContract> findAllGradeContract(){
        return iGradeContractService.findAllGradeContract();
    }
    
}
