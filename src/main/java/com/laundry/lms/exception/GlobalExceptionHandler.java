package com.laundry.lms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
//    we put the exception notations on a method and not a class dumb ass
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(IllegalArgumentExceptionHandler.class)
//    public ResponseEntity<ErrorResponse> errorResponse(IllegalArgumentExceptionHandler exception) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        errorResponse.setErrorMessage(exception.getMessage());
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }
//

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentExceptionHandler.class)
    public Map<String, String> illegalException(IllegalArgumentExceptionHandler exceptionHandler) {
        Map<String, String> map = new HashMap<>();
        map.put("errorMessage", exceptionHandler.getMessage());
        map.put("errorCode", "bad request");
        map.put("timestamp", String.valueOf(LocalDateTime.now()));
        return map;
    }


}
