package com.adrieli.passwordvalidator.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordRequest {

    @NotBlank
    private String password;
}
