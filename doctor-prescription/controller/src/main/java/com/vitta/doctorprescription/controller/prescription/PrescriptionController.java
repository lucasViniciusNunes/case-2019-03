package com.vitta.doctorprescription.controller.prescription;

import com.vitta.doctorprescription.prescription.bo.PrescriptionBO;
import com.vitta.doctorprescription.prescription.dto.RegisterPrescriptionRequest;
import com.vitta.doctorprescription.prescription.dto.RegisterPrescriptionResponse;
import com.vitta.doctorprescription.prescription.dto.SearchPrescriptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionBO prescriptionBO;

    @PostMapping(consumes = "application/json", produces = "application/json")
    public RegisterPrescriptionResponse createPrescription(@Valid @RequestBody RegisterPrescriptionRequest request) {

        return prescriptionBO.createPrescription(request);

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SearchPrescriptionResponse findById(@PathVariable("id") Long id) {

        return prescriptionBO.findById(id);

    }

}
