/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.ISpecialiteDao;
import com.dresen.dresen.entities.Specialite;
import java.io.Serializable;

/**
 *
 * @author Vivien Saa
 */
public class SpecialiteDaoImpl extends GenericDao<Specialite, Long> implements ISpecialiteDao, Serializable {

    @Override
    public Specialite findSpecialiteByIntitule(String intitule) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Specialite)(getManager().createNamedQuery("Specialite.findSpecialiteByIntitule").setParameter("param", intitule).getSingleResult());
    }

}
