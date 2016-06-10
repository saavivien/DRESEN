/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IPromotionDao;
import com.dresen.dresen.ServiceInterface.IPromotionService;
import com.dresen.dresen.entities.Promotion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.service.spi.ServiceException;

/**
 *
 * @author Vivien Saa
 */
public class PromotionServiceImpl implements IPromotionService{
    private IPromotionDao iPromotionDao;

    public IPromotionDao getIPromotionDao() {
        return iPromotionDao;
    }

    public void setIPromotionDao(IPromotionDao iPromotionDao) {
        this.iPromotionDao = iPromotionDao;
    }
    
    public Promotion createPromotion(Promotion promotion) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.create(promotion);
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le promotion");
        }
    }

    public Promotion findPromotionById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la promotion par son id");
        }
    }

    public Promotion updatePromotion(Promotion promotion) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.update(promotion);
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre la promotion à jour");
        }        
    }

    public List<Promotion> findAllPromotion() throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des promotions");
        }       
    }

    public List<Promotion> findPromotionByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.findPromotionByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des promotions d'un agent");
        }       
    }

    public Promotion findPromotionOpenByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.findPromotionOpenByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la promotion ouverte de l'agent");
        }       
    }

    public List<Promotion> findAllPromotionOpen() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPromotionDao.findAllPromotionOpen();
        } catch (DataAccessException ex) {
            Logger.getLogger(PromotionServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher les promotions ouvertes");
        }          
    }
    
}
