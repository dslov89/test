package com.umc.mwomeokji.domain.dish.category.exception;

import com.umc.mwomeokji.global.error.exception.BusinessException;

import static com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails.NOT_FOUND_CATEGORY;

public class NotFoundCategoryException extends BusinessException {

    public NotFoundCategoryException(){
        super(NOT_FOUND_CATEGORY);
    }
}
