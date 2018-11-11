package com.yyc.aopdemo.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多个等待条件
 *
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 12:41
 * @Description:
 */
public class LockConditionsDemo {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        LockConditionsDemo demo = new LockConditionsDemo();
        new Thread(() -> demo.aWait(demo.conditionA), "thread1--A").start();
        new Thread(() -> demo.aWait(demo.conditionB), "thread2--B").start();
        new Thread(() -> demo.signal(demo.conditionA), "thread3--A").start();
        Thread.sleep(5000);
        new Thread(() -> demo.signal(demo.conditionB), "thread4--B").start();
       /* 开始等待await！ ThreadName：thread1--A
        开始等待await！ ThreadName：thread2--B
        等待await结束！ ThreadName：thread1--A
        等待await结束！ ThreadName：thread2--B
        结果说明 可以通过条件进行分组的通知个等到
        */

    }

    private void aWait(Condition condition) {
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

    private void signal(Condition condition) {
        lock.lock();
        condition.signal();
      //  System.out.println("发送通知signal！ ThreadName：" + Thread.currentThread().getName());
        lock.unlock();
    }
}
