/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.Cadre;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface ICadreDao extends IDao<Cadre, Long>{
    public List<Cadre> findCadreByIdCorps(long idCorps) throws DataAccessException;
    public Cadre findCadreByIntitule(String intitule) throws DataAccessException;
}
