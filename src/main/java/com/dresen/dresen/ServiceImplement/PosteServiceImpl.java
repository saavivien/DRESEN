/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IPosteDao;
import com.dresen.dresen.ServiceInterface.IPosteService;
import com.dresen.dresen.entities.Poste;
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
public class PosteServiceImpl implements IPosteService{
    private IPosteDao iPosteDao;

    public IPosteDao getiPosteDao() {
        return iPosteDao;
    }

    public void setiPosteDao(IPosteDao iPosteDao) {
        this.iPosteDao = iPosteDao;
    }
    

    public Poste createPoste(Poste poste) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteDao.create(poste);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le poste");
        }
    }

    public Poste findPosteById(Long id) throws ServiceException {
         try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver le poste par son id");
        }
    }

    public Poste updatePoste(Poste Poste) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteDao.update(Poste);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible mettre le poste à jour");
        }        
    }

    public List<Poste> findAllPoste() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des postes");
        }       
    }
    public Poste findPosteByName(String name)throws ServiceException{
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteDao.findPosteByName(name);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des postes");
        }       
    }

    public List<Poste> findPosteByCategorieStructure(long idCategorieStructure) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteDao.findPosteByCategorieStructure(idCategorieStructure);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des postes correspondant à la catégorie");
        }
    }

}
