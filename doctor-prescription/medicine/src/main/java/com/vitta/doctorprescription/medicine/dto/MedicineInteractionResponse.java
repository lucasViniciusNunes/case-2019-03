package com.vitta.doctorprescription.medicine.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class MedicineInteractionResponse {

    private Long id;

    private String pharmacon1;

    private String pharmacon2;

    private String name;

    private String description;

}
