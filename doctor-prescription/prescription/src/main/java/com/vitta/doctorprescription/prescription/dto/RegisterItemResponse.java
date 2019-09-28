package com.vitta.doctorprescription.prescription.dto;

import com.vitta.doctorprescription.medicine.domain.MedicineInteractionEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class RegisterItemResponse {

    private Long itemId;

    private List<MedicineInteractionEntity> medicineInteractions;

}
