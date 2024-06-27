package com.miraknowledge.api.service;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.object.request.OpinionCreateRequest;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.repository.OpinionRepository;

import lombok.RequiredArgsConstructor;

/**
 * 意見 サービス
 */
@Service
@RequiredArgsConstructor
public class OpinionService {
    private final KnowledgeRepository knowledgeRepository;
    private final OpinionRepository opinionRepository;

    /**
     * 意見新規作成
     * @param opinionCreateRequest 意見新規作成 リクエスト
     */
    @Transactional
    public void create(OpinionCreateRequest opinionCreateRequest) {
        // Nullチェック
        if (Objects.isNull(opinionCreateRequest)) {
            throw new NullPointerException();
        }

        // 対象ナレッジ取得
        KnowledgeEntity knowledgeEntity = knowledgeRepository.findById(opinionCreateRequest.getKnowledgeId());
        // Nullチェック
        if (Objects.isNull(knowledgeEntity)) {
            throw new NullPointerException();
        }

        // 意見作成
        LocalDateTime createdAt = LocalDateTime.now();
        OpinionEntity opinionEntity = createOpinionEntity(opinionCreateRequest, knowledgeEntity, createdAt);
        // Nullチェック（現状到達不可能）
        if (Objects.isNull(opinionEntity)) {
            throw new NullPointerException();
        }

        // DB保存
        opinionRepository.create(opinionEntity);
    }

    /**
     * 意見 エンティティ作成
     * @param opinionCreateRequest 意見新規作成 リクエスト
     * @param knowledgeEntity ナレッジ
     * @param createdAt 作成日時
     * @return 意見 エンティティ
     */
    private OpinionEntity createOpinionEntity(OpinionCreateRequest opinionCreateRequest, KnowledgeEntity knowledgeEntity, LocalDateTime createdAt) {
        // Nullチェック
        if (Objects.isNull(opinionCreateRequest)) {
            return null;
        }
        if (Objects.isNull(knowledgeEntity)) {
            return null;
        }
        if (Objects.isNull(createdAt)) {
            return null;
        }

        return OpinionEntity
            .builder()
            .id(null)
            .knowledgeEntity(knowledgeEntity)
            .name(opinionCreateRequest.getName())
            .content(opinionCreateRequest.getContent())
            .createdAt(createdAt)
            .updatedAt(null)
            .build();
    }
}
