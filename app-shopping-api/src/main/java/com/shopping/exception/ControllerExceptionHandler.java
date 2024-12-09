package com.shopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage resourceNotFoundException(RecordNotFoundException ex, WebRequest request) {
        ErrorMessage message =
                new ErrorMessage(
                        HttpStatus.NOT_FOUND.value(),
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));

        return message;
    }

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage modelNotFoundException(ModelNotFoundException ex, WebRequest request) {
        ErrorMessage message =
                new ErrorMessage(
                        HttpStatus.NOT_FOUND.value(),
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));

        return message;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage generalException(AccessDeniedException ex, WebRequest request) {
        ErrorMessage message =
                new ErrorMessage(
                        HttpServletResponse.SC_FORBIDDEN,
                        new Date(),
                        "Access Denied: You do not have permission to access this resource.",
                        request.getDescription(false));

        return message;
    }
}
