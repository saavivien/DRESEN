/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.RangerFonctio;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IRangerFonctioDao extends IDao<RangerFonctio, Long>{
    /**
     *
     * @param idAgent
     * @return
     * @throws DataAccessException
     */
    public List<RangerFonctio> findRangerFonctioByIdAgent(long idAgent) throws DataAccessException;
    public RangerFonctio findRangerFonctioOpenByIdAgent(long idAgent) throws DataAccessException;
    public List<RangerFonctio> findAllRangerFonctioOpen() throws DataAccessException;
    public RangerFonctio findLastRangerFonctioByIdAgent(long idAgent) throws DataAccessException;
}
