package com.miraknowledge.api.repository.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.miraknowledge.api.object.entity.KnowledgeEntity;
import com.miraknowledge.api.repository.KnowledgeRepository;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;

import lombok.RequiredArgsConstructor;

/**
 * ナレッジ リポジトリ実装
 */
@Repository
@RequiredArgsConstructor
public class KnowledgeRepositoryImpl implements KnowledgeRepository {
    private final KnowledgeJpaRepository knowledgeJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean existsById(Integer knowledgeId) {
        // 引数チェック
        if (Objects.isNull(knowledgeId)) {
            throw new IllegalArgumentException();
        }

        return knowledgeJpaRepository
            .findById(knowledgeId)
            .isPresent();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<KnowledgeEntity> findAll() {
        return knowledgeJpaRepository
            .findAll(Sort.by(Sort.Direction.DESC, "createdAt"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public KnowledgeEntity findById(Integer knowledgeId) {
        // 引数チェック
        if (Objects.isNull(knowledgeId)) {
            throw new IllegalArgumentException();
        }

        // ナレッジ取得
        Optional<KnowledgeEntity> optional = knowledgeJpaRepository
            .findById(knowledgeId);

        // 存在チェック
        if (optional.isEmpty()) {
            return null;

        }

        return optional.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(KnowledgeEntity knowledgeEntity) {
        // 引数チェック
        if (Objects.isNull(knowledgeEntity)) {
            throw new IllegalArgumentException();
        }

        setCreateKnowledgeEntity(knowledgeEntity);
        knowledgeJpaRepository.save(knowledgeEntity);
    }

    /**
     * 新規作成に合わせた内容に更新
     * @param knowledgeEntity ナレッジ
     */
    private void setCreateKnowledgeEntity(KnowledgeEntity knowledgeEntity) {
        // ナレッジIDが設定されていればクリア
        if (Objects.nonNull(knowledgeEntity.getId())) {
            knowledgeEntity.setId(null);
        }
        // 作成日時が設定されていなければ現在の日時を設定
        if (Objects.isNull(knowledgeEntity.getCreatedAt())) {
            knowledgeEntity.setCreatedAt(LocalDateTime.now());
        }
        // 更新日時が設定されていればクリア
        if (Objects.nonNull(knowledgeEntity.getUpdatedAt())) {
            knowledgeEntity.setUpdatedAt(null);
        }
    }
}
