/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IStructureDao;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.StructureAttache;
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
public class StructureServiceImpl implements IStructureService{
    private IStructureDao iStructureDao;

    public IStructureDao getiStructureDao() {
        return iStructureDao;
    }

    public void setiStructureDao(IStructureDao iStructureDao) {
        this.iStructureDao = iStructureDao;
    }
    

    public StructureAttache createStructureAttache(StructureAttache structureAttache) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.create(structureAttache);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer la structure");
        }
    }

    public StructureAttache findStructureAttacheById(Long id) throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la structure par son id");
        }    
    }

    public StructureAttache updateStructureAttache(StructureAttache structureAttache) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.update(structureAttache);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre la Structure à jour");
        }
    }

    public List<StructureAttache> findAllStructureAttache() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des Structures");
        }      
    }
    
}
