/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.RangerContract;
import com.dresen.dresen.entities.RangerFonctio;
import java.util.List;
import org.hibernate.service.spi.ServiceException;

/**
 *
 * @author Vivien Saa
 */
public interface IRangerFonctioService {
    public RangerFonctio createRangerFonctio(RangerFonctio rangerFonctio) throws ServiceException;
    public RangerFonctio findRangerFonctioById(Long id) throws ServiceException;
    public RangerFonctio updateRangerFonctio(RangerFonctio rangerFonctio) throws ServiceException;
    public List<RangerFonctio> findAllRangerFonctio() throws ServiceException;
    public List<RangerFonctio> findRangerFonctioByIdAgent(long idAgent) throws ServiceException;
    public List<RangerFonctio> findAllRangerFonctioOpen() throws ServiceException;
    public RangerFonctio findRangerFonctioOpenByIdAgent(long idAgent) throws ServiceException;
    
}
