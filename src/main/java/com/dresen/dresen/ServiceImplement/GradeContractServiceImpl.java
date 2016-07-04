/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IGradeContractDao;
import com.dresen.dresen.ServiceInterface.IGradeContractService;
import com.dresen.dresen.entities.GradeContract;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public class GradeContractServiceImpl implements IGradeContractService, Serializable {
    private IGradeContractDao iGradeContractDao;

    public IGradeContractDao getiGradeContractDao() {
        return iGradeContractDao;
    }

    public void setiGradeContractDao(IGradeContractDao iGradeContractDao) {
        this.iGradeContractDao = iGradeContractDao;
    }
    
    public GradeContract createGradeContract(GradeContract gradeContract) throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeContractDao.create(gradeContract);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le gradecontractuel");
        }
    }

    public GradeContract findGradeContractById(Long id) throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeContractDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver le gradecontractuel par son id");
        }
    }

    public GradeContract updateGradeContract(GradeContract gradeContract) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeContractDao.update(gradeContract);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre le gradecontractuel à jour");
        }
    }

    public List<GradeContract> findAllGradeContract() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeContractDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des gradesContracts");
        }        
    }
    
}
