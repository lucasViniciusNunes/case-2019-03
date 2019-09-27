package com.vitta.doctorprescription.controller.medicine;

import com.vitta.doctorprescription.medicine.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    @Autowired
    private MedicineRepository medicineRepository;

}
