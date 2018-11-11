package com.yyc.aopdemo.thread;


/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 09:54
 * @Description:
 */
public class ThreadTest {
    /**
     * 测试线程通讯
     */
    public static void main(String[] args) {
            MyList.clear();
            Object lock = new Object();
            ThreadC threadC = new ThreadC(lock);
            Thread c = new Thread(threadC);
            c.start();

            ThreadA threadA = new ThreadA(lock);
            Thread a = new Thread(threadA);
            a.start();

            ThreadB threadB = new ThreadB(lock);
            Thread b = new Thread(threadB);
            b.start();

            System.out.println("-------------------------------");

    }
}
