/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IArrondissementDao;
import com.dresen.dresen.ServiceInterface.IArrondissementService;
import com.dresen.dresen.entities.Arrondissement;
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
public class ArrondissementServiceImpl implements IArrondissementService, Serializable {

    private IArrondissementDao iArrondissementDao;

    public IArrondissementDao getiArrondissementDao() {
        return iArrondissementDao;
    }

    public void setiArrondissementDao(IArrondissementDao iArrondissementDao) {
        this.iArrondissementDao = iArrondissementDao;
    }

    @Override
    public Arrondissement createArrondissement(Arrondissement arrondissement) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iArrondissementDao.create(arrondissement);
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer l'arrondissement");
        }
    }

    @Override
    public Arrondissement findArrondissementById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iArrondissementDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher l'arrondissement par l'id");
        }
    }

    @Override
    public Arrondissement updateArrondissement(Arrondissement arrondissement) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iArrondissementDao.update(arrondissement);
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre à l'arrondissement");
        }
    }

    @Override
    public List<Arrondissement> findAllArrondissement() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iArrondissementDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des arrondissements");
        }
    }

    @Override
    public List<Arrondissement> findArrondissementByIdDepart(long idDepart) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iArrondissementDao.findArrondissementByIdDepart(idDepart);
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des arrondissements du département");
        }
    }

    @Override
    public Arrondissement findArrondissementByIntitule(String intitule) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iArrondissementDao.findArrondissementByIntitule(intitule);
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher l'arrondissements par l'intitulé");
        }
    }

}
