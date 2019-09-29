package com.vitta.doctorprescription.prescription.bo;

import com.vitta.doctorprescription.core.service.dto.DefaultResponse;
import com.vitta.doctorprescription.core.service.enums.ResponseStatus;
import com.vitta.doctorprescription.prescription.domain.PrescriptionEntity;
import com.vitta.doctorprescription.prescription.dto.*;
import com.vitta.doctorprescription.prescription.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PrescriptionBO {

    // region repositories

    @Autowired
    private PrescriptionRepository repository;

    // endregion

    // region BO's

    @Autowired
    private PrescriptionItemBO prescriptionItemBO;

    // endregion

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

    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public DefaultResponse registerItem(Long prescriptionId, RegisterItemRequest item) {

        Optional<PrescriptionEntity> prescription = repository.findById(prescriptionId);
        return prescription.map(p ->
            prescriptionItemBO.registerItem(p, item))
            .orElse(DefaultResponse.withErrorMessage("Prescription not found.", ResponseStatus.NOT_FOUND));

    }

}
