package com.miraknowledge.api.repository;

import java.util.List;

import com.miraknowledge.api.object.entity.OpinionEntity;

/**
 * 意見 リポジトリ
 */
public interface OpinionRepository {
    /**
     * 意見一覧取得
     * @param knowledgeId ナレッジID
     * @return 意見一覧
     */
    List<OpinionEntity> findAll(Integer knowledgeId);

    /**
     * 意見新規作成
     * @param opinionEntity 意見
     */
    void create(OpinionEntity opinionEntity);
}
