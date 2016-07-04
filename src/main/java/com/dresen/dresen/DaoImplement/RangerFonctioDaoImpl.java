/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IRangerFonctioDao;
import com.dresen.dresen.entities.RangerFonctio;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class RangerFonctioDaoImpl extends GenericDao<RangerFonctio, Long> implements IRangerFonctioDao, Serializable{

    public List<RangerFonctio> findRangerFonctioByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("RangerFonctio.findRangerFonctioByIdAgent").setParameter("param", idAgent).getResultList());
    }

    public RangerFonctio findRangerFonctioOpenByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (RangerFonctio)(getManager().createNamedQuery("RangerFonctio.findRangerFonctioOpenByIdAgent").setParameter("param", idAgent).getSingleResult());
    }

    public List<RangerFonctio> findAllRangerFonctioOpen() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("RangerFonctio.findAllRangerFonctioOpen").getResultList());

    }
    
}
