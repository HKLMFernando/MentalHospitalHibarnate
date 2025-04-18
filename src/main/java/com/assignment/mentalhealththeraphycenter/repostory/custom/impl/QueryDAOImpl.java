package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.dto.MedicalHistoryDTO;
import com.assignment.mentalhealththeraphycenter.dto.PatientsInEveryProgramDTO;
import com.assignment.mentalhealththeraphycenter.dto.ViewSessionDTO;
import com.assignment.mentalhealththeraphycenter.repostory.custom.QueryDAO;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<ViewSessionDTO> getAllAppointments() {
        return List.of();
    }

    @Override
    public List<MedicalHistoryDTO> getALLMedicalHistory() {
        return List.of();
    }

    @Override
    public List<PatientsInEveryProgramDTO> getPatientsInEveryProgram() {
        return List.of();
    }
}
