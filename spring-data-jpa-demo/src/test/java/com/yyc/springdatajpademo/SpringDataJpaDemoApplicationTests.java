package com.yyc.springdatajpademo;

import com.yyc.springdatajpademo.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaDemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private SysUserService sysUserService;

    private CountDownLatch countDownLatch = new CountDownLatch(2000);//并发

    @Test
    public void fingByUserName() {
        // System.out.println(sysUserService.findByUserName("13553008642"));

        for (int i = 0; i <= 2000; i++) {
            new Thread(new testQuery()).start();
            countDownLatch.countDown();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    class testQuery implements Runnable {

        @Override
        public void run() {
            try {
                countDownLatch.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(new Date());
            System.out.println(sysUserService.findByUserName("13553008642"));
        }
    }

    @Test
    public void test() {
        basePackage("com.yyc");
    }

    public void basePackage(String basePath) {
        String basePath1 = basePath.replaceAll("\\.", "/");
        URL url = this.getClass().getClassLoader().getResource(basePath1);
        String fileStr = url.getFile();
        File file = new File(fileStr);
        String[] filesStr = file.list();

        for (String path : filesStr) {
            File file2 = new File(fileStr + "\\"+path);
            if (file2.isDirectory()) {
                basePackage(basePath + "." + path);
            } else {
                System.out.println(basePath + "." + file2.getName());
            }
        }

    }
}
