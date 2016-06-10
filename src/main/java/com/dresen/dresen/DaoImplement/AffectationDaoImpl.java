/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IAffectationDao;
import com.dresen.dresen.entities.Affectation;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class AffectationDaoImpl extends GenericDao<Affectation, Long> implements IAffectationDao{

    public List<Affectation> findAffectationByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("Affectation.findAffectationByIdAgent").setParameter("param", idAgent).getResultList());
    }

    public Affectation findAffectationOpenByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Affectation) (getManager().createNamedQuery("Affectation.findAffectationOpenByIdAgent").setParameter("param", idAgent).getSingleResult());
    }

    public List<Affectation> findAllAffectationOpen() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("Affectation.findAllAffectationOpen").getResultList());

    }
    
    
}
