package com.vitta.doctorprescription.medicine.bo;

import com.vitta.doctorprescription.core.service.dto.DefaultResponse;
import com.vitta.doctorprescription.core.service.enums.ResponseStatus;
import com.vitta.doctorprescription.medicine.domain.MedicineEntity;
import com.vitta.doctorprescription.medicine.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicineBO {

    @Autowired
    private MedicineRepository repository;

    public DefaultResponse findById(Long id) {

        Optional<MedicineEntity> medicine = repository.findById(id);
        return medicine
            .map(medicineEntity -> new DefaultResponse(medicineEntity, ResponseStatus.SUCCESS))
            .orElseGet(() -> DefaultResponse.withErrorMessage("Medicine not found.", ResponseStatus.BAD_REQUEST));

    }

}
