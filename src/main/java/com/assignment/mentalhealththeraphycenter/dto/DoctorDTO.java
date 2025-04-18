package com.assignment.mentalhealththeraphycenter.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private String doctorId;
    private String doctorName;
    private String doctorQualification;
    private String doctorAvailability;
    private String doctorPhone;
    private String doctorEmail;

}
