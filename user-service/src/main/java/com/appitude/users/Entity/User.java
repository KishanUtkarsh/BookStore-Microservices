package com.appitude.users.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity(name = "users")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @NotBlank(message = "Username is mandatory")
    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    @Column(unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Role is mandatory")
    private UserRole role;

    @Embedded
    @NotNull(message = "Address is mandatory")
    private Address address;


}
