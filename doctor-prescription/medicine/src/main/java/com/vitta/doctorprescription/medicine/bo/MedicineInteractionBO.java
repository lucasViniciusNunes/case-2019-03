package com.vitta.doctorprescription.medicine.bo;

import com.vitta.doctorprescription.core.service.dto.DefaultResponse;
import com.vitta.doctorprescription.core.service.enums.ResponseStatus;
import com.vitta.doctorprescription.medicine.domain.MedicineInteractionEntity;
import com.vitta.doctorprescription.medicine.dto.MedicineInteractionResponse;
import com.vitta.doctorprescription.medicine.repository.MedicineInteractionRepository;
import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

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

    public DefaultResponse identifyDrugInteraction(Long prescriptionId, Long medicineId) {

        List<PharmaconEntity> pharmacons = medicinePharmaconBO.findBy(prescriptionId, medicineId);
        if (CollectionUtils.isEmpty(pharmacons)) {
            return DefaultResponse.withErrorMessage("Pharmacons of medicine not found.", ResponseStatus.INTERNAL_SERVER_ERROR);
        }

        List<MedicineInteractionEntity> medicineInteraction = repository.findByPharmacon1InAndPharmacon2In(pharmacons, pharmacons);
        if (CollectionUtils.isEmpty(medicineInteraction)) {
            return new DefaultResponse(ResponseStatus.SUCCESS);
        }

        List<MedicineInteractionResponse> interactionResponses = medicineInteraction.stream()
            .map(interaction -> MedicineInteractionResponse.builder()
                .name(interaction.getName())
                .pharmacon1(interaction.getPharmacon1().getName())
                .pharmacon2(interaction.getPharmacon2().getName())
                .description(interaction.getDescription())
                .build())
            .collect(Collectors.toList());

        return new DefaultResponse(interactionResponses, ResponseStatus.BAD_REQUEST);

    }

}
