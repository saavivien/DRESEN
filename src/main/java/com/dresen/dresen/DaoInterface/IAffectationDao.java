/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.Affectation;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IAffectationDao extends IDao<Affectation, Long>{
    
    /**
     *
     * @param idAgent
     * @return
     * @throws DataAccessException
     */
    public List<Affectation> findAffectationByIdAgent(long idAgent) throws DataAccessException;
    public Affectation findAffectationOpenByIdAgent(long idAgent) throws DataAccessException;
    public List<Affectation> findAllAffectationOpen() throws DataAccessException;
    public Affectation findLastAffectationByIdAgent(long idAgent) throws DataAccessException;
}
