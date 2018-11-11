package com.yyc.aopdemo.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 14:20
 * @Description:
 */
public class CountDownLatchDemo{
    private static CountDownLatch countDownLatch = new CountDownLatch(7);
    private static final int THREAD_COUNT_NUM = 7;

    public static void main(String[] args) {
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> serachLongZhu(index)).start();

        }
        try {
            //等待检查，即上述7个线程执行完毕之后，执行await后边的代码
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("7个龙珠召唤齐了");
    }

    public static void serachLongZhu(int i) {
        System.out.println("我找到第:" + i + "个龙珠");
        countDownLatch.countDown();
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
