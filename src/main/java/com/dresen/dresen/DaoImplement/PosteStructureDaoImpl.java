/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.entities.PosteStructure;
import com.dresen.dresen.DaoInterface.IPosteStructureDao;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class PosteStructureDaoImpl extends GenericDao<PosteStructure, Long> implements IPosteStructureDao, Serializable{

    public List<PosteStructure> findPosteStructureByPoste(long idPoste) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("PosteStructure.findPosteStructureByPoste").setParameter("param", idPoste).getResultList());
    }

    public void deletePosteStructureByPoste(long idPoste) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        getManager().createNamedQuery("PosteStructure.deletePosteStructureByPoste").setParameter("param", idPoste).executeUpdate();
    }

    public List<PosteStructure> findPosteStructureByCategorieStructure(long idCategorie) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("PosteStructure.findPosteStructureByCategorieStructure").setParameter("param", idCategorie).getResultList());

    }
    
}
