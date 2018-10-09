package com.yyc.websocketdemo;


import javax.validation.constraints.NotNull;

/**
 * @Auther: yangyongcui
 * @Date: 2018/9/27: 11:51
 * @Description:
 */
public class NullTest {
    @NotNull
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "NullTest{" +
                "str='" + str + '\'' +
                '}';
    }
}
