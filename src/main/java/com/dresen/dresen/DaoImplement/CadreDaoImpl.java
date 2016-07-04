/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.ICadreDao;
import com.dresen.dresen.entities.Cadre;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class CadreDaoImpl extends GenericDao<Cadre, Long> implements ICadreDao, Serializable{

    public List<Cadre> findCadreByIdCorps(long idCorps) throws DataAccessException {
        return (getManager().createNamedQuery("Cadre.findCadreByIdCorps").setParameter("param", idCorps).getResultList());
    }
    
}
