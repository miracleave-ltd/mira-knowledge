package com.miraknowledge.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import com.miraknowledge.api.exception.BadRequestException;
import com.miraknowledge.api.object.response.ErrorResponse;

@ExtendWith(MockitoExtension.class)
public class ApiControllerAdviceTest {
    @InjectMocks
    ApiControllerAdvice apiControllerAdvice;

    /**
     * nonNull Bad Request
     */
    @Test
    public void testNonNullBadRequestException() {
        // 引数
        BadRequestException ex = new BadRequestException("bad request message");
        WebRequest request = null;
        // 期待値
        ErrorResponse expected = ErrorResponse
            .builder()
            .code(HttpStatus.BAD_REQUEST.value())
            .message(ex.getMessage())
            .build();

        // テスト
        ErrorResponse actual = apiControllerAdvice.handleException(ex, request);
        assertEquals(expected.getCode(), actual.getCode());
        assertEquals(expected.getMessage(), actual.getMessage());
    }

    /**
     * isNull Bad Request
     */
    @Test
    public void testIsNullBadRequestException() {
        // 引数
        BadRequestException ex = null;
        WebRequest request = null;
        // 期待値
        String expected = null;

        // テスト
        String actual = assertThrows(NullPointerException.class, () -> apiControllerAdvice.handleException(ex, request)).getMessage();
        assertEquals(expected, actual);
    }
}
