package com.vitta.doctorprescription.medicine.repository;

import com.vitta.doctorprescription.medicine.domain.MedicineInteractionEntity;
import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineInteractionRepository extends CrudRepository<MedicineInteractionEntity, Long> {

    @Query(name = "FROM MedicineInteractionEntity"
        + " WHERE pharmacon1 IN (:pharmaconsa) AND pharmacon2 IN (:pharmaconsb)")
    List<MedicineInteractionEntity> findByPharmacon1InAndPharmacon2In(@Param("pharmaconsa") List<PharmaconEntity> pharmacons1,
                                                                      @Param("pharmaconsb") List<PharmaconEntity> pharmacons2);

}
