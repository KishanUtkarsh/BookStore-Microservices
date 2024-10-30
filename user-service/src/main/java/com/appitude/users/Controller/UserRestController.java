package com.appitude.users.Controller;


import com.appitude.users.DTO.UserRequest;
import com.appitude.users.DTO.UserResponse;
import com.appitude.users.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService service;




    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest) {

        UserResponse response = service.createUser(userRequest);
        if (response == null) {
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }





    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        String response = service.loginUser(username, password);

        if (Objects.equals(response, "User logged in successfully")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUserByUserName(@RequestParam String username) {
        UserResponse response = service.getUserByUsername(username);
        if (response == null) {
            return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserResponse> getUsers() {
        return service.getUsers();
    }

    @PutMapping("/reset")
    public ResponseEntity<?> resetPassword(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) {
        String response = service.resetPassword(username, oldPassword, newPassword);
        if (Objects.equals(response, "Password reset successfully")) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
