package com.yyc.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.WritableResource;
import org.springframework.data.redis.core.RedisTemplate;
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
        System.out.println("resource1====" + resource1.getFilename());
        System.out.println("resource2====" + resource2.getFilename());

    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void getCar() {
    }
}
