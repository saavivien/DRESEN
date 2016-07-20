/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.ICorpsDao;
import com.dresen.dresen.entities.Corps;
import java.io.Serializable;

/**
 *
 * @author Vivien Saa
 */
public class CorpsDaoImpl extends GenericDao<Corps, Long> implements ICorpsDao, Serializable{

    @Override
    public Corps findCorpsByIntitule(String intitule) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Corps)(getManager().createNamedQuery("Corps.findCorpsByIntitule").setParameter("param", intitule).getSingleResult());
    }
    
}
