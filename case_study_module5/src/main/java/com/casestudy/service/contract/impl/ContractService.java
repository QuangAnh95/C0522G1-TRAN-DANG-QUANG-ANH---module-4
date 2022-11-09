package com.casestudy.service.contract.impl;

import com.casestudy.dto.IContractDto;
import com.casestudy.repository.contract.IContractRepository;
import com.casestudy.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;


    @Override
    public Page<IContractDto> findAllDto(Pageable pageable) {
        return contractRepository.findAllDto(pageable);
    }
}
