/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.StructureAttache;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public interface IStructureDao extends IDao<StructureAttache, Long>{
    public List<StructureAttache> findStructureAttacheByCategorieAndArrondissement(long idArrondissement, long idCategorie) throws DataAccessException;  
    public StructureAttache findStructureAttacheByIntitule(String intitule) throws DataAccessException;
}
