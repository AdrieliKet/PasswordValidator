package com.adrieli.passwordvalidator.service;

import com.adrieli.passwordvalidator.validator.PasswordValidator;
import org.springframework.stereotype.Service;

@Service
public class PasswordValidationService {

    private final PasswordValidator validator;

    public PasswordValidationService(PasswordValidator validator) {
        this.validator = validator;
    }

    public boolean validatePassword(String password) {
        return validator.isValid(password);
    }
}

