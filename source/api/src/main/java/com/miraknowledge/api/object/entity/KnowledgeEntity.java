package com.miraknowledge.api.object.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ナレッジ
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "knowledge")
public class KnowledgeEntity implements Serializable {
    /**
     * ナレッジID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 投稿者名
     */
    @Column(name = "name", length = 60, nullable = false)
    private String name;

    /**
     * タイトル
     */
    @Column(name = "title", length = 100, nullable = false)
    private String title;

    /**
     * 本文
     */
    @Column(name = "content", length = 2000, nullable = false)
    private String content;

    /**
     * 作成日時
     */
    @CreatedDate
    @Column(name = "created_at", nullable = false, columnDefinition = "datetime")
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "datetime")
    private LocalDateTime updatedAt;

    /**
     * 意見 テーブル コレクション
     */
    @OneToMany(mappedBy = "knowledgeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OpinionEntity> opinionEntities;
}
