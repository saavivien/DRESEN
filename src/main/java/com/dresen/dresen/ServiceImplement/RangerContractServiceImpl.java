/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IRangerContractDao;
import com.dresen.dresen.ServiceInterface.IRangerContractService;
import com.dresen.dresen.entities.RangerContract;
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
public class RangerContractServiceImpl implements IRangerContractService, Serializable {

    private IRangerContractDao iRangerContractDao;

    public IRangerContractDao getiRangerContractDao() {
        return iRangerContractDao;
    }

    public void setiRangerContractDao(IRangerContractDao iRangerContractDao) {
        this.iRangerContractDao = iRangerContractDao;
    }

    @Override
    public RangerContract createRangerContract(RangerContract rangerContract) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.create(rangerContract);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer la RangerContract");
        }
    }

    @Override
    public RangerContract findRangerContractById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la RangerContract par son id");
        }
    }

    @Override
    public RangerContract updateRangerContract(RangerContract rangerContract) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.update(rangerContract);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible mettre la RangerContract à jour");
        }
    }

    @Override
    public List<RangerContract> findAllRangerContract() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des RangerContracts");
        }
    }

    @Override
    public List<RangerContract> findRangerContractByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.findRangerContractByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des des RangerContracts d'un contractuel");
        }
    }

    @Override
    public RangerContract findRangerContractOpenByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.findRangerContractOpenByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la RangerContract ouverte de l'agent");
        }
    }

    @Override
    public List<RangerContract> findAllRangerContractOpen() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.findAllRangerContractOpen();
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher les RangerContract ouvertes");
        }
    }

    @Override
    public RangerContract findLastRangerContractByIdAgent(long idAgent) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iRangerContractDao.findLastRangerContractByIdAgent(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(RangerContractServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la dernière RangerContract");
        }
    }

}
