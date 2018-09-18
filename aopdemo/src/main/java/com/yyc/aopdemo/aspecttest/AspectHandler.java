package com.yyc.aopdemo.aspecttest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/18: 11:16
 * @Description:
 */
@Aspect
@Component
public class AspectHandler {
    @Pointcut(" execution( * com.yyc.aopdemo..*.*(..))")
    public void doPoirt() {
    }


    @Before(value ="doPoirt()" )
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toString();
        Object result = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method name:" + methodName + "--value:" + result);
        System.out.println("kaishi");
    }

    @Around("doPoirt()")
    public Object doAround(ProceedingJoinPoint joinPoint) {
        try {
            Object obj = joinPoint.proceed();
            System.out.println(obj);
            return obj;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }
}
