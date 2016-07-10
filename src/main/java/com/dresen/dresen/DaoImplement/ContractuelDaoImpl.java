/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IContractuelDao;
import com.dresen.dresen.entities.Contractuel;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class ContractuelDaoImpl extends GenericDao<Contractuel, Long> implements IContractuelDao, Serializable{

    @Override
    public List<Contractuel> findContractuelActif() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getManager().createNamedQuery("Contractuel.findContractuelActif").getResultList();
    }

    @Override
    public List<Contractuel> findContractuelRetraites() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getManager().createNamedQuery("Contractuel.findContractuelRetraites").getResultList();
    }
    
}
