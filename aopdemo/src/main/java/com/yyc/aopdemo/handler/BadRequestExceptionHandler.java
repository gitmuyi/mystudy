package com.yyc.aopdemo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/16: 17:10
 * @Description:
 */
@Slf4j
@ControllerAdvice
public class BadRequestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> messages = new HashMap<>();
        BindingResult bindingResult = ex.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                FieldError fieldError = (FieldError) error;
                messages.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            logger.error(messages.toString());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messages);
    }
}