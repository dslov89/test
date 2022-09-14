package com.umc.mwomeokji.domain.dish.dish.exception;

import com.umc.mwomeokji.global.error.exception.BusinessException;
import com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails;

public class FileException extends BusinessException {

    public FileException(ExceptionCodeAndDetails codeAndDetails) {
        super(codeAndDetails);
    }
}
