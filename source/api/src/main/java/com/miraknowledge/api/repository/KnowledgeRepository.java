package com.miraknowledge.api.repository;

import java.util.List;

import com.miraknowledge.api.object.entity.KnowledgeEntity;

/**
 * ナレッジ リポジトリ
 */
public interface KnowledgeRepository {
    /**
     * 存在チェック
     * @param knowledgeId ナレッジID
     * @return True：存在する、False：それ以外
     */
    boolean existsById(Integer knowledgeId);

    /**
     * ナレッジ一覧取得
     * @return ナレッジ一覧
     */
    List<KnowledgeEntity> findAll();

    /**
     * ナレッジ取得
     * @param knowledgeId ナレッジID
     * @return  ナレッジ
     */
    KnowledgeEntity findById(Integer knowledgeId);

    /**
     * ナレッジ新規作成
     * @param knowledgeEntity ナレッジ
     */
    void create(KnowledgeEntity knowledgeEntity);
}
