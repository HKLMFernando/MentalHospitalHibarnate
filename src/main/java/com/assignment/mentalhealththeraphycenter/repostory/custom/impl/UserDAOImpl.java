package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.entity.User;
import com.assignment.mentalhealththeraphycenter.repostory.custom.UserDAO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl  implements UserDAO {
    @Override
    public boolean updateUser(String UserName, String UserEmail, String UserNewPassword) {
        return false;
    }

    @Override
    public boolean findUser(String UserName, Session session) {
        return false;
    }

    @Override
    public User findPassWord(String password, String role, Session session) {
        return null;
    }

    @Override
    public List<User> getALLByUserName(String UserName, Session session) {
        return List.of();
    }

    @Override
    public boolean save(User user, Session session) throws SQLException {
        return false;
    }

    @Override
    public boolean update(User user, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<User> getAll() throws Exception {
        return List.of();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Optional<User> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
}
