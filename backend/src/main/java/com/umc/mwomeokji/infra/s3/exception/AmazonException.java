package com.umc.mwomeokji.infra.s3.exception;

import com.umc.mwomeokji.global.error.exception.BusinessException;
import com.umc.mwomeokji.global.error.exception.ExceptionCodeAndDetails;

public class AmazonException extends BusinessException {

    public AmazonException(ExceptionCodeAndDetails codeAndDetails) {
        super(codeAndDetails);
    }
}
