package com.umc.mwomeokji.global.error.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private ExceptionCodeAndDetails codeAndDetails;

    public BusinessException(ExceptionCodeAndDetails codeAndDetails) {
        super(codeAndDetails.getMessage());
        this.codeAndDetails = codeAndDetails;
    }
}
