/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IPosteDao;
import com.dresen.dresen.entities.Poste;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class PosteDaoImpl extends GenericDao<Poste, Long> implements IPosteDao{
    
    public List<Poste> findPosteByStructure(long idStructure)throws DataAccessException{
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("Poste.findPosteByStructure").setParameter("param", idStructure).getResultList());    
    }
    
}
