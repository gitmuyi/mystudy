package com.yyc.common;

import java.io.File;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/1: 21:17
 * @Description:
 */
public class FileDlete {
    public static void main(String[] args) {
        String path = "C:\\Users\\zdyyc\\Desktop\\a";
        File file = new File(path);
        del(file);

    }

    public static void del(File file) {
        File[] files = file.listFiles();
        System.out.println(files.length);
        for (File fi : files) {
            if (fi.isDirectory()) {
                del(fi);
            } else {
                fi.delete();
            }
        }
        file.delete();
    }
}
