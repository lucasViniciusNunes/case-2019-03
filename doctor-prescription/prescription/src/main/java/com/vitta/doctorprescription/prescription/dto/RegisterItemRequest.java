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
public class RegisterItemRequest {

    @NotNull(message = "MedicineId can't be empty.")
    private Long medicineId;

    @NotNull(message = "Posologia can't be empty.")
    private String posologia;

    @NotNull(message = "AdministrationType can't be empty.")
    private String administrationType;

}
