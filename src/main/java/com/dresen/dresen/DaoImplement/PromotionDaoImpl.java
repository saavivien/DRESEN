/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.DaoImplement;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoInterface.IPromotionDao;
import com.dresen.dresen.entities.Promotion;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class PromotionDaoImpl extends GenericDao<Promotion, Long> implements IPromotionDao, Serializable{

    public List<Promotion> findPromotionByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("Promotion.findPromotionByIdAgent").setParameter("param", idAgent).getResultList());
    }

    public Promotion findPromotionOpenByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Promotion)(getManager().createNamedQuery("Promotion.findPromotionOpenByIdAgent").setParameter("param", idAgent).getSingleResult());
    }

    public List<Promotion> findAllPromotionOpen() throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (getManager().createNamedQuery("Promotion.findAllPromotionOpen").getResultList());
    }

    @Override
    public Promotion findLastPromotionByIdAgent(long idAgent) throws DataAccessException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return (Promotion)(getManager().createNamedQuery("Promotion.findLastPromotionByIdAgent").setParameter("param", idAgent).getSingleResult());
    }
    
}
