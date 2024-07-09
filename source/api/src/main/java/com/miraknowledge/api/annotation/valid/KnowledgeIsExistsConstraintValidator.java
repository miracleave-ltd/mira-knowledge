package com.miraknowledge.api.annotation.valid;

import com.miraknowledge.api.annotation.KnowledgeIsExists;
import com.miraknowledge.api.repository.KnowledgeRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

/**
 * ナレッジID存在チェック バリデーション
 */
@RequiredArgsConstructor
public class KnowledgeIsExistsConstraintValidator implements ConstraintValidator<KnowledgeIsExists, Integer> {
    private final KnowledgeRepository knowledgeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        if (!knowledgeRepository.existsById(value)) {
            return false;
        }

        return true;
    }
}
