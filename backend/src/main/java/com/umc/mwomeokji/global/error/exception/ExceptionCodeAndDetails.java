package com.umc.mwomeokji.global.error.exception;

import lombok.Getter;

@Getter
public enum ExceptionCodeAndDetails {

    // 0000: global
    NOT_FOUND_ERROR_CODE(500, "0001", "발생한 에러의 에러코드를 찾을 수 없습니다."),
    INVALID_INPUT_VALUE(400, "0002", "유효하지 않은 입력입니다."),
    METHOD_NOT_ALLOWED(405, "0003", "허용되지 않은 메소드 접근입니다. 올바른 HTTP Methods 를 입력해주세요."),
    INVALID_JSON_FORMAT(400, "0004", "유효하지 않은 json 형식입니다. 입력을 확인해주세요."),
    FILE_IO_EXCEPTION(500, "0005", "파일 입출력 과정에서 에러가 발생했습니다."),
    FILE_EXTENSION_EXCEPTION(400, "0006", "올바르지 않은 파일 확장자입니다."),
    FILE_SIZE_EXCEPTION(400, "0007", "파일 용량은 최대 10MB, 백엔드로의 request 최대 용량은 20MB 를 넘을 수 없습니다."),

    // 1000: dish
    NOT_FOUND_DISH(404, "1001", "해당하는 메뉴를 찾을 수 없습니다."),

    // 2000: question
    NOT_FOUND_QUESTION(404, "2001", "해당하는 질문을 찾을 수 없습니다."),

    // 3000: category
    NOT_FOUND_CATEGORY(404, "3001", "해당하는 카테고리를 찾을 수 없습니다."),


    // 9000: AWS
    AMAZON_SERVICE_EXCEPTION(500, "9001", "요청은 정상적으로 전달되었으나, AWS 내부 문제로 작업이 처리되지 않았습니다."),
    SDK_CLIENT_EXCEPTION(500, "9002", "자바 코드 내부의 문제로 인해 에러가 발생했습니다.")

    ;
    private final int status;
    private final String code;
    private final String message;

    ExceptionCodeAndDetails(int status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
