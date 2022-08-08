package com.umc.mwomeokji.domain.question.exception;

import com.umc.mwomeokji.global.error.exception.BusinessException;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.NOT_FOUND_QUESTION;

public class NotFoundQuestionException extends BusinessException {

    public NotFoundQuestionException(){
        super(NOT_FOUND_QUESTION);
    }
}
