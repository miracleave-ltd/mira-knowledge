package com.miraknowledge.api.validator.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.exception.BadRequestException;
import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.validator.KnowledgeValidator;

import jakarta.validation.Validation;
import jakarta.validation.Validator;

@ExtendWith(MockitoExtension.class)
public class KnowledgeValidatorCreateTest {
    @Mock
    KnowledgeRepository knowledgeRepository;
    KnowledgeValidator knowledgeValidator;
    Validator validator;

    @BeforeEach
    public void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        knowledgeValidator = new KnowledgeValidator(validator, knowledgeRepository);
    }

    /**
     * 正常
     */
    @Test
    public void testOK() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = KnowledgeCreateRequest
            .builder()
            .name("name")
            .title("title")
            .content("content")
            .build();

        // テスト
        try {
            knowledgeValidator.validateCreate(knowledgeCreateRequest);
        }
        catch (Exception ex) {
            fail(ex);
        }
    }

    /**
     * 異常
     */
    @Test
    public void testNG() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = KnowledgeCreateRequest.builder().build();
        // 期待値
        String expected = "Bad Request.";

        // テスト
        String actual = assertThrows(BadRequestException.class, () -> knowledgeValidator.validateCreate(knowledgeCreateRequest)).getMessage();
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        KnowledgeCreateRequest knowledgeCreateRequest = null;
        // 期待値
        String expected = "Bad Request.";

        // テスト
        String actual = assertThrows(BadRequestException.class, () -> knowledgeValidator.validateCreate(knowledgeCreateRequest)).getMessage();
        assertEquals(expected, actual);
    }
}
