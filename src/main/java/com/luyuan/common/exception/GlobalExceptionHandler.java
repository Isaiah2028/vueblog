package com.luyuan.common.exception;


import com.luyuan.common.DbResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: IsaiahLu
 * @date: 2023/3/7 22:09
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    /*shiro异常*/
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public DbResponse handler(ShiroException e) {
        DbResponse response = new DbResponse();
        response.setCode(401);
        response.setMsg(e.getMessage());
        log.error("运行时异常============={}", e);
        return response;
    }


    /*全局异常*/
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public DbResponse handler(RuntimeException e) {
        DbResponse response = new DbResponse();
        response.setCode(400);
        response.setMsg(e.getMessage());
        log.error("运行时异常============={}", e);
        return response;
    }

}
