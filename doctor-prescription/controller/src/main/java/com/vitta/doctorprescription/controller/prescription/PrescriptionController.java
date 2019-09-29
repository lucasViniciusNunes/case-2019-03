package com.vitta.doctorprescription.controller.prescription;

import com.vitta.doctorprescription.core.service.dto.DefaultResponse;
import com.vitta.doctorprescription.prescription.bo.PrescriptionBO;
import com.vitta.doctorprescription.prescription.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {

    // region BO's

    @Autowired
    private PrescriptionBO prescriptionBO;

    // endregion

    // region prescription

    @PostMapping(consumes = "application/json", produces = "application/json")
    public RegisterPrescriptionResponse createPrescription(@Valid @RequestBody RegisterPrescriptionRequest request) {

        return prescriptionBO.createPrescription(request);

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public SearchPrescriptionResponse findById(@PathVariable("id") Long id) {

        return prescriptionBO.findById(id);

    }

    // endregion

    // region prescriptionItem

    @PostMapping(value = "/{id}/item", consumes = "application/json", produces = "application/json")
    public ResponseEntity addPrescriptionItem(@PathVariable("id") Long prescriptionId,
                                              @Valid @RequestBody RegisterItemRequest request) {

        DefaultResponse response = prescriptionBO.registerItem(prescriptionId, request);
        return response.buildResponse();

    }

    // endregion

}
