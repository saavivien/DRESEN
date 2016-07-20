/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IDepartementDao;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.Specialite;
import java.io.Serializable;

/**
 *
 * @author Vivien Saa
 */
public class DepartementDaoImpl extends GenericDao<Departement, Long> implements IDepartementDao, Serializable{

    @Override
    public Departement findDepartementByIntitule(String intitule) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Departement)(getManager().createNamedQuery("Departement.findDepartementByIntitule").setParameter("param", intitule).getSingleResult());
    }
    
}
