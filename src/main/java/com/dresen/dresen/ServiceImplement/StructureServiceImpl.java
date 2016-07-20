/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceImplement;

import com.douwe.generic.dao.DataAccessException;
import com.dresen.dresen.DaoInterface.IStructureDao;
import com.dresen.dresen.ServiceInterface.IStructureService;
import com.dresen.dresen.entities.StructureAttache;
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
public class StructureServiceImpl implements IStructureService, Serializable {

    private IStructureDao iStructureDao;

    public IStructureDao getiStructureDao() {
        return iStructureDao;
    }

    public void setiStructureDao(IStructureDao iStructureDao) {
        this.iStructureDao = iStructureDao;
    }

    @Override
    public StructureAttache createStructureAttache(StructureAttache structureAttache) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.create(structureAttache);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de créer la structure");
        }
    }

    @Override
    public StructureAttache findStructureAttacheById(Long id) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de trouver la structure par son id");
        }
    }

    @Override
    public StructureAttache updateStructureAttache(StructureAttache structureAttache) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.update(structureAttache);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible de mettre la Structure à jour");
        }
    }

    @Override
    public List<StructureAttache> findAllStructureAttache() throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des Structures");
        }
    }

    @Override
    public List<StructureAttache> findStructureAttacheByCategorieAndArrondissement(long idArrondissement, long idCategorie) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.findStructureAttacheByCategorieAndArrondissement(idArrondissement, idCategorie);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la liste des Structures liées à la catégorie et à l'arrondissement spécifiées");
        }

    }

    @Override
    public StructureAttache findStructureAttacheByIntitule(String intitule) throws ServiceException {
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return iStructureDao.findStructureAttacheByIntitule(intitule);
        } catch (DataAccessException ex) {
            Logger.getLogger(StructureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException("impossible rechercher la Structure dont l'intitulé est pris en paramètre");
        }
    }

}
