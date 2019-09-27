package com.vitta.doctorprescription.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.vitta.doctorprescription.medicine.domain")
@EnableJpaRepositories("com.vitta.doctorprescription.medicine.repository")
public class JpaConfig {
}
