/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.StructureAttache;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IStructureService {
    public StructureAttache createStructureAttache(StructureAttache structureAttache) throws ServiceException;
    public StructureAttache findStructureAttacheById(Long id) throws ServiceException;
    public StructureAttache updateStructureAttache(StructureAttache structureAttache) throws ServiceException;
    public List<StructureAttache> findAllStructureAttache() throws ServiceException;
    public List<StructureAttache> findStructureAttacheByCategorieAndArrondissement(long idArrondissement, long idCategorie) throws ServiceException;   
}
