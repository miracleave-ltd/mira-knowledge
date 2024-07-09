package com.miraknowledge.api.annotation.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.miraknowledge.api.annotation.valid.KnowledgeIsExistsConstraintValidator;
import com.miraknowledge.api.repository.KnowledgeRepository;

import jakarta.validation.ConstraintValidatorContext;

@ExtendWith(MockitoExtension.class)
public class KnowledgeIsExistsConstraintValidatorTest {
    @InjectMocks
    KnowledgeIsExistsConstraintValidator knowledgeIsExistsConstraintValidator;
    @Mock
    KnowledgeRepository knowledgeRepository;

    /**
     * 存在する
     */
    @Test
    public void testTrue() {
        // 引数
        Integer value = 1;
        ConstraintValidatorContext context = null;
        // リポジトリ取得
        boolean isExists = true;

        // テスト
        doReturn(isExists).when(knowledgeRepository).existsById(value);
        assertTrue(knowledgeIsExistsConstraintValidator.isValid(value, context));
    }

    /**
     * 存在しない
     */
    @Test
    public void testFalse() {
        // 引数
        Integer value = -1;
        ConstraintValidatorContext context = null;
        // リポジトリ取得
        boolean isExists = false;

        // テスト
        doReturn(isExists).when(knowledgeRepository).existsById(value);
        assertFalse(knowledgeIsExistsConstraintValidator.isValid(value, context));
    }

    /**
     * isNull
     */
    @Test
    public void testNull() {
        // 引数
        Integer value = null;
        ConstraintValidatorContext context = null;

        // テスト
        assertFalse(knowledgeIsExistsConstraintValidator.isValid(value, context));
    }
}
