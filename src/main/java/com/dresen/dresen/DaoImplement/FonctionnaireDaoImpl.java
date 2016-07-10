/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IFonctionnaireDao;
import com.dresen.dresen.entities.Fonctionnaire;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class FonctionnaireDaoImpl extends GenericDao<Fonctionnaire, Long> implements IFonctionnaireDao, Serializable{

    @Override
    public List<Fonctionnaire> findFonctionnaireActif() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getManager().createNamedQuery("Fonctionnaire.findFonctionnaireActif").getResultList();
    }

    @Override
    public List<Fonctionnaire> findFonctionnaireRetraites() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return getManager().createNamedQuery("Fonctionnaire.findFonctionnaireRetraites").getResultList();
    }
    
}
