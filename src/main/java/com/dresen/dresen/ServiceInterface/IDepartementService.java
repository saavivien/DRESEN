/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Departement;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IDepartementService {

    /**
     *
     * @param departement
     * @return
     * @throws ServiceException
     */
    public Departement createDepartement(Departement departement) throws ServiceException;
    public Departement findDepartementById(Long id) throws ServiceException;
    public Departement updateDepartement(Departement departement) throws ServiceException;
    public List<Departement> findAllDepartement() throws ServiceException;

}
