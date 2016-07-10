/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.PosteStructure;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IPosteStructureService {
    public PosteStructure createPosteStructure(PosteStructure poste_Structure) throws ServiceException;
    public PosteStructure findPosteStructureById(Long id) throws ServiceException;
    public PosteStructure updatePosteStructure(PosteStructure poste_Structure) throws ServiceException;
    public List<PosteStructure> findAllPosteStructure() throws ServiceException;
    public List<PosteStructure> findPosteStructureByPoste(long idPoste) throws ServiceException;
    public void deletePosteStructure(PosteStructure posteStructure) throws ServiceException;
    public void deletePosteStructureByPoste(long idAgent) throws ServiceException;
    public List<PosteStructure> findPosteStructureByCategorieStructure(long idCategorie) throws ServiceException;
    
}
