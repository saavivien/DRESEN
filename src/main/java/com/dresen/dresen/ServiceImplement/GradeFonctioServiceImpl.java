/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IGradeFonctioDao;
import com.dresen.dresen.ServiceInterface.IGradeFonctioService;
import com.dresen.dresen.entities.GradeFonctio;
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
public class GradeFonctioServiceImpl implements IGradeFonctioService, Serializable {

    private IGradeFonctioDao iGradeFonctioDao;

    public IGradeFonctioDao getiGradeFonctioDao() {
        return iGradeFonctioDao;
    }

    public void setiGradeFonctioDao(IGradeFonctioDao iGradeFonctioDao) {
        this.iGradeFonctioDao = iGradeFonctioDao;
    }

    @Override
    public GradeFonctio createGradeFonctio(GradeFonctio gradefonctio) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeFonctioDao.create(gradefonctio);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le gradefonctiionnaire");
        }
    }

    @Override
    public GradeFonctio findGradeFonctioById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeFonctioDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver le gradefonctionnaire par son id");
        }
    }

    @Override
    public GradeFonctio updateGradeFonctio(GradeFonctio gradeFonctio) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeFonctioDao.update(gradeFonctio);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre le gradefonctionnaire à jour");
        }
    }

    @Override
    public List<GradeFonctio> findAllGradeFonctio() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeFonctioDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des gradesFonctionnaires");
        }
    }

    @Override
    public List<GradeFonctio> findGradeFonctioByIdCadre(long idCadre) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeFonctioDao.findGradeFonctioByIdCadre(idCadre);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de lister les grade Fonctionnaires liés au cadre");
        }
    }

    @Override
    public GradeFonctio findGradeFonctioByIntitule(String intitule) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iGradeFonctioDao.findGradeFonctioByIntitule(intitule);
        } catch (DataAccessException ex) {
            Logger.getLogger(GradeFonctioServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de lister le grade Fonctionnaire liés par l'intitulé");
        }
    }

}
