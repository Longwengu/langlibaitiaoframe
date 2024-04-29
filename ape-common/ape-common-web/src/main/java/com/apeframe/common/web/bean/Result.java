package com.apeframe.common.web.bean;

import com.apeframe.common.web.constant.ResponseResultEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Result(){

    }
    private Boolean success;

    private Integer code;

    private String message;

    private T data;

    public static <T> Result ok(T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResponseResultEnum.SUCCESS.getCode());
        result.setMessage(ResponseResultEnum.SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static  Result ok(){
        Result result = new Result<>();
        result.setSuccess(true);
        result.setCode(ResponseResultEnum.SUCCESS.getCode());
        result.setMessage(ResponseResultEnum.SUCCESS.getMsg());
        return result;
    }



    public static <T> Result ok(ResponseResultEnum responseResultEnum, T data){
        Result<T> result = new Result<>();
        result.setSuccess(true);
        result.setCode(responseResultEnum.getCode());
        result.setMessage(responseResultEnum.getMsg());
        result.setData(data);
        return result;
    }

    //
    public static Result error(){
        Result result = new Result<>();
        result.setSuccess(false);
        result.setCode(ResponseResultEnum.ERROR.getCode());
        result.setMessage(ResponseResultEnum.ERROR.getMsg());
        return result;
    }



    public static Result error(ResponseResultEnum responseResultEnum){
        Result result = new Result<>();
        result.setSuccess(false);
        result.setCode(responseResultEnum.getCode());
        result.setMessage(responseResultEnum.getMsg());
        return result;
    }



}
