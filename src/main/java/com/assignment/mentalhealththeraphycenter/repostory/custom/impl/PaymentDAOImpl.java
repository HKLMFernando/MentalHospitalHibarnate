package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.entity.Payment;
import com.assignment.mentalhealththeraphycenter.repostory.custom.PaymentDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public boolean save(Payment payment, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Payment payment, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Payment> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<Payment> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
