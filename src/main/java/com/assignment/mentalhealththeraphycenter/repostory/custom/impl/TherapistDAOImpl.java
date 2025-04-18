package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.entity.Therapist;
import com.assignment.mentalhealththeraphycenter.repostory.custom.TherapistDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TherapistDAOImpl implements TherapistDAO {
    @Override
    public boolean save(Therapist therapist, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Therapist therapist, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Therapist> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<Therapist> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
