package com.casestudy.repository.facility;
import com.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Long> {


@Query(value = "select * from facility where name_facility like %:nameSearch% and is_delete = 0",nativeQuery = true)
    Page<Facility> searchFacility(@Param("nameSearch") String nameSearch, Pageable pageable);



    @Modifying
    @Query(value = "update facility set is_delete = 1 where id_facility = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") int id);

    Facility findByIdFacility(long id);


}
