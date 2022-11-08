package com.casestudy.repository.facility;

import com.casestudy.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ITypeFacilityRepository extends JpaRepository<FacilityType,Long> {

}
