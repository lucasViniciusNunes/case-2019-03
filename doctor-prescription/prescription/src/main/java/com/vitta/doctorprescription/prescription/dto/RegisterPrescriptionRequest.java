package com.vitta.doctorprescription.prescription.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegisterPrescriptionRequest {

    @NotNull(message = "Description can't be null.")
    private String description;

    @NotNull(message = "Doctor identifier can't be null.")
    private Long doctorId;

    @NotNull(message = "Patient identifier can't be null.")
    private Long patientId;

}
