package com.miraknowledge.api.object.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

/**
 * エラー レスポンス
 */
@Builder
@Getter
public class ErrorResponse {
    /**
     * コード
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "code", index = 0)
    private Integer code;

    /**
     * メッセージ
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value = "message", index = 1)
    private String message;
}
