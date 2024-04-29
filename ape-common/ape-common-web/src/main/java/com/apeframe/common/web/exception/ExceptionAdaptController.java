package com.apeframe.common.web.exception;


import com.apeframe.common.web.bean.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdaptController {


    @ExceptionHandler({Exception.class})
    public Result exception(Exception e){
        e.printStackTrace();
        return Result.error();
    }


    @ExceptionHandler({RuntimeException.class})
    public Result runTimeException(RuntimeException e){
        e.printStackTrace();
        return Result.error();
    }
}
