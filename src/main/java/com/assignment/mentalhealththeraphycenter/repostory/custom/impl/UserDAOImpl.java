package com.assignment.mentalhealththeraphycenter.repostory.custom.impl;

import com.assignment.mentalhealththeraphycenter.config.FactoryConfiguration;
import com.assignment.mentalhealththeraphycenter.entity.User;
import com.assignment.mentalhealththeraphycenter.repostory.custom.UserDAO;
import com.assignment.mentalhealththeraphycenter.service.exeception.NotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDAOImpl  implements UserDAO {
    @Override
    public boolean updateUser(String userName, String userEmail, String userNewPassword) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query<User> query = session.createQuery("FROM User WHERE userName = :username AND userEmail = :email", User.class);
            query.setParameter("username", userName);
            query.setParameter("email", userEmail);

            User user = query.uniqueResult();

            if (user != null) {
                user.setUserPassword(userNewPassword); // You may want to hash this with BCrypt
                session.update(user);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false; // No user found with matching username and email
            }

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean findUser(String UserName, Session session) {

        Query<User> query = session.createQuery("FROM User WHERE userName = :username", User.class);
        query.setParameter("username", UserName);

        User user = query.uniqueResult();
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public User findPassWord(String UserName,String role, Session session) {

        Query<User> query = session.createQuery("FROM User WHERE userName = :username AND userRole = :role", User.class);
        query.setParameter("username", UserName);
        query.setParameter("role", role);

        return query.uniqueResult();
    }

    @Override
    public List<User> getALLByUserName(String UserName, Session session) {

        return session.createQuery("FROM User WHERE userName = :username", User.class)
                .setParameter("username", UserName)
                .list();
    }

    @Override
    public boolean save(User user, Session session) throws SQLException {
        try{
            session.persist(user);
            return true;
        }catch (HibernateException e) {
            e.printStackTrace();
            throw new RuntimeException("Saving user failed");
        }
    }

    @Override
    public boolean update(User user, Session session) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<User> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();;
        Query<User> query = session.createQuery("from User ", User.class);
        return query.list();
    }

    @Override
    public boolean deleteByPk(String pk) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();;
        Transaction transaction = session.beginTransaction();
        try {
            User user = session.get(User.class, pk);
            if (user == null) {
                throw new NotFoundException("User not found");
            }
            session.remove(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<User> findByPK(String pk, Session session) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<String> getLastPK() {

        Session session = FactoryConfiguration.getInstance().getSession();
        String lastPk = session
                .createQuery("SELECT t.id FROM User t ORDER BY t.id DESC", String.class)
                .setMaxResults(1)
                .uniqueResult();

        return Optional.ofNullable(lastPk);
    }
}
