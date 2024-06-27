package com.miraknowledge.api.object.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * ナレッジ一覧 レスポンス
 */
@Data
@Builder
public class KnowledgeListResponse {
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
     * 最終更新日時
     */
    @JsonProperty(value = "latest_at", index = 4)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime latestAt;
}
