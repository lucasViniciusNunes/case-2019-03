package com.vitta.doctorprescription.medicine.domain;

import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "medicine_interaction", indexes = {@Index(name = "IDX_PHARMACONS", columnList = "pharmacon1,pharmacon2")})
@NoArgsConstructor
@AllArgsConstructor
public class MedicineInteractionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pharmacon1")
    private PharmaconEntity pharmacon1;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pharmacon2")
    private PharmaconEntity pharmacon2;

    @Column
    private String name;

    @Column
    private String description;

}
