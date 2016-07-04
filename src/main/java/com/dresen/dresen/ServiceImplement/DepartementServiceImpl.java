/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IDepartementDao;
import com.dresen.dresen.ServiceInterface.IDepartementService;
import com.dresen.dresen.entities.Departement;
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
public class DepartementServiceImpl implements IDepartementService, Serializable {
   
    IDepartementDao iDepartementDao;

    public IDepartementDao getiDepartementDao() {
        return iDepartementDao;
    }

    public void setiDepartementDao(IDepartementDao iDepartementDao) {
        this.iDepartementDao = iDepartementDao;
    }
    
    
    public Departement createDepartement(Departement departement) throws ServiceException {
        try {
            //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iDepartementDao.create(departement);
        } catch (DataAccessException ex) {
            Logger.getLogger(DepartementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             throw new ServiceException("impossible de faire le create");
        }
    }

    public Departement findDepartementById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iDepartementDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(DepartementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             throw new ServiceException("impossible de creer le département");
        }
        
    }

    public Departement updateDepartement(Departement departement) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iDepartementDao.update(departement);
        } catch (DataAccessException ex) {
            Logger.getLogger(DepartementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             throw new ServiceException("impossible de mettre à jour le département");
        }
    }

    public List<Departement> findAllDepartement() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iDepartementDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(DepartementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
             throw new ServiceException("impossible de lister tous les dépattements");
        }
    }
}
