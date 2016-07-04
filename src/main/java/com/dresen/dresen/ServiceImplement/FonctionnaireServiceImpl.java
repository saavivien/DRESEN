/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IFonctionnaireDao;
import com.dresen.dresen.ServiceInterface.IFonctionnaireService;
import com.dresen.dresen.entities.Fonctionnaire;
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
public class FonctionnaireServiceImpl implements IFonctionnaireService, Serializable {
    private IFonctionnaireDao iFonctionnaireDao;

    public IFonctionnaireDao getiFonctionnaireDao() {
        return iFonctionnaireDao;
    }

    public void setiFonctionnaireDao(IFonctionnaireDao iFonctionnaireDao) {
        this.iFonctionnaireDao = iFonctionnaireDao;
    } 

    public Fonctionnaire createFonctionnaire(Fonctionnaire fonctionnaire) throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iFonctionnaireDao.create(fonctionnaire);
        } catch (DataAccessException ex) {
            Logger.getLogger(CorpsServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le fonctionnaire");
        }
    }

    public Fonctionnaire findFonctionnaireById(Long id) throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iFonctionnaireDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(FonctionnaireServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver le fonctionnaire par son id");
        }
    }

    public Fonctionnaire updateFonctionnaire(Fonctionnaire fonctionnaire) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iFonctionnaireDao.update(fonctionnaire);
        } catch (DataAccessException ex) {
            Logger.getLogger(FonctionnaireServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre le fonctionnaire à jour");
        }
    }

    public List<Fonctionnaire> findAllFonctionnaire() throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iFonctionnaireDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(FonctionnaireServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des fonctionnaires");
        }        
    }
    
}
