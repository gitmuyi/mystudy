package com.yyc.aopdemo.entity;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/20: 15:05
 * @Description:
 */
public class Father {
    Father() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("父亲构造");
    }

    public static void print() {
        System.out.println("静态打印");
    }

    public void run() {
        System.out.println("我是你爸爸");
    }

    public static void main(String[] args) {
        Father.print();
    }
}
