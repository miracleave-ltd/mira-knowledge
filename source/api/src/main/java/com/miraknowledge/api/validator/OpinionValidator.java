package com.miraknowledge.api.validator;

import java.util.Set;

import org.springframework.stereotype.Component;

import com.miraknowledge.api.exception.BadRequestException;
import com.miraknowledge.api.object.request.OpinionCreateRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

/**
 * 意見 バリデーション
 */
@Component
@RequiredArgsConstructor
public class OpinionValidator {
    private final Validator validator;

    /**
     * 意見新規作成
     * @param opinionCreateRequest 意見新規作成 リクエスト
     */
    public void validateCreate(OpinionCreateRequest opinionCreateRequest) {
        Set<ConstraintViolation<OpinionCreateRequest>> errorResult = validator.validate(opinionCreateRequest);
        if (errorResult.isEmpty()) {
            return;
        }

        throw new BadRequestException();
    }
}
