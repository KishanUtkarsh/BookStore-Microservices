package com.appitude.users.DTO;

import com.appitude.users.Entity.Address;
import com.appitude.users.Entity.UserRole;

public record UserRequest(String username, String password, String name, String email, String phone, UserRole role, Address address) {
}
