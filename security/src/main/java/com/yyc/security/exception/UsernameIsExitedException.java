package com.yyc.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author zhaoxinguo on 2017/9/13.
 */
public class UsernameIsExitedException extends AuthenticationException {

    private static final long serialVersionUID = 7021674812954562517L;

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}