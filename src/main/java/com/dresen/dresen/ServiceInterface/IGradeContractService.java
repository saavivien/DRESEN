/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.GradeContract;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IGradeContractService {
    public GradeContract createGradeContract(GradeContract gradeContract) throws ServiceException;
    public GradeContract findGradeContractById(Long id) throws ServiceException;
    public GradeContract updateGradeContract(GradeContract gradeContract) throws ServiceException;
    public List<GradeContract> findAllGradeContract() throws ServiceException;
    
}
