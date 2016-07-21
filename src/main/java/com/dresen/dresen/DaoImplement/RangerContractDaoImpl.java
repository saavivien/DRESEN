/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IRangerContractDao;
import com.dresen.dresen.entities.RangerContract;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class RangerContractDaoImpl extends GenericDao<RangerContract, Long> implements IRangerContractDao, Serializable{

    @Override
    public List<RangerContract> findRangerContractByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("RangerContract.findRangerContractByIdAgent").setParameter("param", idAgent).getResultList());
    }

    @Override
    public RangerContract findRangerContractOpenByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (RangerContract)(getManager().createNamedQuery("RangerContract.findRangerContractOpenByIdAgent").setParameter("param", idAgent).getSingleResult());
    }

    @Override
    public List<RangerContract> findAllRangerContractOpen() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("RangerContract.findAllRangerContractOpen").getResultList());
    }

    @Override
    public RangerContract findLastRangerContractByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (RangerContract)(getManager().createNamedQuery("RangerContract.findLastRangerContractByIdAgent").setParameter("param", idAgent).getSingleResult());
    }
    
}
