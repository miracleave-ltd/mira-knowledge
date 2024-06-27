package com.miraknowledge.api.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.miraknowledge.api.exception.BadRequestException;
import com.miraknowledge.api.exception.NotFoundException;
import com.miraknowledge.api.object.response.ErrorResponse;

/**
 * エラー コントローラ
 */
@RestControllerAdvice
public class ApiControllerAdvice {
    /**
     * 400エラー
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ErrorResponse handleException(BadRequestException ex, WebRequest request) {
        // 引数チェック
        if (Objects.isNull(ex)) {
            throw new NullPointerException();
        }

        return ErrorResponse.builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .message(ex.getMessage())
            .build();
    }

    /**
     * 404エラー
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ErrorResponse handleException(NotFoundException ex, WebRequest request) {
        // 引数チェック
        if (Objects.isNull(ex)) {
            throw new NullPointerException();
        }

        return ErrorResponse.builder()
            .code(HttpStatus.NOT_FOUND.value())
            .message(ex.getMessage())
            .build();
    }

    /**
     * 500エラー
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception ex, WebRequest request) {
        // 引数チェック
        if (Objects.isNull(ex)) {
            throw new NullPointerException();
        }

        return ErrorResponse.builder()
            .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(ex.getMessage())
            .build();
    }
}
