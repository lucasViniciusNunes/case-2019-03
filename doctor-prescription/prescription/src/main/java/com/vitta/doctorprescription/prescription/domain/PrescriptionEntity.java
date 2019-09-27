package com.vitta.doctorprescription.prescription.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "prescription")
@NoArgsConstructor
@AllArgsConstructor
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String description;

    @Column
    private Long doctorId;

    @Column
    private Long patientId;

}
