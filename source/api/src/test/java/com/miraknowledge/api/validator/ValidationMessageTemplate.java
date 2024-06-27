package com.miraknowledge.api.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

public class ValidationMessageTemplate {
    private final Validator validator;

    public ValidationMessageTemplate(Validator validator) {
        this.validator = validator;
    }

    public <T> void validTest(T target, String expected) {
        Set<ConstraintViolation<T>> violations = validator.validate(target);
        assertFalse(violations.isEmpty());
        List<String> actual = violations.stream().map(ConstraintViolation::getMessageTemplate).toList();
        assertEquals(1, actual.size());
        assertEquals(expected, actual.get(0));
    }
}
