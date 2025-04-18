package com.assignment.mentalhealththeraphycenter.dto.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TProgramTM {
    private String therapyID;
    private String therapyName;
    private String therapyDescription;
    private Double therapyFee;
}
