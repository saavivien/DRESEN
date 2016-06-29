/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Cadre;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface ICadreService {
    public Cadre createCadre(Cadre cadre) throws ServiceException;
    public Cadre findCadreById(Long id) throws ServiceException;
    public Cadre updateCadre(Cadre cadre) throws ServiceException;
    public List<Cadre> findAllCadre() throws ServiceException;  
    public List<Cadre> findCadreByIdCorps(long idCorps) throws ServiceException;
}
