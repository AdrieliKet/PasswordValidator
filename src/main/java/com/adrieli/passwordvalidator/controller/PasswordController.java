package com.adrieli.passwordvalidator.controller;

import com.adrieli.passwordvalidator.dto.PasswordRequest;
import com.adrieli.passwordvalidator.dto.PasswordResponse;
import com.adrieli.passwordvalidator.service.PasswordValidationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/password")
public class PasswordController {

    private final PasswordValidationService service;

    public PasswordController(PasswordValidationService service) {
        this.service = service;
    }

    @PostMapping("/validate")
    public PasswordResponse validate(@RequestBody PasswordRequest request) {

        boolean valid = service.validatePassword(request.getPassword());

        return new PasswordResponse(valid);
    }
}

