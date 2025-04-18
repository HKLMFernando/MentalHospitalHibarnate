package com.assignment.mentalhealththeraphycenter.service.custom;

import com.assignment.mentalhealththeraphycenter.dto.MedicalHistoryDTO;
import com.assignment.mentalhealththeraphycenter.dto.PatientDTO;
import com.assignment.mentalhealththeraphycenter.dto.PatientsInEveryProgramDTO;
import com.assignment.mentalhealththeraphycenter.service.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface PatientBO extends SuperBO {
    boolean updatePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException;
    boolean savePatient(PatientDTO patientDTO) throws SQLException, ClassNotFoundException;
    List<PatientDTO> getALL() throws Exception;
    boolean deletePatient(String patientID) throws SQLException, ClassNotFoundException;
    String getNextPatientID();
    List<MedicalHistoryDTO> getPatientHistory() throws SQLException, ClassNotFoundException;
    List<PatientsInEveryProgramDTO> getPatientsInEveryProgram();
}
