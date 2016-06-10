/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.Poste;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IPosteDao extends IDao<Poste, Long>{
    public List<Poste> findPosteByStructure(long idStructure)throws DataAccessException;
    
}
