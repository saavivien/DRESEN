/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IContractuelDao;
import com.dresen.dresen.ServiceInterface.IContractuelService;
import com.dresen.dresen.entities.Contractuel;
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
public class ContractuelServiceImpl implements IContractuelService, Serializable {
    private IContractuelDao iContractuelDao;

    public IContractuelDao getiContractuelDao() {
        return iContractuelDao;
    }

    public void setiContractuelDao(IContractuelDao iContractuelDao) {
        this.iContractuelDao = iContractuelDao;
    }
    
    
    
    public Contractuel createContractuel(Contractuel contractuel) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iContractuelDao.create(contractuel);
        } catch (DataAccessException ex) {
            Logger.getLogger(ContractuelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le contractuel");
        }
    }

    public Contractuel findContractuelById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iContractuelDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(ContractuelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver un contractuel par son id");
        }        
    }

    public Contractuel updateContractuel(Contractuel contractuel) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iContractuelDao.update(contractuel);
        } catch (DataAccessException ex) {
            Logger.getLogger(ContractuelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre à le contractuel à jour");
        }        
    }

    public List<Contractuel> findAllContractuel() throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iContractuelDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ContractuelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la liste des contractuels");
        }    
    }

    @Override
    public List<Contractuel> findContractuelActif() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iContractuelDao.findContractuelActif();
        } catch (DataAccessException ex) {
            Logger.getLogger(ContractuelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la liste des contractuel actif");
        }
    }
    

    @Override
    public List<Contractuel> findContractuelRetraites() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iContractuelDao.findContractuelRetraites();
        } catch (DataAccessException ex) {
            Logger.getLogger(ContractuelServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la liste des contractuel Retratés");
        }
    }
    
}
