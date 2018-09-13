package com.yyc.security;

import com.yyc.security.service.MoGong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Auther: yangyongcui
 * @Date: 2018/8/25: 14:48
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {
    @Autowired
    private MoGong moGong;

    @Test
    public void low() {
        moGong.ask();
        String a = "Wee";
        char[] chars = a.toCharArray();
        chars[0] += 32;
        System.out.println(String.valueOf(chars));
    }

    @Test
    public void test1() {
        ThreadManager threadManager = new ThreadManager();
        Prount prount = new Prount(threadManager);
        Consume consume = new Consume(threadManager);

        Thread p = new Thread(prount);
        Thread p1 = new Thread(prount);
        Thread p2 = new Thread(prount);
        Thread p3 = new Thread(prount);
        Thread p4 = new Thread(prount);
        Thread p5 = new Thread(prount);
        Thread p6 = new Thread(prount);

        Thread c = new Thread(consume);
        Thread c1 = new Thread(consume);
        Thread c2 = new Thread(consume);
        Thread c3 = new Thread(consume);
        Thread c4 = new Thread(consume);
        Thread c5 = new Thread(consume);
        Thread c6 = new Thread(consume);
        Thread c7 = new Thread(consume);
        p.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();


        c.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
    }

    @Test
    public void getFile() throws IOException {
        String filePath = "F:\\work\\study\\security\\src\\main\\resources\\config\\file.txt";
        WritableResource resource1 = new PathResource(filePath);

        Resource resource2 = new ClassPathResource("config/file.txt");

        String description = resource2.getDescription();
        System.out.println(description);

        OutputStream stream = resource1.getOutputStream();

        stream.write("ssgggggssssssss".getBytes());
        stream.close();

        InputStream stream1 = resource1.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int i;
        while ((i = stream1.read()) != -1) {
            bos.write(i);
        }
        System.out.println(bos.toString());
        System.out.println("resource1===="+resource1.getFilename());
        System.out.println("resource2===="+resource2.getFilename());

    }
}
