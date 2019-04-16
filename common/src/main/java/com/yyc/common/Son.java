package com.yyc.common;

/**
 * @Auther: yangyongcui
 * @Date: 2019/1/18: 13:44
 * @Description:
 */
public class Son extends Father {
    int num = 8;
}

class test1 {
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(((Son) f).num);
    }
}
