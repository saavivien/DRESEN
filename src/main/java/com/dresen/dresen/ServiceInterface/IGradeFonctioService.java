/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.GradeFonctio;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IGradeFonctioService {
    public GradeFonctio createGradeFonctio(GradeFonctio gradeFonctio) throws ServiceException;
    public GradeFonctio findGradeFonctioById(Long id) throws ServiceException;
    public GradeFonctio updateGradeFonctio(GradeFonctio gradeFonctio) throws ServiceException;
    public List<GradeFonctio> findAllGradeFonctio() throws ServiceException;
}
