package com.yyc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/8/30: 12:26
 * @Description:
 */
public class Consume implements Runnable {
    private ThreadManager threadManager;

    Consume(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }


    @Override
    public void run() {
        threadManager.consume();
    }
}
