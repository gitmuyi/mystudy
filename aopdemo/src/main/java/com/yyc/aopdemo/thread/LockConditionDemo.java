package com.yyc.aopdemo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 12:41
 * @Description:
 */
public class LockConditionDemo {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        LockConditionDemo demo = new LockConditionDemo();
        new Thread(() -> demo.aWait(), "thread1").start();
        Thread.sleep(1000);
        new Thread(() -> demo.signal(), "thread2").start();

    }

    private void aWait() {
        lock.lock();
        System.out.println("开始等待await！ ThreadName：" + Thread.currentThread().getName());
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("等待await结束！ ThreadName：" + Thread.currentThread().getName());
    }

    private void signal() {
        lock.lock();
        condition.signal();
        System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }
}
