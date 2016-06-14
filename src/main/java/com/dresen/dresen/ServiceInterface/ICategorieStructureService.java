/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.CategorieStructure;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface ICategorieStructureService {
    public CategorieStructure createCategorieStructure(CategorieStructure categorieStructure) throws ServiceException;
    public CategorieStructure findCategorieStructureById(Long id) throws ServiceException;
    public CategorieStructure updateCategorieStructure(CategorieStructure categorieStructure) throws ServiceException;
    public List<CategorieStructure> findAllCategorieStructure() throws ServiceException;
    
}
