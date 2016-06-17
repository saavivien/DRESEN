/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.CategorieStructure;

/**
 *
 * @author Vivien Saa
 */
public interface ICategorieStructureDao extends IDao<CategorieStructure, Long>{
        public CategorieStructure findCategorieStructureByName(String name)throws DataAccessException;

    
}
