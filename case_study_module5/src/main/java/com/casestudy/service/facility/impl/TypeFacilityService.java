package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.FacilityType;
import com.casestudy.repository.facility.ITypeFacilityRepository;
import com.casestudy.service.facility.ITypeFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeFacilityService implements ITypeFacilityService {
    @Autowired
    private ITypeFacilityRepository typeFacilityRepository;

    @Override
    public List<FacilityType> findAll() {
        return typeFacilityRepository.findAll();
    }
}
