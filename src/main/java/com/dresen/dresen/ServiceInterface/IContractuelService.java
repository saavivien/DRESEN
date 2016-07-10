/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Contractuel;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IContractuelService {
    public Contractuel createContractuel(Contractuel contractuel) throws ServiceException;
    public Contractuel findContractuelById(Long id) throws ServiceException;
    public Contractuel updateContractuel(Contractuel contractuel) throws ServiceException;
    public List<Contractuel> findAllContractuel() throws ServiceException;  
    public List<Contractuel> findContractuelActif() throws ServiceException;
    public List<Contractuel> findContractuelRetraites() throws ServiceException;
}
