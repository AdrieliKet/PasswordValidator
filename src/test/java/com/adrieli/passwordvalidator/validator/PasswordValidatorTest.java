package com.adrieli.passwordvalidator.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void shouldReturnTrueWhenPasswordIsValid() {
        assertTrue(validator.isValid("AbTp9!fok"));
    }

    @Test
    void shouldReturnFalseWhenPasswordIsNull() {
        assertFalse(validator.isValid(null));
    }

    @Test
    void shouldReturnFalseWhenPasswordIsEmpty() {
        assertFalse(validator.isValid(""));
    }

    @Test
    void shouldReturnFalseWhenPasswordContainsNoWhitespace() {
        assertFalse(validator.isValid(" "));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasLessThanNineCharacters() {
        assertFalse(validator.isValid("AbTp9!fo"));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasNoDigit() {
        assertFalse(validator.isValid("Abcdef!gh"));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasNoLowerCase() {
        assertFalse(validator.isValid("ABTP9!FOK"));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasNoUpperCase() {
        assertFalse(validator.isValid("abtp9!fok"));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasNoSpecialCharacter() {
        assertFalse(validator.isValid("AbTp9fokk"));
    }

    @Test
    void shouldReturnFalseWhenPasswordHasRepeatedCharacters() {
        assertFalse(validator.isValid("AbTp9!foo"));
    }

    @Test
    void shouldReturnFalseWhenPasswordContainsWhitespace() {
        assertFalse(validator.isValid("AbTp9 fok"));
    }

    @ParameterizedTest
    @CsvSource({
            "'aa', false",
            "'ab', false",
            "'AAAbbbCc', false",
            "'AbTp9!foA', false"
    })
    void shouldValidatePasswordsAccordingToProblemExamples(String password, boolean expected) {
        assertEquals(expected, validator.isValid(password));
    }


}
