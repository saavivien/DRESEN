/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.entities.CategorieStructure;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.service.spi.ServiceException;
import com.dresen.dresen.ServiceInterface.ICategorieStructureService;
import com.dresen.dresen.DaoInterface.ICategorieStructureDao;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public class CategorieStructureServiceImpl implements ICategorieStructureService{
    ICategorieStructureDao iCategorieStructureDao;

    public ICategorieStructureDao getiCategorieStructureDao() {
        return iCategorieStructureDao;
    }

    public void setiCategorieStructureDao(ICategorieStructureDao iCategorieStructureDao) {
        this.iCategorieStructureDao = iCategorieStructureDao;
    }

    

    public CategorieStructure createCategorieStructure(CategorieStructure categorieStructure) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCategorieStructureDao.create(categorieStructure);
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer la Catégorie de Structure");
        }    
    }

    public CategorieStructure findCategorieStructureById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCategorieStructureDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la Catégorie de Structure");
        }    
    }

    public CategorieStructure updateCategorieStructure(CategorieStructure categorieStructure) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCategorieStructureDao.update(categorieStructure);
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre à jour la Catégorie de Structure");
        }    
    }

    public List<CategorieStructure> findAllCategorieStructure() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCategorieStructureDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la liste la Catégorie de Structure");
        }    
    }

    public CategorieStructure findCategorieStructureByName(String name) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCategorieStructureDao.findCategorieStructureByName(name);
        } catch (DataAccessException ex) {
            Logger.getLogger(CategorieStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la liste la Catégorie de Structure");
        }    
    }
    
}
