package com.appitude.users.Service;

import com.appitude.users.DTO.UserRequest;
import com.appitude.users.DTO.UserResponse;

import java.util.List;

public interface UserService {

    public UserResponse createUser(UserRequest userRequest);
    public List<UserResponse> getUsers();
    public String resetPassword(String username, String oldPassword, String newPassword);
    public UserResponse getUserByUsername(String username);
    public String loginUser(String username, String password);
}
