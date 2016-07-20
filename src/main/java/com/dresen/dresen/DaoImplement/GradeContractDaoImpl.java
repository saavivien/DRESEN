/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IGradeContractDao;
import com.dresen.dresen.entities.GradeContract;
import java.io.Serializable;

/**
 *
 * @author Vivien Saa
 */
public class GradeContractDaoImpl extends GenericDao<GradeContract, Long> implements IGradeContractDao, Serializable{

    @Override
    public GradeContract findGradeContractByIntitule(String intitule) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (GradeContract)(getManager().createNamedQuery("GradeContract.findGradeContractByIntitule").setParameter("param", intitule).getSingleResult());
    }
    
}
