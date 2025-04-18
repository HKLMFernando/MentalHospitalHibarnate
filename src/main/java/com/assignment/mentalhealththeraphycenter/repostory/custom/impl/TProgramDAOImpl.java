package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.entity.TPrograms;
import com.assignment.mentalhealththeraphycenter.repostory.custom.TProgramDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TProgramDAOImpl implements TProgramDAO {
    @Override
    public boolean save(TPrograms tPrograms, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(TPrograms tPrograms, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<TPrograms> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<TPrograms> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
