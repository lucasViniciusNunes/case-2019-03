package com.vitta.doctorprescription.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.vitta.doctorprescription.medicine.repository")
public class DeploymentConfig {
}
