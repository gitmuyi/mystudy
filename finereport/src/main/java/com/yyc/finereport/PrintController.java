package com.yyc.finereport;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: yangyongcui
 * @Date: 2019/4/16: 10:14
 * @Description:
 */
@Controller
public class PrintController {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
