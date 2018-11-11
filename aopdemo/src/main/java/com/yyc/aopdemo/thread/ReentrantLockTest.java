package com.yyc.aopdemo.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 12:27
 * @Description:
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Thread(() -> runMethod(lock), "thread1").start();
        new Thread(() -> runMethod(lock), "thread2").start();
        new Thread(() -> runMethod(lock), "thread3").start();
        new Thread(() -> runMethod(lock), "thread4").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runMethod(lock);
            }
        }, "thread5").start();


        new Thread(() -> runMethod(lock, 1000), "thread1").start();
        new Thread(() -> runMethod(lock, 2000), "thread2").start();
        new Thread(() -> runMethod(lock, 3000), "thread3").start();
        new Thread(() -> runMethod(lock, 4000), "thread4").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                runMethod(lock, 5000);
            }
        }, "thread5").start();
    }


    public static void runMethod(Lock lock) {
        lock.lock();
        for (int i = 0; i <= 5; i++) {
            System.out.println("ThreadName===" + Thread.currentThread().getName() + ("i=" + i));
        }
        System.out.println();
        lock.unlock();
    }

    /**
     * 有了锁机制  必须等到释放锁只会才能 其他的线程执行
     *
     * @param lock
     * @param sleepTime
     */
    public static void runMethod(Lock lock, long sleepTime) {
        lock.lock();
        try {
            Thread.sleep(sleepTime);
            System.out.println("ThreadName===" + Thread.currentThread().getName());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
