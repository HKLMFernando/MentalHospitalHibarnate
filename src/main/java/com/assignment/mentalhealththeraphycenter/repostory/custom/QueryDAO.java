package com.assignment.mentalhealththeraphycenter.repostory.custom;



import com.assignment.mentalhealththeraphycenter.dto.MedicalHistoryDTO;
import com.assignment.mentalhealththeraphycenter.dto.PatientsInEveryProgramDTO;
import com.assignment.mentalhealththeraphycenter.dto.ViewSessionDTO;
import com.assignment.mentalhealththeraphycenter.repostory.SuperDAO;

import java.util.List;

public interface QueryDAO  extends SuperDAO {
    List<ViewSessionDTO>getAllAppointments();
    List<MedicalHistoryDTO> getALLMedicalHistory();
    List<PatientsInEveryProgramDTO> getPatientsInEveryProgram();
}
