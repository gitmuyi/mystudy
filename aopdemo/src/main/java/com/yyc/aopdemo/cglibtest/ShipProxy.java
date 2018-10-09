package com.yyc.aopdemo.cglibtest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/18: 16:39
 * @Description:
 */
public class ShipProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class c) {
        enhancer.setSuperclass(c);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始日志");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("结束日志");
        return o1;
    }

    public static void main(String[] args) {
        ShipProxy proxy = new ShipProxy();
        Ship ship = (Ship) proxy.getProxy(Ship.class);
        ship.travel();
    }
}
