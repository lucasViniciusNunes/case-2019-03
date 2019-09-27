package com.vitta.doctorprescription.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {
    "com.vitta.doctorprescription.medicine.domain",
    "com.vitta.doctorprescription.pharmacon.domain"
})
@EnableJpaRepositories(basePackages = {
    "com.vitta.doctorprescription.medicine.repository",
    "com.vitta.doctorprescription.pharmacon.repository"
})
public class JpaConfig {
}
