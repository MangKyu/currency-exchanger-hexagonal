package com.mangkyu.currency.exchanger.app.common.errors;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
class ErrorResponse {

    private final String code;
    private final String message;

    static ErrorResponse of(final String code, final String message) {
        return ErrorResponse.builder()
                .code(code)
                .message(message)
                .build();
    }

}