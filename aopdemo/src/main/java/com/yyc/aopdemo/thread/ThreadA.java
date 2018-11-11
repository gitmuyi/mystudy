package com.yyc.aopdemo.thread;

import java.io.InterruptedIOException;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 09:46
 * @Description:
 */
public class ThreadA implements Runnable {
    private Object lock;

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                    System.out.println("wait begin a" + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  a" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}