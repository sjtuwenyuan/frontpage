package com.wenyuan.seckill.exception;

/**
 * Created by Wen on 16/8/21.
 */

/**
 * 重复秒杀异常
 */
public class RepeatKillException extends SeckillException {
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
