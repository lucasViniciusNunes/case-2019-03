package com.vitta.doctorprescription.prescription.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SearchPrescriptionResponse {

    private Long id;

    private String description;

    private Long doctorId;

    private Long patientId;

}
