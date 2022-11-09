package com.casestudy.service.contract;

import com.casestudy.dto.IContractDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDto>findAllDto(Pageable pageable);
}
