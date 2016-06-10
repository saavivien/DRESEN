/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.Promotion;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IPromotionDao extends IDao<Promotion, Long>{
    
     /**
     *
     * @param idAgent
     * @return
     * @throws DataAccessException
     */
    public List<Promotion> findPromotionByIdAgent(long idAgent) throws DataAccessException;
    public Promotion findPromotionOpenByIdAgent(long idAgent) throws DataAccessException;
    public List<Promotion> findAllPromotionOpen() throws DataAccessException;        

    
}
