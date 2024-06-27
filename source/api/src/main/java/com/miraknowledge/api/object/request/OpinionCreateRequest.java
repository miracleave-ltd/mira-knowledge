package com.miraknowledge.api.object.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.miraknowledge.api.annotation.KnowledgeIsExists;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

/**
 * 意見新規作成 リクエスト
 */
@Data
@Builder
public class OpinionCreateRequest {
    /**
     * ナレッジID
     */
    @KnowledgeIsExists
    @JsonProperty(value = "knowledge_id")
    private Integer knowledgeId;

    /**
     * 投稿者名
     */
    @NotNull
    @Size(min = 1, max = 60)
    @JsonProperty(value = "name")
    private String name;

    /**
     * 本文
     */
    @NotNull
    @Size(min = 1, max = 2000)
    @JsonProperty(value = "content")
    private String content;
}
