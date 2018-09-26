package com.yyc.aopdemo.cglibtest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/18: 17:55
 * @Description:
 */
public class JavaProxy implements InvocationHandler {
    private Object target;

    public Object getProxy(Object o) {
        this.target = o;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("开始");
        Object o = method.invoke(target, args);
        System.out.println("结束");
        return o;
    }



}
