package com.umc.mwomeokji.global.error;

import com.umc.mwomeokji.global.error.exception.BusinessException;
import com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @Valid 에 대한 binding error 발생 시 발생
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ExceptionResponse response = ExceptionResponse.create(ExceptionCodeAndDetails.INVALID_INPUT_VALUE, e.getBindingResult());
        return ResponseEntity.status(BAD_REQUEST).body(response);
    }

    // 지원하지 않은 HTTP method 로 API 호출 시 발생
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ExceptionResponse response = ExceptionResponse.create(ExceptionCodeAndDetails.METHOD_NOT_ALLOWED);
        return ResponseEntity.status(METHOD_NOT_ALLOWED).body(response);
    }

    // 지정한 BusinessException 발생 시 발생
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException e) {
        ExceptionResponse response = ExceptionResponse.create(e.getCodeAndDetails());
        return ResponseEntity.status(e.getCodeAndDetails().getStatus()).body(response);
    }

    // 그 밖에 직접 handling 하지 않은 모든 예외가 모이는 곳
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception e) {
        ExceptionResponse response = ExceptionResponse.create(ExceptionCodeAndDetails.NOT_FOUND_ERROR_CODE);
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(response);
    }
}
