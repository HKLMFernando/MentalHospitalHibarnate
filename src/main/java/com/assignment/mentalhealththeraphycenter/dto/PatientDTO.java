package com.assignment.mentalhealththeraphycenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatientDTO {

    private String patientID;
    private String patientName;
    private String patientBirthDate;
    private String patientNIC;
    private String patientGender;
    private String patientAddress;
    private String patientPhone;
    private String patientEmail;
}
