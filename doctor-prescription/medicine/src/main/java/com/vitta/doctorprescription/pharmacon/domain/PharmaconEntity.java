package com.vitta.doctorprescription.pharmacon.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pharmacon")
@NoArgsConstructor
public class PharmaconEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    public PharmaconEntity(String name) {
        this.name = name;
    }

}
