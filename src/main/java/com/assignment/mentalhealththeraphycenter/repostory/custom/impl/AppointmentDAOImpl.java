package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.entity.Appointments;
import com.assignment.mentalhealththeraphycenter.repostory.custom.AppointmentDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AppointmentDAOImpl implements AppointmentDAO {
    @Override
    public boolean save(Appointments appointments, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Appointments appointments, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Appointments> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<Appointments> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
