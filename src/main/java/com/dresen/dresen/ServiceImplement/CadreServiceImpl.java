/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.ICadreDao;
import com.dresen.dresen.ServiceInterface.ICadreService;
import com.dresen.dresen.entities.Cadre;
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
public class CadreServiceImpl implements ICadreService, Serializable {
    private ICadreDao iCadreDao;

    public ICadreDao getiCadreDao() {
        return iCadreDao;
    }

    public void setiCadreDao(ICadreDao iCadreDao) {
        this.iCadreDao = iCadreDao;
    }
    
    

    public Cadre createCadre(Cadre cadre) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCadreDao.create(cadre);
        } catch (DataAccessException ex) {
            Logger.getLogger(ArrondissementServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le cadre");
        }
    }

    public Cadre findCadreById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCadreDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(CadreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher le cadre par l'id");
        }       
    }

    public Cadre updateCadre(Cadre cadre) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCadreDao.update(cadre);
        } catch (DataAccessException ex) {
            Logger.getLogger(CadreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre à le cadre à jour");
        }        
    }    

    public List<Cadre> findAllCadre() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iCadreDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(CadreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des cadres");
        }        
    }    

    public List<Cadre> findCadreByIdCorps(long idCorps) throws ServiceException {
       try{// throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           return iCadreDao.findCadreByIdCorps(idCorps);
       }catch(DataAccessException ex){
           Logger.getLogger(CadreServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
           throw new ServiceException("impossible rechercher la liste des cadres du coprs");
       }
    }
    
}
