package com.miraknowledge.api.exception;

/**
 * 404エラー
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not Found.");
    }

    public NotFoundException(String message) {
       super(message);
    }
}
