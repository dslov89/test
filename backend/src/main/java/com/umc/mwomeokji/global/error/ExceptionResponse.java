package com.umc.mwomeokji.global.error;

import com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExceptionResponse {

    private int status;
    private String code;
    private String message;
    private List<FieldException> exceptions;

    @Builder
    public ExceptionResponse(int status, String code, String message, List<FieldException> exceptions) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.exceptions = (exceptions == null) ? new ArrayList<>() : exceptions;
    }

    public static ExceptionResponse create(ExceptionCodeAndDetails codeAndDetails, BindingResult bindingResult) {
        return ExceptionResponse.builder()
                .status(codeAndDetails.getStatus())
                .code(codeAndDetails.getCode())
                .message(codeAndDetails.getMessage())
                .exceptions(FieldException.create(bindingResult))
                .build();
    }

    public static ExceptionResponse create(ExceptionCodeAndDetails codeAndDetails) {
        return ExceptionResponse.builder()
                .status(codeAndDetails.getStatus())
                .code(codeAndDetails.getCode())
                .message(codeAndDetails.getMessage())
                .build();
    }

    @Getter
    public static class FieldException {
        private String field;
        private String value;
        private String reason;

       @Builder
       public FieldException(String field, String value, String reason) {
            this.field = field;
            this.value = value;
            this.reason = reason;
       }

        private static List<FieldException> create(BindingResult bindingResult) {
            List<FieldError> fieldException = bindingResult.getFieldErrors();
            return fieldException.stream().
                    map(error -> new FieldException(
                        error.getField(),
                        (error.getRejectedValue() == null) ? null : error.getRejectedValue().toString(),
                        error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }
}


