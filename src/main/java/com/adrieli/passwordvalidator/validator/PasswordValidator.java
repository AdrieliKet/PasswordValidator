package com.adrieli.passwordvalidator.validator;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class PasswordValidator {

    private static final int MINIMUM_LENGTH = 9;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    /**
     * Validates password according to the defined rules.
     */
    public boolean isValid(String password) {

        return isNotBlank(password)
                && hasMinimumLength(password, MINIMUM_LENGTH)
                && containsDigit(password)
                && containsLowerCase(password)
                && containsUpperCase(password)
                && containsSpecialCharacter(password)
                && hasNoRepeatedCharacters(password);
    }

    public boolean isNotBlank(String password) {
        return password != null && !password.isEmpty();
    }

    public boolean hasMinimumLength(String password, int minimumLength) {
        return password.length() >= minimumLength;
    }

    public boolean containsDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    public boolean hasNoRepeatedCharacters(String password) {

        Set<Character> characters = new HashSet<>();

        for (char c : password.toCharArray()) {
            if (!characters.add(c)) {
                return false;
            }
        }

        return true;
    }

}

