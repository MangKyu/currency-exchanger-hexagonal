package com.mangkyu.currency.exchanger.app.common.errors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<Object> handleBaseException(final CommonException e) {
        log.warn("handleBaseException", e);
        return handleExceptionInternal(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException e) {
        log.warn("handleMethodArgumentTypeMismatchException", e);
        return handleExceptionInternal(CommonErrorCode.INVALID_PARAMETER, "");
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            final MethodArgumentNotValidException e,
            final HttpHeaders headers,
            final HttpStatus status,
            final WebRequest request) {
        log.warn("handleMethodArgumentNotValid", e);
        return handleExceptionInternal(CommonErrorCode.INVALID_PARAMETER, e.getMessage());
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Object> handleAllException(final Exception e) {
        log.warn("handleAllException", e);
        return handleExceptionInternal(CommonErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());
    }


    private ResponseEntity<Object> handleExceptionInternal(final ErrorCode errorCode, final String message) {
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(ErrorResponse.of(errorCode.name(), makeMessage(errorCode, message)));
    }

    private String makeMessage(final ErrorCode errorCode, final String message) {
        return StringUtils.hasText(message)
                ? message
                : errorCode.getMessage();
    }

}