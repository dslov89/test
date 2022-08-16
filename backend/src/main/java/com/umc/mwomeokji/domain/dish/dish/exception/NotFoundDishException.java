package com.umc.mwomeokji.domain.dish.dish.exception;

import com.umc.mwomeokji.global.error.exception.BusinessException;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.NOT_FOUND_DISH;

public class NotFoundDishException extends BusinessException {

    public NotFoundDishException(){
        super(NOT_FOUND_DISH);
    }
}
