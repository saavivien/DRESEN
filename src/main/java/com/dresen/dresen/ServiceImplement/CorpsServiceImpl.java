/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.ICorpsDao;
import com.dresen.dresen.ServiceInterface.ICorpsService;
import com.dresen.dresen.entities.Corps;
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
public class CorpsServiceImpl implements ICorpsService, Serializable {

    private ICorpsDao iCorpsDao;

    public ICorpsDao getiCorpsDao() {
        return iCorpsDao;
    }

    public void setiCorpsDao(ICorpsDao iCorpsDao) {
        this.iCorpsDao = iCorpsDao;
    }

    @Override
    public Corps createCorps(Corps corps) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCorpsDao.create(corps);
        } catch (DataAccessException ex) {
            Logger.getLogger(CorpsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le corps");
        }
    }

    @Override
    public Corps findCorpsById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCorpsDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(CorpsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver le corps par son id");
        }
    }

    @Override
    public Corps updateCorps(Corps corps) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCorpsDao.update(corps);
        } catch (DataAccessException ex) {
            Logger.getLogger(CorpsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre le corps à jour");
        }
    }

    @Override
    public List<Corps> findAllCorps() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCorpsDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(CorpsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des corps");
        }
    }

    @Override
    public Corps findCorpsByIntitule(String intitule) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCorpsDao.findCorpsByIntitule(intitule);
        } catch (DataAccessException ex) {
            Logger.getLogger(CorpsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher le corps par l'intitulé");
        }
    }

}
