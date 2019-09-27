package com.vitta.doctorprescription.medicine.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@Entity
@Table(name = "medicine", indexes = {@Index(name = "IDX_NAME", columnList = "name")})
@NoArgsConstructor
@AllArgsConstructor
public class MedicineEntity implements Serializable {

    @Id
    private Long id;

    @Column(length = 70)
    private String name;

    @Column(length = 50)
    private String administrationType;

}
