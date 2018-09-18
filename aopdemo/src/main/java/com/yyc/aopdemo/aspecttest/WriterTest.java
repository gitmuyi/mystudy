package com.yyc.aopdemo.aspecttest;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/18: 11:12
 * @Description:
 */
@Controller
public class WriterTest {
    @RequestMapping("/speak")
    @ResponseBody
    public void speak() {
        System.out.println("说话了");
       // return "方法";
    }

    public void run() {
        System.out.println("跑了");
    }

}
