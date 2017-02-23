package com.wenyuan.seckill.exception;

/**
 * Created by Wen on 16/8/21.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillException(String message) {

        super(message);
    }
}
