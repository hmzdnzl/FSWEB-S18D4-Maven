package com.workintech.s18d1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {


@ExceptionHandler(BurgerException.class)
public ResponseEntity<BurgerErrorResponse> handleBurgerException(BurgerException exception) {
    log.error("BurgerException yakalandı: ", exception);
    BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
    return new ResponseEntity<>(burgerErrorResponse, exception.getHttpStatus());
}

@ExceptionHandler(Exception.class)
public ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {
    log.error("Genel Exception yakalandı: ", exception);
    BurgerErrorResponse burgerErrorResponse = new BurgerErrorResponse(exception.getMessage());
    return new ResponseEntity<>(burgerErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
}
}