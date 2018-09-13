package com.yyc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: yangyongcui
 * @Date: 2018/8/30: 12:26
 * @Description:
 */
public class Prount implements Runnable {
    private ThreadManager threadManager;

    Prount(ThreadManager threadManager) {
        this.threadManager = threadManager;
    }

    @Override
    public void run() {
        threadManager.produce();
    }
}
