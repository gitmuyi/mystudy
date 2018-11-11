package com.yyc.aopdemo.thread;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 09:46
 * @Description:
 */
public class ThreadC implements Runnable {
    private Object lock;

    public ThreadC(Object lock) {
        super();
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                    System.out.println("wait begin c " + System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end  c" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




}