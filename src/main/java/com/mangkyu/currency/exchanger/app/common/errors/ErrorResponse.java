package com.mangkyu.currency.exchanger.app.common.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@RequiredArgsConstructor
class ErrorResponse {

    private final String code;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private final List<ValidationError> errors;

    static ErrorResponse of(final String code, final String message) {
        return ErrorResponse.builder()
                .code(code)
                .message(message)
                .build();
    }

    static ErrorResponse of(final String code, final String message, final MethodArgumentNotValidException e) {
        return ErrorResponse.builder()
                .code(code)
                .message(message)
                .errors(ValidationError.of(e))
                .build();
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class ValidationError {
        private final String field;
        private final String message;

        private static ValidationError of(final FieldError fieldError) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }

        public static List<ValidationError> of(final MethodArgumentNotValidException e) {
            return e.getBindingResult().getFieldErrors()
                    .stream().map(ValidationError::of)
                    .collect(Collectors.toList());
        }
    }

}