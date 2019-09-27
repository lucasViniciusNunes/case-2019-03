package com.vitta.doctorprescription.prescription.domain;

import com.vitta.doctorprescription.medicine.domain.MedicineEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "prescription_item")
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="prescription_id")
    private PrescriptionEntity prescription;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="medicine_id")
    private MedicineEntity medicine;

    private String posologia;

    private String administrationType;

}
