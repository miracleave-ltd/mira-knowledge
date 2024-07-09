package com.miraknowledge.api.validator.knowledge.create;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.validator.ValidationMessageTemplate;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@ExtendWith(MockitoExtension.class)
public class KnowledgeCreateRequestNameTest {
    Validator validator;
    ValidationMessageTemplate validationMessageTemplate;
    KnowledgeCreateRequest knowledgeCreateRequest;

    @BeforeEach
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        validationMessageTemplate = new ValidationMessageTemplate(validator);

        // 正常値
        knowledgeCreateRequest = KnowledgeCreateRequest
            .builder()
            .name("name")
            .title("title")
            .content("content")
            .build();
    }

    /**
     * 正常
     * @param len 文字列長
     */
    @ParameterizedTest
    @ValueSource(ints = { 1, 60 })
    public void testSizeOK(int len) {
        knowledgeCreateRequest.setName(RandomStringUtils.random(len));
        Set<ConstraintViolation<KnowledgeCreateRequest>> violations = validator.validate(knowledgeCreateRequest);
        assertTrue(violations.isEmpty());
    }

    /**
     * 異常：サイズ
     * @param len 文字列長
     */
    @ParameterizedTest
    @ValueSource(ints = { 0, 61 })
    public void testSizeNG(int len) {
        String expected = "{jakarta.validation.constraints.Size.message}";
        knowledgeCreateRequest.setName(RandomStringUtils.random(len));
        validationMessageTemplate.validTest(knowledgeCreateRequest, expected);
    }

    /**
     * 異常：null
     */
    @Test
    public void testNotNull() {
        String expected = "{jakarta.validation.constraints.NotNull.message}";
        knowledgeCreateRequest.setName(null);
        validationMessageTemplate.validTest(knowledgeCreateRequest, expected);
    }
}
