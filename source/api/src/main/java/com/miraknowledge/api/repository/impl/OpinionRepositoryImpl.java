package com.miraknowledge.api.repository.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.miraknowledge.api.object.entity.OpinionEntity;
import com.miraknowledge.api.repository.OpinionRepository;
import com.miraknowledge.api.repository.jpa.KnowledgeJpaRepository;
import com.miraknowledge.api.repository.jpa.OpinionJpaRepository;

import lombok.RequiredArgsConstructor;

/**
 * 意見 リポジトリ実装
 */
@Repository
@RequiredArgsConstructor
public class OpinionRepositoryImpl implements OpinionRepository {
    private final KnowledgeJpaRepository knowledgeJpaRepository;
    private final OpinionJpaRepository opinionJpaRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OpinionEntity> findAll(Integer knowledgeId) {
        // 引数チェック
        if (Objects.isNull(knowledgeId)) {
            throw new IllegalArgumentException();
        }

        return opinionJpaRepository
            .findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void create(OpinionEntity opinionEntity) {
        // 引数チェック
        if (Objects.isNull(opinionEntity)) {
            throw new IllegalArgumentException();
        }
        // ナレッジID存在チェック
        if (BooleanUtils.isFalse(knowledgeJpaRepository.existsById(opinionEntity.getKnowledgeEntity().getId()))) {
            throw new IllegalArgumentException();
        }

        setCreateOpinionEntity(opinionEntity);
        opinionJpaRepository.save(opinionEntity);
    }

    /**
     * 新規作成に合わせた内容に更新
     * @param opinionEntity 意見
     */
    private void setCreateOpinionEntity(OpinionEntity opinionEntity) {
        // 意見IDが設定されていればクリア
        if (Objects.nonNull(opinionEntity.getId())) {
            opinionEntity.setId(null);
        }
        // 作成日時が設定されていなければ現在の日時を設定
        if (Objects.isNull(opinionEntity.getCreatedAt())) {
            opinionEntity.setCreatedAt(LocalDateTime.now());
        }
        // 更新日時が設定されていればクリア
        if (Objects.nonNull(opinionEntity.getUpdatedAt())) {
            opinionEntity.setUpdatedAt(null);
        }
    }
}
