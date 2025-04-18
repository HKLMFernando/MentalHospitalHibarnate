package com.assignment.mentalhealththeraphycenter.service.custom;

import com.assignment.mentalhealththeraphycenter.dto.UserDTO;
import com.assignment.mentalhealththeraphycenter.service.SuperBO;

import java.util.List;

public interface UserBO extends SuperBO {
    boolean saveUser(UserDTO userDTO);
    boolean updateUser(String UserName,String UserEmail, String UserNewPassword);
    boolean findUser(String UserName);
    String getNextID();
    String findPassWord(String username, String role);
    List<UserDTO> getUserDetails(String UserName);
}
