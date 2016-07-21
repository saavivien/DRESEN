/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IRangerFonctioDao;
import com.dresen.dresen.ServiceInterface.IRangerFonctioService;
import com.dresen.dresen.entities.RangerFonctio;
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
public class RangerFonctioServiceImpl implements IRangerFonctioService, Serializable {

    private IRangerFonctioDao iRangerFonctioDao;

    public IRangerFonctioDao getiRangerFonctioDao() {
        return iRangerFonctioDao;
    }

    public void setiRangerFonctioDao(IRangerFonctioDao iRangerFonctioDao) {
        this.iRangerFonctioDao = iRangerFonctioDao;
    }

    @Override
    public RangerFonctio createRangerFonctio(RangerFonctio rangerFonctio) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.create(rangerFonctio);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer la Rangerfonctio");
        }
    }

    @Override
    public RangerFonctio findRangerFonctioById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la Rangerfonctio par son id");
        }
    }

    @Override
    public RangerFonctio updateRangerFonctio(RangerFonctio rangerFonctio) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.update(rangerFonctio);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible mettre la RangerFonctio à jour");
        }
    }

    @Override
    public List<RangerFonctio> findAllRangerFonctio() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des RangerFonctios");
        }
    }

    @Override
    public List<RangerFonctio> findRangerFonctioByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.findRangerFonctioByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des des RangerFonctios d'un contractuel");
        }
    }

    @Override
    public RangerFonctio findRangerFonctioOpenByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.findRangerFonctioOpenByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la RangerFonctio ouverte de l'agent");
        }
    }

    @Override
    public List<RangerFonctio> findAllRangerFonctioOpen() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.findAllRangerFonctioOpen();
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste de RangerFonctio ouverte");
        }
    }

    @Override
    public RangerFonctio findLastRangerFonctioByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerFonctioDao.findLastRangerFonctioByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la dernière rangerFonctio");
        }
    }

}
