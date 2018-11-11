package com.yyc.aopdemo.thread;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 并发 读写
 *
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 13:12
 * @Description:
 */
public class ReentrantReadWriteLockDemo {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 测试入口
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        //测试读读共享
       /* new Thread(() -> demo.read(), "thread1-读").start();
        new Thread(() -> demo.read(), "thread2-读").start();*/
        //测试写写互斥
       /* new Thread(() -> demo.write(), "thread3-写").start();
        new Thread(() -> demo.write(), "thread4-写").start();*/
       //读写互斥 或者 写读互斥
        new Thread(() -> demo.read(), "thread5-读").start();
        Thread.sleep(30000);
        new Thread(() -> demo.write(), "thread6-写").start();

    }

    /**
     * 读读共享
     * 结果: 线程是同时的,一个时间点可以多个线程进行读操作
     * 获得读锁thread1 时间:1541913660365
     * 获得读锁thread2 时间:1541913660365
     * 读操作完成thread1 时间:1541913665365
     * 读操作完成thread2 时间:1541913665365
     */
    private void read() {
        lock.readLock().lock();
        System.out.println("获得读锁" + Thread.currentThread().getName()
                + " 时间:" + System.currentTimeMillis());
        //模拟读操作时间为5秒
        try {
            Thread.sleep(5000);
            System.out.println("读操作完成" + Thread.currentThread().getName()
                    + " 时间:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {//释放锁
            lock.readLock().unlock();
        }
    }

    /**
     * 写写互斥
     * 结果:   只能一个完事之后另一个再来
     * 获得写锁thread3-写 时间:1541914062624
     * 写完毕thread3-写 时间:1541914067625
     * 获得写锁thread4-写 时间:1541914067625
     * 写完毕thread4-写 时间:1541914072626
     */
    private void write() {
        lock.writeLock().lock();
        System.out.println("获得写锁" + Thread.currentThread().getName()
                + " 时间:" + System.currentTimeMillis());
        //模拟写操作使用了5秒
        try {
            Thread.sleep(5000);
            System.out.println("写完毕" + Thread.currentThread().getName()
                    + " 时间:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }


    }


}
