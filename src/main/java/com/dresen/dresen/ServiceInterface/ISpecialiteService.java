/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Specialite;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface ISpecialiteService {
    public Specialite createSpecialite(Specialite specialite) throws ServiceException;
    public Specialite findSpecialiteById(Long id) throws ServiceException;
    public Specialite updateSpecialite(Specialite rangerContract) throws ServiceException;
    public List<Specialite> findAllSpecialite() throws ServiceException;
}
