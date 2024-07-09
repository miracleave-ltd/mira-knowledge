package com.miraknowledge.api.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.object.request.KnowledgeCreateRequest;
import com.miraknowledge.api.object.response.KnowledgeListResponse;
import com.miraknowledge.api.object.response.KnowledgeResponse;
import com.miraknowledge.api.object.response.OpinionResponse;
import com.miraknowledge.api.repository.KnowledgeRepository;

import lombok.RequiredArgsConstructor;

/**
 * ナレッジ サービス
 */
@Service
@RequiredArgsConstructor
public class KnowledgeService {
    private final KnowledgeRepository knowledgeRepository;

    /**
     * ナレッジ一覧取得
     * @return ナレッジ一覧 レスポンス
     */
    public List<KnowledgeListResponse> findAll() {
        List<KnowledgeEntity> knowledgeEntityList = knowledgeRepository.findAll();

        // 無ければ空配列を返す
        if (CollectionUtils.isEmpty(knowledgeEntityList)) {
            return new ArrayList<KnowledgeListResponse>();
        }

        return knowledgeEntityList
            .stream()
            .map(entity -> KnowledgeListResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .title(entity.getTitle())
                .content(entity.getContent())
                .latestAt(getLatestAt(entity))
                .build()
            )
            .toList();
    }

    /**
     * ナレッジ情報取得
     * @param knowledgeId ナレッジID
     * @return ナレッジ情報 レスポンス
     */
    public KnowledgeResponse findById(Integer knowledgeId) {
        // Nullチェック
        if (Objects.isNull(knowledgeId)) {
            throw new IllegalArgumentException();
        }

        // ナレッジ取得
        KnowledgeEntity knowledgeEntity = knowledgeRepository.findById(knowledgeId);
        // Nullチェック
        if (Objects.isNull(knowledgeEntity)) {
            throw new NullPointerException();
        }

        return KnowledgeResponse
            .builder()
            .id(knowledgeEntity.getId())
            .name(knowledgeEntity.getName())
            .title(knowledgeEntity.getTitle())
            .content(knowledgeEntity.getContent())
            .createdAt(knowledgeEntity.getCreatedAt())
            .updatedAt(knowledgeEntity.getUpdatedAt())
            .opinions(createOpinionResponseList(knowledgeEntity.getOpinionEntities()))
            .build();
    }

    /**
     * ナレッジ新規作成
     * @param knowledgeCreateRequest ナレッジ新規作成 リクエスト
     */
    @Transactional
    public void create(KnowledgeCreateRequest knowledgeCreateRequest) {
        // ナレッジ作成
        LocalDateTime createdAt = LocalDateTime.now();
        KnowledgeEntity knowledgeEntity = createKnowledgeEntity(knowledgeCreateRequest, createdAt);

        // Nullチェック
        if (Objects.isNull(knowledgeEntity)) {
            throw new NullPointerException();
        }

        // DB保存
        knowledgeRepository.create(knowledgeEntity);
    }

    /**
     * 最終更新日時取得
     * @param knowledgeEntity ナレッジ
     * @return 最終更新日時
     */
    private LocalDateTime getLatestAt(KnowledgeEntity knowledgeEntity) {
        // Nullチェック
        if (Objects.isNull(knowledgeEntity)) {
            throw new NullPointerException();
        }

        // 更新日時を優先的に利用
        if (Objects.isNull(knowledgeEntity.getUpdatedAt())) {
            return knowledgeEntity.getCreatedAt();
        }

        return knowledgeEntity.getUpdatedAt();
    }

    /**
     * 意見レスポンス一覧を作成
     * @param opinionEntityList 意見一覧
     * @return 意見レスポンス一覧
     */
    private List<OpinionResponse> createOpinionResponseList(List<OpinionEntity> opinionEntityList) {
        // 無ければ空配列を返す
        if (CollectionUtils.isEmpty(opinionEntityList)) {
            return new ArrayList<OpinionResponse>();
        }

        return opinionEntityList
            .stream()
            .map(entity -> OpinionResponse
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .content(entity.getContent())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build()
            )
            .toList();
    }

    /**
     * ナレッジ エンティティ作成
     * @param knowledgeCreateRequest ナレッジ新規作成 リクエスト
     * @param createdAt 作成日時
     * @return ナレッジ エンティティ
     */
    private KnowledgeEntity createKnowledgeEntity(KnowledgeCreateRequest knowledgeCreateRequest, LocalDateTime createdAt) {
        // Nullチェック
        if (Objects.isNull(knowledgeCreateRequest)) {
            return null;
        }
        if (Objects.isNull(createdAt)) {
            return null;
        }

        return KnowledgeEntity
            .builder()
            .id(null)
            .name(knowledgeCreateRequest.getName())
            .title(knowledgeCreateRequest.getTitle())
            .content(knowledgeCreateRequest.getContent())
            .createdAt(createdAt)
            .updatedAt(null)
            .build();
    }
}
