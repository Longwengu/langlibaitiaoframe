package com.apeframe.common.redis.exception;

public class ShareLockException extends RuntimeException{

    public ShareLockException(String msg) {
        super(msg);
    }
}
