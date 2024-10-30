package com.appitude.users.DTO;

import com.appitude.users.Entity.Address;
import com.appitude.users.Entity.UserRole;

public record UserResponse(String username, String name, String email, String phone, UserRole role) {
}
