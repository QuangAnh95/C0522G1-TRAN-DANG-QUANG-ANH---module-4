package com.casestudy.service.facility.impl;

import com.casestudy.model.facility.Facility;
import com.casestudy.repository.facility.IFacilityRepository;
import com.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> searchFacility(String nameSearch, Pageable pageable) {
        return facilityRepository.searchFacility(nameSearch,pageable);
    }

    @Override
    public void deleteLogical(int id) {
        facilityRepository.deleteLogical(id);
    }

    @Override
    public Facility findByIdFacility(long id) {
        return facilityRepository.findByIdFacility(id);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }
}
