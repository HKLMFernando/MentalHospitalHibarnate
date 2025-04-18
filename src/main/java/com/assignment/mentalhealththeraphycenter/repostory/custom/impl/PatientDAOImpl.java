package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.entity.Patient;
import com.assignment.mentalhealththeraphycenter.repostory.custom.PatientDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PatientDAOImpl implements PatientDAO {
    @Override
    public List<Patient> searchPatientName(String searchByName) {
        return List.of();
    }

    @Override
    public String search(String patientName) {
        return "";
    }

    @Override
    public boolean save(Patient patient, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Patient patient, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Patient> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<Patient> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
