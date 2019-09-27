package com.vitta.doctorprescription.prescription.bo;

import com.vitta.doctorprescription.medicine.bo.MedicineBO;
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

    // endregion

    @Transactional(rollbackFor = Throwable.class, isolation = Isolation.READ_COMMITTED, readOnly = true)
    public RegisterItemResponse registerItem(PrescriptionEntity prescription, RegisterItemRequest item) {

        MedicineEntity medicine = medicineBO.findById(item.getMedicineId());
        if (medicine == null) {
            return null;
        }

        PrescriptionItemEntity prescriptionItem = PrescriptionItemEntity.builder()
            .medicine(medicine)
            .prescription(prescription)
            .posologia(item.getPosologia())
            .administrationType(item.getAdministrationType())
            .build();

        prescriptionItem = prescriptionItemRepository.save(prescriptionItem);

        return new RegisterItemResponse(prescriptionItem.getId());

    }

}
