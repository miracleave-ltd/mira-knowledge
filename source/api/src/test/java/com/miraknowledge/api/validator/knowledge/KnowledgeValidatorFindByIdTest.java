package com.miraknowledge.api.validator.knowledge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.exception.BadRequestException;
import com.miraknowledge.api.exception.NotFoundException;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.validator.KnowledgeValidator;

import jakarta.validation.Validator;

@ExtendWith(MockitoExtension.class)
public class KnowledgeValidatorFindByIdTest {
    @InjectMocks
    KnowledgeValidator knowledgeValidator;
    @Mock
    KnowledgeRepository knowledgeRepository;
    @Mock
    Validator validator;

    /**
     * isExists
     */
    @Test
    public void testIsExists() {
        // 引数
        Integer knowledgeId = 1;
        // リポジトリ取得
        boolean isExists = true;

        // テスト
        doReturn(isExists).when(knowledgeRepository).existsById(knowledgeId);
        try {
            knowledgeValidator.validateFindById(knowledgeId);
        } catch (Exception ex) {
            fail(ex);
        }
    }

    /**
     * isNotExists
     */
    @Test
    public void testIsNotExists() {
        // 引数
        Integer knowledgeId = -1;
        // リポジトリ取得
        boolean isExists = false;
        // 期待値
        String expected = "Not Found.";

        // テスト
        doReturn(isExists).when(knowledgeRepository).existsById(knowledgeId);
        String actual = assertThrows(NotFoundException.class, () -> knowledgeValidator.validateFindById(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        Integer knowledgeId = null;
        // 期待値
        String expected = "Bad Request.";

        // テスト
        String actual = assertThrows(BadRequestException.class, () -> knowledgeValidator.validateFindById(knowledgeId)).getMessage();
        assertEquals(expected, actual);
    }
}
