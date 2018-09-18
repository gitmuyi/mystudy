package com.yyc.aopdemo;

import com.yyc.aopdemo.aspecttest.WriterTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AopdemoApplicationTests {

    @Test
    public void contextLoads() {
        WriterTest writerTest=new WriterTest();
        writerTest.speak();
    }

}
