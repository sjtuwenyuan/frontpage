package com.wenyuan.seckill.exception;

/**
 * Created by Wen on 16/8/21.
 */
public class SeckillCloseException extends SeckillException {
    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillCloseException(String message) {

        super(message);
    }
}
