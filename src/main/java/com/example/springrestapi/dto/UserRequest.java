package com.example.springrestapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    @NotBlank
    @Size(max = 100)
    private String name;

    @NotBlank
    @Email
    private String email;

    // getters y setters
}

