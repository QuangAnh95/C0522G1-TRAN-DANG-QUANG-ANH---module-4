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


@Query(value = "select facility.* " +
        "from `facility` " +
        "join `facility_type` on facility.id_facility_type = facility_type.id_facility_type " +
        "join `ren_type` on facility.id_ren_type = ren_type.id_ren_type " +
        "where facility.name_facility like %:nameSearch% and facility_type.name_facility_type like %:typeFacilitySearch% and ren_type.name_ren_type like %:renTypeSearch% and facility.is_delete = 0 "
        ,nativeQuery = true)
    Page<Facility> searchFacility(@Param("nameSearch") String nameSearch,
                                  @Param("typeFacilitySearch") String typeFacilitySearch,
                                  @Param("renTypeSearch") String renTypeSearch, Pageable pageable);



    @Modifying
    @Query(value = "update facility set is_delete = 1 where id_facility = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") int id);

    Facility findByIdFacility(long id);


}
