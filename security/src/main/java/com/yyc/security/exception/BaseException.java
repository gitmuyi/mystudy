package com.yyc.security.exception;

/**
 * 描述：
 * <p>
 *
 * @author: 赵新国
 * @date: 2018/4/11 23:06
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7210183188169604567L;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

