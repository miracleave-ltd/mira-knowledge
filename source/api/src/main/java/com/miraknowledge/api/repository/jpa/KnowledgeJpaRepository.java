package com.miraknowledge.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.miraknowledge.api.object.entity.KnowledgeEntity;

/**
 * ナレッジ JPAリポジトリ
 */
public interface KnowledgeJpaRepository
    extends JpaRepository<KnowledgeEntity, Integer>,
    JpaSpecificationExecutor<KnowledgeEntity> {

}
