package com.casestudy.service.facility;
import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IFacilityService {
    Page<Facility> searchFacility( String nameSearch,String typeFacilitySearch,String renTypeSearch, Pageable pageable);

    void deleteLogical( int id);

    Facility findByIdFacility(long id);

    List<Facility> findAll();

    void save(Facility facility);


}
