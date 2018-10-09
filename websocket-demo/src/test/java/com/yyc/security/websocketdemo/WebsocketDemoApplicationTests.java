package com.yyc.security.websocketdemo;

import com.yyc.websocketdemo.NullTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
//@SpringBootTest  使用这个启动不起来
@WebMvcTest
public class WebsocketDemoApplicationTests {
    @Test
    public void contextLoads() throws IOException {
        System.out.println("sdf");

        NullTest test=new NullTest();
        System.out.println(test.getStr());
    }
}
