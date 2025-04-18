package com.assignment.mentalhealththeraphycenter.repostory.custom;


import com.assignment.mentalhealththeraphycenter.entity.User;
import com.assignment.mentalhealththeraphycenter.repostory.CrudDAO;
import org.hibernate.Session;

import java.util.List;


public interface UserDAO extends CrudDAO<User,String> {
    boolean updateUser(String UserName, String UserEmail, String UserNewPassword);
    boolean findUser(String UserName, Session session);
    User findPassWord(String password,String role, Session session);
    List<User>getALLByUserName(String UserName,Session session);
}
