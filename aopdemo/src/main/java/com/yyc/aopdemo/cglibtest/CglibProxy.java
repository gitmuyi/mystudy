package com.yyc.aopdemo.cglibtest;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/18: 18:39
 * @Description:
 */
public class CglibProxy implements MethodInterceptor {
    //private Object target;//被代理对象

    //动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例
    public Object getProxy(Class clazz) {
        // this.target = object;
        //增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        //回调方法
        enhancer.setCallback(this);
        //设置生成类的父类类型
        enhancer.setSuperclass(clazz);
        //动态生成字节码并返回代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 开始");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println(o1);
        System.out.println("cglib 结束");
        return o1;
    }
}
