/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.Poste;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IPosteService {
    public Poste createPoste(Poste poste) throws ServiceException;
    public Poste findPosteById(Long id) throws ServiceException;
    public Poste updatePoste(Poste Poste) throws ServiceException;
    public List<Poste> findAllPoste() throws ServiceException;
    public Poste findPosteByName(String name)throws ServiceException;
    public List<Poste> findPosteByCategorieStructure(long idCategorieStructure) throws ServiceException;
}
