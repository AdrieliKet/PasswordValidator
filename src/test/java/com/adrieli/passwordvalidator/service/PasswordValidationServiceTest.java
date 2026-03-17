package com.adrieli.passwordvalidator.service;

import com.adrieli.passwordvalidator.validator.PasswordValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PasswordValidationServiceTest {

    @Mock
    private PasswordValidator validator;

    @InjectMocks
    private PasswordValidationService service;

    @Test
    void shouldReturnTrueWhenValidatorReturnsTrue() {

        when(validator.isValid("AbTp9!fok")).thenReturn(true);

        boolean result = service.validatePassword("AbTp9!fok");

        assertTrue(result);
    }

    @Test
    void shouldReturnFalseWhenValidatorReturnsFalse() {

        when(validator.isValid("aa")).thenReturn(false);

        boolean result = service.validatePassword("aa");

        assertFalse(result);
    }

    @Test
    void shouldCallValidator() {

        service.validatePassword("AbTp9!fok");

        verify(validator).isValid("AbTp9!fok");
    }


}

