package com.vitta.doctorprescription.medicine.domain;

import com.vitta.doctorprescription.pharmacon.domain.PharmaconEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "medicine_pharmacon", indexes = {@Index(name = "IDX_MEDICINE_PHARMACON", columnList = "medicine_id,pharmacon_id")})
@NoArgsConstructor
public class MedicinePharmaconEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="medicine_id")
    private MedicineEntity medicine;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pharmacon_id")
    private PharmaconEntity pharmacon;

    public MedicinePharmaconEntity(MedicineEntity medicine, PharmaconEntity pharmacon) {
        this.medicine = medicine;
        this.pharmacon = pharmacon;
    }

}
