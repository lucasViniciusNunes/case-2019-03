package com.vitta.doctorprescription.medicine.repository;

import com.vitta.doctorprescription.medicine.domain.MedicinePharmaconEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicinePharmaconRepository extends CrudRepository<MedicinePharmaconEntity, Long> {
}
