package com.appitude.users.Service;

import com.appitude.users.DTO.UserRequest;
import com.appitude.users.DTO.UserResponse;
import com.appitude.users.Entity.User;
import com.appitude.users.Repository.UserRepository;
import com.appitude.users.Util.PasswordUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserResponse createUser(UserRequest userRequest) {

        if (repository.findById(userRequest.username()).isPresent()) {
            log.error("User already exists");
            return null;
        }

        User user = User.builder()
                .username(userRequest.username())
                .password(PasswordUtils.getHashPassword(userRequest.password()))
                .name(userRequest.name())
                .email(userRequest.email())
                .phone(userRequest.phone())
                .role(userRequest.role())
                .address(userRequest.address())
                .build();

        repository.save(user);
        log.info("User created successfully");

        return new UserResponse(user.getUsername(), user.getName(),
                user.getEmail(), user.getPhone(), user.getRole());
    }

    @Override
    public List<UserResponse> getUsers() {

        return repository.findAll()
        .stream()
        .map(user -> new UserResponse(user.getUsername(), user.getName(),
                user.getEmail(), user.getPhone(), user.getRole()))
                .toList();
    }

    @Override
    public String resetPassword(String username, String oldPassword, String newPassword) {
        User user = repository.findById(username).orElse(null);

        if(user == null) {
            log.error("User not found");
            return "User not found";
        } else if (user.getPassword().equals(PasswordUtils.getHashPassword(oldPassword))) {
            user.setPassword(PasswordUtils.getHashPassword(newPassword));
            repository.save(user);
            log.info("Password reset successfully");
            return "Password reset successfully";
        }else {
            log.error("Invalid password");
            return "Invalid Old password";
        }
    }


    @Override
    public UserResponse getUserByUsername(String username) {
        User user = repository.findById(username).orElse(null);
        if (user != null) {
            return new UserResponse(user.getUsername(), user.getName(),
                    user.getEmail(), user.getPhone(), user.getRole());
        }
        return null;
    }

    @Override
    public String loginUser(String username, String password) {
        User user = repository.findById(username).orElse(null);
        if (user == null) {
            log.error("User not found");
            return "User not found";
        } else if (user.getPassword().equals(PasswordUtils.getHashPassword(password))) {
            log.info("User logged in successfully");
            return "User logged in successfully";
        } else {
            log.error("Invalid password");
            return "Invalid password";
        }
    }


}
