package com.miraknowledge.api.validator;

import java.util.Objects;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.miraknowledge.api.exception.BadRequestException;
import com.miraknowledge.api.exception.NotFoundException;
import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.repository.KnowledgeRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

/**
 * ナレッジ バリデーション
 */
@Component
@RequiredArgsConstructor
public class KnowledgeValidator {
    private final Validator validator;
    private final KnowledgeRepository knowledgeRepository;

    /**
     * ナレッジ情報取得
     * @param knowledgeId ナレッジID
     */
    public void validateFindById(Integer knowledgeId) {
        // Nullチェック
        if (Objects.isNull(knowledgeId)) {
            throw new BadRequestException();
        }

        // 存在チェック
        if (knowledgeRepository.existsById(knowledgeId)) {
            return;
        }

        throw new NotFoundException();
    }

    /**
     * ナレッジ新規作成
     * @param knowledgeCreateRequest ナレッジ新規作成 リクエスト
     */
    public void validateCreate(KnowledgeCreateRequest knowledgeCreateRequest) {
        // Nullチェック
        if (Objects.isNull(knowledgeCreateRequest)) {
            throw new BadRequestException();
        }

        // バリデーション チェック
        Set<ConstraintViolation<KnowledgeCreateRequest>> errorResult = validator.validate(knowledgeCreateRequest);
        if (errorResult.isEmpty()) {
            return;
        }

        throw new BadRequestException();
    }
}
