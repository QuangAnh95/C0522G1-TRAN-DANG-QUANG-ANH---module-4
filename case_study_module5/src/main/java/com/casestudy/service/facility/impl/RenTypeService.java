package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.RenType;
import com.casestudy.repository.facility.IRenTypeRepository;
import com.casestudy.service.facility.IRenTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RenTypeService implements IRenTypeService {
    @Autowired
    private IRenTypeRepository renTypeRepository;

    @Override
    public List<RenType> findAll() {
        return renTypeRepository.findAll();
    }
}
