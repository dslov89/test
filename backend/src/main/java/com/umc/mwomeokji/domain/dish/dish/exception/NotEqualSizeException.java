package com.umc.mwomeokji.domain.dish.dish.exception;

import com.umc.mwomeokji.global.error.exception.BusinessException;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.NOT_EQUAL_SIZE;

public class NotEqualSizeException extends BusinessException {

    public NotEqualSizeException() { super(NOT_EQUAL_SIZE); }
}
