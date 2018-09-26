package com.yyc.websocketdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/25: 16:09
 * @Description:
 */
@Controller
public class WebTest {
    @RequestMapping("/hello")
    public String helloHtml() {
        return "/hello";
    }

    @RequestMapping("/index1")
    public String index1() {
        return "/index1";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "/index2";
    }

    @RequestMapping("/index3")
    public String index3() {
        return "/index3";
    }


    @RequestMapping("/mess")
    @ResponseBody
    public void webTest(String message) {
        try {
            WebSocketServer.sendInfo(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
