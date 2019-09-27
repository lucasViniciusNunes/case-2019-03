package com.vitta.doctorprescription.prescription.bo;

import com.vitta.doctorprescription.prescription.domain.PrescriptionEntity;
import com.vitta.doctorprescription.prescription.dto.RegisterPrescriptionRequest;
import com.vitta.doctorprescription.prescription.dto.RegisterPrescriptionResponse;
import com.vitta.doctorprescription.prescription.dto.SearchPrescriptionResponse;
import com.vitta.doctorprescription.prescription.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrescriptionBO {

    @Autowired
    private PrescriptionRepository repository;

    @Transactional(rollbackFor = Throwable.class)
    public RegisterPrescriptionResponse createPrescription(RegisterPrescriptionRequest request) {

        PrescriptionEntity prescription = PrescriptionEntity.builder()
            .description(request.getDescription())
            .doctorId(request.getDoctorId())
            .patientId(request.getPatientId())
            .build();

        prescription = repository.save(prescription);

        return new RegisterPrescriptionResponse(prescription.getId());

    }

    public SearchPrescriptionResponse findById(Long id) {

        Optional<PrescriptionEntity> prescriptionOpt = repository.findById(id);
        if (!prescriptionOpt.isPresent()) {
            return null;
        }
        PrescriptionEntity prescription = prescriptionOpt.get();

        return SearchPrescriptionResponse.builder()
            .id(prescription.getId())
            .description(prescription.getDescription())
            .doctorId(prescription.getDoctorId())
            .patientId(prescription.getPatientId())
            .build();

    }

}
