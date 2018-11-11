package com.yyc.aopdemo.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 14:37
 * @Description:
 */
public class CyclicBarrierDemo {
    private static final int THREAD_COUNT_NUM = 7;

    public static void main(String[] args) {

        serach();
    }


    public static void serach() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("7个法师找齐,开始去找龙珠");

                serachLongZhu();
            }
        });
        System.out.println(cyclicBarrier.getNumberWaiting());

        //召集齐7位法师
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("召集第" + index + "个法师");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    public static void serachLongZhu() {
        //设置第二个屏障点，等待7位法师收集完7颗龙珠，召唤神龙
        CyclicBarrier summonDragonBarrier = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
          //所有线程执行完之的代码
            @Override
            public void run() {
                System.out.println("集齐七颗龙珠！召唤神龙！");
            }
        });
        //收集7颗龙珠
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("第" + index + "颗龙珠已收集到！");
                    summonDragonBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}

