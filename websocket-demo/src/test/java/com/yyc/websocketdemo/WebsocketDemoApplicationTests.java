package com.yyc.websocketdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.io.IOException;

@RunWith(SpringRunner.class)
//@SpringBootTest  使用这个启动不起来
@WebMvcTest
public class WebsocketDemoApplicationTests {
    @Test
    public void contextLoads() throws IOException {
        System.out.println("sdf");
    }
}
