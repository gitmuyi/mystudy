package com.yyc.aopdemo.entity;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/20: 15:06
 * @Description:
 */
public class Son extends Father {

    Son(){
        System.out.println("儿子构造");
    }
    public void sonSpeak() {
        System.out.println("我是儿子");
    }
}
