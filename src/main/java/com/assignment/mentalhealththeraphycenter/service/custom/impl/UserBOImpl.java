package com.assignment.mentalhealththeraphycenter.service.custom.impl;

import com.assignment.mentalhealththeraphycenter.config.FactoryConfiguration;
import com.assignment.mentalhealththeraphycenter.dto.UserDTO;
import com.assignment.mentalhealththeraphycenter.entity.User;
import com.assignment.mentalhealththeraphycenter.repostory.DAOFactory;
import com.assignment.mentalhealththeraphycenter.repostory.DAOType;
import com.assignment.mentalhealththeraphycenter.repostory.custom.UserDAO;
import com.assignment.mentalhealththeraphycenter.service.custom.UserBO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserBOImpl implements UserBO {

    UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public boolean saveUser(UserDTO userDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = new User();
            user.setUserID(userDTO.getUserID());
            user.setUserFullName(userDTO.getUserFullName());
            user.setUserEmail(userDTO.getUserEmail());
            user.setUserRole(userDTO.getUserRole());
            user.setUserName(userDTO.getUserName());
            user.setUserPassword(userDTO.getUserPassword());

            boolean isSaved= userDAO.save(user,session);
            if (isSaved) {
                transaction.commit();
                return true;
            }else {
                transaction.rollback();
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error saving user");
        }finally {
            session.close();
        }
    }

    @Override
    public boolean updateUser(String UserName, String UserEmail, String UserNewPassword) {
        try {
            return userDAO.updateUser(UserName,UserEmail,UserNewPassword);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error updating user");
        }
    }

    @Override
    public boolean findUser(String UserName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            boolean exists = userDAO.findUser(username,session);
            if (!exists) {
                transaction.rollback();
                return false;
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding user");
        } finally {
            session.close();
        }
    }

    @Override
    public String getNextID() {
        Optional<String> lastPkOptional = userDAO.getLastPK();
        if (lastPkOptional.isPresent()) {
            String lastPk = lastPkOptional.get();
            int nextId = Integer.parseInt(lastPk.replace("U", "")) + 1;
            return String.format("U%03d", nextId);
        } else {
            return "U001";
        }
    }

    @Override
    public String findPassWord(String username, String role) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user = userDAO.findPassWord(username,role, session);
            if (user != null) {
                transaction.commit();
                return user.getUserPassword();
            } else {
                transaction.rollback();
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding password");
        } finally {
            session.close();
        }
    }

    @Override
    public List<UserDTO> getUserDetails(String UserName) {
        Session session = FactoryConfiguration.getInstance().getSession();
        try {
            List<User> users = userDAO.getALLByUserName(UserName,session);
            List<UserDTO> userDTOList = new ArrayList<>();
            for (User user : users) {
                UserDTO userDTO = new UserDTO(
                        user.getUserID(),
                        user.getUserFullName(),
                        user.getUserEmail(),
                        user.getUserRole(),
                        user.getUserName(),
                        user.getUserPassword()
                );
                userDTOList.add(userDTO);
            }
            return userDTOList;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
