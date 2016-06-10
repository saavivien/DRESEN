/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Promotion;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IPromotionService {
    public Promotion createPromotion(Promotion promotion) throws ServiceException;
    public Promotion findPromotionById(Long id) throws ServiceException;
    public Promotion updatePromotion(Promotion promotion) throws ServiceException;
    public List<Promotion> findAllPromotion() throws ServiceException;
    public List<Promotion> findPromotionByIdAgent(long idAgent) throws ServiceException;
    public List<Promotion> findAllPromotionOpen() throws ServiceException;
    public Promotion findPromotionOpenByIdAgent(long idAgent) throws ServiceException;
    
}
