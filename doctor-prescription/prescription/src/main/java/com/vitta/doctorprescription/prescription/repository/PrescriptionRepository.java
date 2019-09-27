package com.vitta.doctorprescription.prescription.repository;

import com.vitta.doctorprescription.prescription.domain.PrescriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends CrudRepository<PrescriptionEntity, Long> {
}
