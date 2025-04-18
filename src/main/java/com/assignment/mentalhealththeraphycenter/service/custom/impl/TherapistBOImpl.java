package com.assignment.mentalhealththeraphycenter.service.custom.impl;

import com.assignment.mentalhealththeraphycenter.dto.DoctorDTO;
import com.assignment.mentalhealththeraphycenter.service.custom.TherapistBO;

import java.sql.SQLException;
import java.util.List;

public class TherapistBOImpl implements TherapistBO {
    @Override
    public List<DoctorDTO> getALLDoctors() throws Exception {
        return List.of();
    }

    @Override
    public boolean saveTherapist(DoctorDTO doctorDTO) {
        return false;
    }

    @Override
    public boolean updateTherapist(DoctorDTO doctorDTO) {
        return false;
    }

    @Override
    public boolean deleteTherapist(String DoctorID) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String getNextTherapyID() {
        return "";
    }

    @Override
    public List<DoctorDTO> getDocNames() throws Exception {
        return List.of();
    }
}
