package com.vitta.doctorprescription.medicine.bo;

import com.vitta.doctorprescription.medicine.domain.MedicineEntity;
import com.vitta.doctorprescription.medicine.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineBO {

    @Autowired
    private MedicineRepository repository;

    public MedicineEntity findById(Long id) {

        Optional<MedicineEntity> medicine = repository.findById(id);
        return medicine.orElse(null);

    }

}
