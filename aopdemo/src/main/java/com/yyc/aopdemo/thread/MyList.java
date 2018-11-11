package com.yyc.aopdemo.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/11: 09:45
 * @Description:
 */
public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("我是元素");
    }

    public static int size() {
        return list.size();
    }

    public static void clear() {
        list.clear();
    }
}
