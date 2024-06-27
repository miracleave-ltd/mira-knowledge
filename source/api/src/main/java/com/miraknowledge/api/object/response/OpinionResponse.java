package com.miraknowledge.api.object.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

/**
 * 意見 レスポンス
 */
@Data
@Builder
public class OpinionResponse {
    /**
     * 意見ID
     */
    @JsonProperty(value = "id", index = 0)
    private Integer id;

    /**
     * 投稿者名
     */
    @JsonProperty(value = "name", index = 1)
    private String name;

    /**
     * 本文
     */
    @JsonProperty(value = "content", index = 2)
    private String content;

    /**
     * 作成日時
     */
    @JsonProperty(value = "created_at", index = 3)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @JsonProperty(value = "updated_at", index = 4)
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
