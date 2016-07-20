/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IStructureDao;
import com.dresen.dresen.entities.StructureAttache;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class StructureDaoImpl extends GenericDao<StructureAttache, Long> implements IStructureDao, Serializable {

    @Override
    public List<StructureAttache> findStructureAttacheByCategorieAndArrondissement(long idArrondissement, long idCategorie) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("StructureAttache.findStructureAttacheByCategorieAndArrondissement").setParameter("param1", idArrondissement).setParameter("param2", idCategorie).getResultList());
    }

    @Override
    public StructureAttache findStructureAttacheByIntitule(String intitule) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (StructureAttache)(getManager().createNamedQuery("StructureAttache.findStructureAttacheByIntitule").setParameter("param", intitule).getSingleResult());
    }

}
