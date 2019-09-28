package com.vitta.doctorprescription.medicine.bo;

import com.vitta.doctorprescription.medicine.domain.MedicineInteractionEntity;
import com.vitta.doctorprescription.medicine.repository.MedicineInteractionRepository;
import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class MedicineInteractionBO {

    // region repositories

    @Autowired
    private MedicineInteractionRepository repository;

    // endregion

    // region BO's

    @Autowired
    private MedicinePharmaconBO medicinePharmaconBO;

    // endregion

    public List<MedicineInteractionEntity> identifyDrugInteraction(Long prescriptionId, Long medicineId) {

        List<PharmaconEntity> pharmacons = medicinePharmaconBO.findBy(prescriptionId, medicineId);
        return !CollectionUtils.isEmpty(pharmacons)
            ? repository.findByPharmacon1InAndPharmacon2In(pharmacons, pharmacons)
            : null;

    }

}
