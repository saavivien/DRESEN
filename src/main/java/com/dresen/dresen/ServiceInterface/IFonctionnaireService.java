/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Fonctionnaire;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IFonctionnaireService {
    public Fonctionnaire createFonctionnaire(Fonctionnaire fonctionnaire) throws ServiceException;
    public Fonctionnaire findFonctionnaireById(Long id) throws ServiceException;
    public Fonctionnaire updateFonctionnaire(Fonctionnaire fonctionnaire) throws ServiceException;
    public List<Fonctionnaire> findAllFonctionnaire() throws ServiceException;
    
}
