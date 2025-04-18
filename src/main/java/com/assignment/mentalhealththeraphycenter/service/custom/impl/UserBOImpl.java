package com.assignment.mentalhealththeraphycenter.service.custom.impl;

import com.assignment.mentalhealththeraphycenter.dto.UserDTO;
import com.assignment.mentalhealththeraphycenter.service.custom.UserBO;

import java.util.List;

public class UserBOImpl implements UserBO {
    @Override
    public boolean saveUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean updateUser(String UserName, String UserEmail, String UserNewPassword) {
        return false;
    }

    @Override
    public boolean findUser(String UserName) {
        return false;
    }

    @Override
    public String getNextID() {
        return "";
    }

    @Override
    public String findPassWord(String username, String role) {
        return "";
    }

    @Override
    public List<UserDTO> getUserDetails(String UserName) {
        return List.of();
    }
}
