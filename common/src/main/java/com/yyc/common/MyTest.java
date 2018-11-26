package com.yyc.common;

import com.yyc.common.utils.DateUtil;

import javax.xml.transform.Source;
import java.util.Date;

/**
 * @Auther: yangyongcui
 * @Date: 2018/11/26: 14:14
 * @Description:
 */
public class MyTest {
    public static void main(String[] args) {
        int dateElement = DateUtil.getDateElement(new Date(), 14);
        Date dateAddMilliSecond = DateUtil.getDateAddDay(new Date(), 1);
        System.out.println(dateAddMilliSecond);
        System.out.println(dateElement);
    }
}
