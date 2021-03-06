/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IPosteStructureDao;
import com.dresen.dresen.entities.PosteStructure;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.service.spi.ServiceException;
import com.dresen.dresen.ServiceInterface.IPosteStructureService;
import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public class PosteStructureServiceImpl implements IPosteStructureService, Serializable {

    private IPosteStructureDao iPosteStructureDao;

    public IPosteStructureDao getiPosteStructureDao() {
        return iPosteStructureDao;
    }

    public void setiPosteStructureDao(IPosteStructureDao iPosteStructureDao) {
        this.iPosteStructureDao = iPosteStructureDao;
    }

    public PosteStructure createPosteStructure(PosteStructure posteStructure) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteStructureDao.create(posteStructure);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le lien poste et structure");
        }
    }

    public PosteStructure findPosteStructureById(Long id) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteStructureDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le lien poste et structure");
        }
    }

    public PosteStructure updatePosteStructure(PosteStructure posteStructure) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteStructureDao.update(posteStructure);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le lien poste et structure");
        }
    }

    public List<PosteStructure> findAllPosteStructure() throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteStructureDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer le lien poste et structure");
        }
    }

    public List<PosteStructure> findPosteStructureByPoste(long idPoste) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteStructureDao.findPosteStructureByPoste(idPoste);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de lister les postes structures correspondant au poste");
        }
    }

    public void deletePosteStructureByPoste(long idAgent) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            iPosteStructureDao.deletePosteStructureByPoste(idAgent);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de supprimer les postes structures correspondant au poste");
        }
    }

    public List<PosteStructure> findPosteStructureByCategorieStructure(long idCategorie) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iPosteStructureDao.findPosteStructureByCategorieStructure(idCategorie);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de lister les postes structures correspondant au poste");
        }
    }

    public void deletePosteStructure(PosteStructure posteStructure) throws ServiceException {
        try {//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            iPosteStructureDao.delete(posteStructure);
        } catch (DataAccessException ex) {
            Logger.getLogger(PosteStructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de supprimer le postestructure");
        }

    }
}
