package com.yyc.aopdemo;

import com.yyc.aopdemo.aspecttest.WriterTest;
import com.yyc.aopdemo.cglibtest.CglibProxy;
import com.yyc.aopdemo.cglibtest.IMath;
import com.yyc.aopdemo.cglibtest.JavaProxy;
import com.yyc.aopdemo.cglibtest.Math;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*@RunWith(SpringRunner.class)
@SpringBootTest*/
public class AopdemoApplicationTests {

    @Test
    public void contextLoads() {
        WriterTest writerTest = new WriterTest();
        writerTest.speak();
    }

    @Test
    public void testJava() {
        JavaProxy javaProxy = new JavaProxy();
        IMath math = (IMath) javaProxy.getProxy(new Math());
        math.add();
    }

    @Test
    public void testCglib() {
        CglibProxy cglibProxy = new CglibProxy();
        Math math = (Math) cglibProxy.getProxy(Math.class);
        math.add();
    }

    @Test
    public void test1() {
        Son son = new Son();
    }
}
