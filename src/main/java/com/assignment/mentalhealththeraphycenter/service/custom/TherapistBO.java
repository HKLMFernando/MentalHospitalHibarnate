package com.assignment.mentalhealththeraphycenter.service.custom;

import com.assignment.mentalhealththeraphycenter.dto.DoctorDTO;
import com.assignment.mentalhealththeraphycenter.service.SuperBO;

import java.sql.SQLException;
import java.util.List;

public interface TherapistBO extends SuperBO {
    List<DoctorDTO> getALLDoctors() throws Exception;
    boolean saveTherapist(DoctorDTO doctorDTO);
    boolean updateTherapist(DoctorDTO doctorDTO);
    boolean deleteTherapist(String DoctorID) throws SQLException, ClassNotFoundException;
    String getNextTherapyID();
    List<DoctorDTO>getDocNames() throws Exception;
}
