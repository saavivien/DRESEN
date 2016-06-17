/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IArrondissementDao;
import com.dresen.dresen.entities.Arrondissement;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class ArrondissementDaoImpl extends GenericDao<Arrondissement, Long> implements IArrondissementDao{

    public List<Arrondissement> findArrondissementByIdDepart(long idDepart) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("Arrondissement.findArrondissementByIdDepart").setParameter("param", idDepart).getResultList());
    }
    
}
