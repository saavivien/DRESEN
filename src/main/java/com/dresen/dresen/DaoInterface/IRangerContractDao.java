/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.RangerContract;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IRangerContractDao extends IDao<RangerContract, Long>{
    
     /**
     *
     * @param idAgent
     * @return
     * @throws DataAccessException
     */
    public List<RangerContract> findRangerContractByIdAgent(long idAgent) throws DataAccessException;
    public RangerContract findRangerContractOpenByIdAgent(long idAgent) throws DataAccessException;
    public List<RangerContract> findAllRangerContractOpen() throws DataAccessException;

}
