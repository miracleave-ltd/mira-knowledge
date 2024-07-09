package com.miraknowledge.api.object.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * ナレッジ新規作成 リクエスト
 */
@Data
@Builder
public class KnowledgeCreateRequest {
    /**
     * 投稿者名
     */
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty(value = "name")
    private String name;

    /**
     * タイトル
     */
    @NotNull
    @Size(min = 1, max = 100)
    @JsonProperty(value = "title")
    private String title;

    /**
     * 本文
     */
    @NotNull
    @Size(min = 1, max = 2000)
    @JsonProperty(value = "content")
    private String content;
}
