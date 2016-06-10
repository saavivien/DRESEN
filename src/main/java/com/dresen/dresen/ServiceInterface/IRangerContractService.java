/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.ServiceInterface;

import com.dresen.dresen.entities.RangerContract;
import java.util.List;
import org.hibernate.service.spi.ServiceException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vivien Saa
 */
@Transactional
public interface IRangerContractService {
    public RangerContract createRangerContract(RangerContract rangerContract) throws ServiceException;
    public RangerContract findRangerContractById(Long id) throws ServiceException;
    public RangerContract updateRangerContract(RangerContract rangerContract) throws ServiceException;
    public List<RangerContract> findAllRangerContract() throws ServiceException;
    public List<RangerContract> findRangerContractByIdAgent(long idAgent) throws ServiceException;
    public List<RangerContract> findAllRangerContractOpen() throws ServiceException;
    public RangerContract findRangerContractOpenByIdAgent(long idAgent) throws ServiceException;
    
}
