/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Arrondissement;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IArrondissementService {
    public Arrondissement createArrondissement(Arrondissement arrondissement) throws ServiceException;
    public Arrondissement findArrondissementById(Long id) throws ServiceException;
    public Arrondissement updateArrondissement(Arrondissement arrondissement) throws ServiceException;
    public List<Arrondissement> findAllArrondissement() throws ServiceException;    
}

