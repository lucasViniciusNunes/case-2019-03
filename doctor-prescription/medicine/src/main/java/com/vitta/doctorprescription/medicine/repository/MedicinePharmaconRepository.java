package com.vitta.doctorprescription.medicine.repository;

import com.vitta.doctorprescription.medicine.domain.MedicinePharmaconEntity;
import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicinePharmaconRepository extends CrudRepository<MedicinePharmaconEntity, Long> {

    @Query(value = "SELECT mp.pharmacon FROM MedicinePharmaconEntity AS mp"
        + " LEFT JOIN PrescriptionItemEntity AS pri ON(pri.medicine = mp.medicine)"
        + " WHERE pri.prescription.id = :prescriptionId"
        + " OR mp.medicine.id = :medicineId")
    List<PharmaconEntity> findPharmacons(@Param("prescriptionId") Long prescriptionId,
                                         @Param("medicineId") Long medicineId);

}
