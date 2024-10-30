package com.appitude.users.Entity;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$", message = "Zip code is invalid")
    private String zipCode;

    @NotBlank(message = "Country is mandatory")
    private String country;

}
