package com.assignment.mentalhealththeraphycenter.service.custom.impl;

import com.assignment.mentalhealththeraphycenter.dto.MedicalHistoryDTO;
import com.assignment.mentalhealththeraphycenter.dto.PatientDTO;
import com.assignment.mentalhealththeraphycenter.dto.PatientsInEveryProgramDTO;
import com.assignment.mentalhealththeraphycenter.service.custom.PatientBO;

import java.sql.SQLException;
import java.util.List;

public class PatientBOImpl implements PatientBO {
    @Override
    public boolean updatePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean savePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<PatientDTO> getALL() throws Exception {
        return List.of();
    }

    @Override
    public boolean deletePatient(String patientID) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getNextPatientID() {
        return "";
    }

    @Override
    public List<MedicalHistoryDTO> getPatientHistory() throws SQLException, ClassNotFoundException {
        return List.of();
    }

    @Override
    public List<PatientsInEveryProgramDTO> getPatientsInEveryProgram() {
        return List.of();
    }
}
