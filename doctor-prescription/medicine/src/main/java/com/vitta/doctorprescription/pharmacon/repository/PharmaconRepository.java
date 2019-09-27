package com.vitta.doctorprescription.pharmacon.repository;

import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmaconRepository extends CrudRepository<PharmaconEntity, Long> {
}
