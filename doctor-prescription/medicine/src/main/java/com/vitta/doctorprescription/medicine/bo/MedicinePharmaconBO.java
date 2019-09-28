package com.vitta.doctorprescription.medicine.bo;

import com.vitta.doctorprescription.medicine.repository.MedicinePharmaconRepository;
import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicinePharmaconBO {

    @Autowired
    private MedicinePharmaconRepository repository;

    List<PharmaconEntity> findBy(Long prescriptionId, Long medicineId) {

        return repository.findPharmacons(prescriptionId, medicineId);

    }

}
