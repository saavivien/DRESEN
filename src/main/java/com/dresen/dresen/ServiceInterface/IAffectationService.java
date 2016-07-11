/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Affectation;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IAffectationService {
    public Affectation createAffectation(Affectation affectation) throws ServiceException;
    public Affectation findAffectationById(Long id) throws ServiceException;
    public Affectation updateAffectation(Affectation affectation) throws ServiceException;
    public List<Affectation> findAllAffectation() throws ServiceException; 
    public List<Affectation> findAffectationByIdAgent(long idAgent) throws ServiceException;
    public Affectation findAffectationOpenByIdAgent(long idAgent) throws ServiceException;
    public List<Affectation> findAllAffectationOpen() throws ServiceException;
    public Affectation findLastAffectationByIdAgent(long idAgent) throws ServiceException;

}
