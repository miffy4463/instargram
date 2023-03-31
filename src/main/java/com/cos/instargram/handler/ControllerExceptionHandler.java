package com.cos.instargram.handler;

import com.cos.instargram.handler.ex.CustomValidationApiException;
import com.cos.instargram.handler.ex.CustomValidationException;
import com.cos.instargram.util.Script;
import com.cos.instargram.web.dto.CMResDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    public String validationException(CustomValidationException e) {
        return Script.back(e.getErrorMap().toString());
    }

    @ExceptionHandler(CustomValidationApiException.class)
    public ResponseEntity<CMResDto<?>> validationApiException(CustomValidationApiException e) {
        return new ResponseEntity<>(new CMResDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }
}
