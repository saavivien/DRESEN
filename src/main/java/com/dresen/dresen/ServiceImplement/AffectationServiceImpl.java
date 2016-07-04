/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IAffectationDao;
import com.dresen.dresen.ServiceInterface.IAffectationService;
import com.dresen.dresen.entities.Affectation;
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
public class AffectationServiceImpl implements IAffectationService, Serializable {
    private IAffectationDao iAffectationDao;

    public IAffectationDao getiAffectationDao() {
        return iAffectationDao;
    }

    public void setiAffectationDao(IAffectationDao iAffectationDao) {
        this.iAffectationDao = iAffectationDao;
    }
    
    

    public Affectation createAffectation(Affectation affectation) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.create(affectation);
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer l'affectation");
        }
    }

    public Affectation findAffectationById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher l'affectation par l'id");
        }    
    }

    public Affectation updateAffectation(Affectation affectation) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.update(affectation);
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre à l'affectation");
        }    
    }

    public List<Affectation> findAllAffectation() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des affectations");
        }    
    }

    public List<Affectation> findAffectationByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.findAffectationByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des affectations d'un agent");
        }        
    }

    public Affectation findAffectationOpenByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.findAffectationOpenByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de rechercher l'affectation ouverte de l'agent");
        }        
    }

    public List<Affectation> findAllPromotionOpen() throws ServiceException {
        try {
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iAffectationDao.findAllAffectationOpen();
        } catch (DataAccessException ex) {
            Logger.getLogger(AffectationServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des affectations ouvertes");
        }
    }
    
}
