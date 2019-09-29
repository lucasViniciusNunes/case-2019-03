package com.vitta.doctorprescription.prescription.dto;

import com.vitta.doctorprescription.medicine.dto.MedicineInteractionResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegisterItemResponse {

    private Long itemId;

    private List<MedicineInteractionResponse> medicineInteractions;

    public RegisterItemResponse(Long itemId) {
        this.itemId = itemId;
    }

    public RegisterItemResponse(List<MedicineInteractionResponse> medicineInteractions) {
        this.medicineInteractions = medicineInteractions;
    }

}
