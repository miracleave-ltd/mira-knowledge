package com.miraknowledge.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.miraknowledge.api.object.entity.OpinionEntity;

/**
 * 意見 JPAリポジトリ
 */
public interface OpinionJpaRepository
    extends JpaRepository<OpinionEntity, Integer>,
    JpaSpecificationExecutor<OpinionEntity> {

}
