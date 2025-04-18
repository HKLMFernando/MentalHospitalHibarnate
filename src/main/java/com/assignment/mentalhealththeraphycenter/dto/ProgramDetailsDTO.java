package com.assignment.mentalhealththeraphycenter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class ProgramDetailsDTO {
    private String patientId;
    private List<String> programId;
}
