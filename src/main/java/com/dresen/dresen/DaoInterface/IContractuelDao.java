/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.Contractuel;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IContractuelDao extends IDao<Contractuel, Long>{
    public List<Contractuel> findContractuelActif() throws DataAccessException;
    public List<Contractuel> findContractuelRetraites() throws DataAccessException;
    
}
