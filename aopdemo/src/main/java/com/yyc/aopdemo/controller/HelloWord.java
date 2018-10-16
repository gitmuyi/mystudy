package com.yyc.aopdemo.controller;

import com.yyc.aopdemo.entity.Book;
import com.yyc.common.interfaces.Insert;
import com.yyc.common.interfaces.Update;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Auther: yangyongcui
 * @Date: 2018/10/15: 16:38
 * @Description:
 */
@Slf4j
@Controller
public class HelloWord {
    @RequestMapping("/hello/add")
    @ResponseBody
    public void hello() {
        System.out.println("hello");
    }

    @RequestMapping("/book/insert")
    @ResponseBody
    public String insert(@Validated({Insert.class}) Book book) {
        log.info("这是新增");
        System.out.println(book);
      /*  if(true){
            throw new Exception("故意错误");
        }*/
        return "新增";
    }

    @RequestMapping("/book/update")
    @ResponseBody
    public String update(@Validated(Update.class) Book book) {
        System.out.println(book);
        log.info("这是更新");
        return "更新";
    }
}
