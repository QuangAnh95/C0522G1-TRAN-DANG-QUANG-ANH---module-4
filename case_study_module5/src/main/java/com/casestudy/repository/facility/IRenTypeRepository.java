package com.casestudy.repository.facility;

import com.casestudy.model.facility.RenType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRenTypeRepository extends JpaRepository<RenType,Long> {
}
