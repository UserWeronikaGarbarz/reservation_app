package com.reservation.exception;

import com.reservation.domain.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.nio.file.AccessDeniedException;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ExceptionHandling {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private static final String ACCOUNT_LOCKED = "Your account has been locked. Please contact administration";
    private static final String METHOD_IS_NOT_ALLOWED = "This request method is not allowed on this endpoint.";
    private static final String INTERNAL_SERVER_ERROR_MSG = "An error occured while processing the request";
    private static final String INCORRECT_CREDENTIALS = "Uername/password incorrect. Please try again";
    private static final String ACCOUNT_DISABLED = "Your account has been disabled. If this is an error please contact administration";
    private static final String ERROR_PROCESSING_FILE = "Error occured while processing file";
    private static final String NOT_ENOUGH_PERMISSION = "You do not have enough permission";

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<HttpResponse> accountDisabledException() {
        return createHttpResponse(ACCOUNT_DISABLED, BAD_REQUEST);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HttpResponse> badCredentialsException() {
        return createHttpResponse(INCORRECT_CREDENTIALS, BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<HttpResponse> accessDeniedException() {
        return createHttpResponse(NOT_ENOUGH_PERMISSION, FORBIDDEN);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity<HttpResponse> lockedException() {
        return createHttpResponse(ACCOUNT_LOCKED, UNAUTHORIZED);
    }

    @ExceptionHandler(EmailExistsException.class)
    public ResponseEntity<HttpResponse> emailExistsException(EmailExistsException exception) {
        return createHttpResponse(exception.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(UsernameExistsException.class)
    public ResponseEntity<HttpResponse> usernameExistsException(UsernameExistsException exception) {
        return createHttpResponse(exception.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    public ResponseEntity<HttpResponse> EmailNotFound(EmailNotFoundException exception) {
        return createHttpResponse(exception.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(GuestNotFoundException.class)
    public ResponseEntity<HttpResponse> guestNotFound(GuestNotFoundException exception) {
        return createHttpResponse(exception.getMessage(), BAD_REQUEST);
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<HttpResponse> restaurantNotFound(RestaurantNotFoundException exception) {
        return createHttpResponse(exception.getMessage(), BAD_REQUEST);
    }


    private ResponseEntity<HttpResponse> createHttpResponse(String message, HttpStatus httpStatus) {
        return new ResponseEntity<>(new HttpResponse(BAD_REQUEST.value(), BAD_REQUEST,
                BAD_REQUEST.getReasonPhrase().toUpperCase(),
                message.toUpperCase()), BAD_REQUEST);
    }
}
