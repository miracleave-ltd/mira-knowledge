package com.miraknowledge.api.exception;

/**
 * 400エラー
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Bad Request.");
    }

    public BadRequestException(String message) {
       super(message);
    }
}
