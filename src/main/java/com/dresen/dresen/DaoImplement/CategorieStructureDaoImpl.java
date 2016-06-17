/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.entities.CategorieStructure;
import com.dresen.dresen.DaoInterface.ICategorieStructureDao;

/**
 *
 * @author Vivien Saa
 */
public class CategorieStructureDaoImpl extends GenericDao<CategorieStructure, Long> implements ICategorieStructureDao {

    public CategorieStructure findCategorieStructureByName(String name)throws DataAccessException{
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (CategorieStructure)(getManager().createNamedQuery("CategorieStructure.findCategorieStructureByName").setParameter("param", name).getSingleResult());    
    }
    
}
