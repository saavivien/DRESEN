/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.ISpecialiteDao;
import com.dresen.dresen.ServiceInterface.ISpecialiteService;
import com.dresen.dresen.entities.Specialite;
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
public class SpecialiteServiceImpl implements ISpecialiteService, Serializable {

    private ISpecialiteDao iSpecialiteDao;

    public ISpecialiteDao getiSpecialiteDao() {
        return iSpecialiteDao;
    }

    public void setiSpecialiteDao(ISpecialiteDao iSpecialiteDao) {
        this.iSpecialiteDao = iSpecialiteDao;
    }

    @Override
    public Specialite createSpecialite(Specialite specialite) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iSpecialiteDao.create(specialite);
        } catch (DataAccessException ex) {
            Logger.getLogger(SpecialiteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer la specialite");
        }
    }

    @Override
    public Specialite findSpecialiteById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iSpecialiteDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(SpecialiteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la specialite par son id");
        }
    }

    @Override
    public Specialite updateSpecialite(Specialite specialite) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iSpecialiteDao.update(specialite);
        } catch (DataAccessException ex) {
            Logger.getLogger(SpecialiteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre la specialite à jour");
        }
    }

    @Override
    public List<Specialite> findAllSpecialite() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iSpecialiteDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(SpecialiteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des specialites");
        }
    }

    @Override
    public Specialite findSpecialiteByIntitule(String intitule) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iSpecialiteDao.findSpecialiteByIntitule(intitule);
        } catch (DataAccessException ex) {
            Logger.getLogger(SpecialiteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la specialité dont l'intitulé est passé en paramètre");
        }
    }

}
