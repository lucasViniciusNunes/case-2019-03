package com.vitta.doctorprescription.prescription.bo;

import com.vitta.doctorprescription.core.service.dto.DefaultResponse;
import com.vitta.doctorprescription.core.service.enums.ResponseStatus;
import com.vitta.doctorprescription.medicine.bo.MedicineBO;
import com.vitta.doctorprescription.medicine.bo.MedicineInteractionBO;
import com.vitta.doctorprescription.medicine.domain.MedicineEntity;
import com.vitta.doctorprescription.prescription.domain.PrescriptionEntity;
import com.vitta.doctorprescription.prescription.domain.PrescriptionItemEntity;
import com.vitta.doctorprescription.prescription.dto.RegisterItemRequest;
import com.vitta.doctorprescription.prescription.dto.RegisterItemResponse;
import com.vitta.doctorprescription.prescription.repository.PrescriptionItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrescriptionItemBO {

    // region repositories

    @Autowired
    private PrescriptionItemRepository prescriptionItemRepository;

    // endregion

    // region BO's

    @Autowired
    private MedicineBO medicineBO;

    @Autowired
    private MedicineInteractionBO medicineInteractionBO;

    // endregion

    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public DefaultResponse registerItem(PrescriptionEntity prescription, RegisterItemRequest item) {

        DefaultResponse medicineResponse = medicineBO.findById(item.getMedicineId());
        if (medicineResponse.hasError()) {
            return medicineResponse;
        }
        MedicineEntity medicine = (MedicineEntity) medicineResponse.getResponse();

        DefaultResponse medicineInteraction = medicineInteractionBO.identifyDrugInteraction(prescription.getId(), medicine.getId());
        if (medicineInteraction.hasError()) {
            return medicineInteraction;
        }

        PrescriptionItemEntity prescriptionItem = PrescriptionItemEntity.builder()
            .medicine(medicine)
            .prescription(prescription)
            .posologia(item.getPosologia())
            .administrationType(item.getAdministrationType())
            .build();

        prescriptionItem = prescriptionItemRepository.save(prescriptionItem);

        RegisterItemResponse response = new RegisterItemResponse(prescriptionItem.getId());
        return new DefaultResponse(response, ResponseStatus.SUCCESS);

    }

}
