package com.umc.mwomeokji.domain.user.exception;

import com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails;
import com.umc.mwomeokji.global.error.exception.BusinessException;

public class DuplicateEmailException extends BusinessException {

    public DuplicateEmailException(ExceptionCodeAndDetails codeAndDetails) {
        super(codeAndDetails);
    }
}
