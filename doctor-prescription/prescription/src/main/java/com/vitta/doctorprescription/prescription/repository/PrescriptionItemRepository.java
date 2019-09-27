package com.vitta.doctorprescription.prescription.repository;

import com.vitta.doctorprescription.prescription.domain.PrescriptionItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionItemRepository extends CrudRepository<PrescriptionItemEntity, Long> {
}
