/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Corps;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface ICorpsService {
    public Corps createCorps(Corps corps) throws ServiceException;
    public Corps findCorpsById(Long id) throws ServiceException;
    public Corps updateCorps(Corps corps) throws ServiceException;
    public List<Corps> findAllCorps() throws ServiceException;
    
}
