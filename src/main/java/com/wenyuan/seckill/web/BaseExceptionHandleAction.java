package com.wenyuan.seckill.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseExceptionHandleAction {

    @ExceptionHandler
    public ResponseEntity<String> handleAndReturnData(HttpServletRequest request, HttpServletResponse response, Exception ex) {
        ResponseEntity<String> responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

}