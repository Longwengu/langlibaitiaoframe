package com.apeframe.common.web.constant;

import lombok.Getter;

@Getter
public enum ResponseResultEnum {

    SUCCESS(200, "操作成功"),

    ERROR(500, "操作失败"),
    PARAMS_NOT_EXIST(501, "参数异常");

    private Integer code;
    private String msg;


    ResponseResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
