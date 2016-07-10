/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoInterface;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.dresen.dresen.entities.PosteStructure;
import java.util.List;
/**
 *
 * @author Vivien Saa
 */
public interface IPosteStructureDao extends IDao<PosteStructure, Long>{
    public List<PosteStructure> findPosteStructureByPoste(long idPoste) throws DataAccessException;
    public void deletePosteStructureByPoste(long idAgent) throws DataAccessException;
    public List<PosteStructure> findPosteStructureByCategorieStructure(long idCategorie) throws DataAccessException;
}
