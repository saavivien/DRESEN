/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IGradeFonctioDao;
import com.dresen.dresen.entities.GradeFonctio;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class GradeFonctioDaoImpl extends GenericDao<GradeFonctio, Long> implements IGradeFonctioDao{

    public List<GradeFonctio> findGradeFonctioByIdCadre(long idCadre) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("GradeFonctio.findGradeFonctioByIdCadre").setParameter("param", idCadre).getResultList());
    }
    
}
