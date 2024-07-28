package com.miraknowledge.api.object.response;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * ナレッジ情報 レスポンス
 */
@Data
@Builder
public class KnowledgeResponse {
    /**
     * ナレッジID
     */
    @JsonProperty(value = "id", index = 0)
    private Integer id;

    /**
     * 投稿者名
     */
    @JsonProperty(value = "name", index = 1)
    private String name;

    /**
     * タイトル
     */
    @JsonProperty(value = "title", index = 2)
    private String title;

    /**
     * 本文
     */
    @JsonProperty(value = "content", index = 3)
    private String content;

    /**
     * 作成日時
     */
    @JsonProperty(value = "created_at", index = 4)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @JsonProperty(value = "updated_at", index = 5)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime updatedAt;

    /**
     * 意見一覧
     */
    @JsonProperty(value = "opinions", index = 6)
    private List<OpinionResponse> opinions;
}